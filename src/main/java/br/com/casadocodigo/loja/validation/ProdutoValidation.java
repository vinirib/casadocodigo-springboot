package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.domain.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
        Produto produto = (Produto) target;
        if (produto.getPaginas() <= 0) {
            errors.rejectValue("paginas", "field.required");
        }
        if (produto.getTipoPrecos().get(0).getValor() == null
                || produto.getTipoPrecos().get(1).getValor() == null
                || produto.getTipoPrecos().get(2).getValor() == null) {

            errors.rejectValue("precos", "field.required");
        }
    }


}
