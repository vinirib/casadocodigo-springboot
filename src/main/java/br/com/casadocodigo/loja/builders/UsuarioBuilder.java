package br.com.casadocodigo.loja.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import br.com.casadocodigo.loja.domain.Role;
import br.com.casadocodigo.loja.domain.Usuario;

public class UsuarioBuilder {

    private List<Usuario> usuarios = new ArrayList<>();
    
    private static Random random = new Random();
    
    private UsuarioBuilder(Usuario usuario) {
        usuarios.add(usuario);

    }

    public static UsuarioBuilder newUsuario(String role) {
        Usuario usuario = create(role);
        return new UsuarioBuilder(usuario);
    }

    public static UsuarioBuilder newUsuario() {
        Usuario usuario = create("admin");
        return new UsuarioBuilder(usuario);
    }

    private static Usuario create(String role) {
    	Role role2 = new Role();
    	role2.setName(role);
    	Usuario usuario = new Usuario();
    	usuario.setId(random.nextLong());
    	usuario.setName("Usuario" + random.nextInt(200));
    	usuario.setPassword("123");
    	usuario.setPasswordConfirm("123");
    	usuario.setRoles(new HashSet<>(Arrays.asList(role2)));
    	usuario.setUsername("user@user.com.br");
    	return usuario;
    }

    public UsuarioBuilder more(int number) {
        for (int i = 0; i < number; i++) {
            usuarios.add(create("admin"));
        }
        return this;
    }

    public Usuario buildOne() {
        return usuarios.get(0);
    }

    public List<Usuario> buildAll() {
        return usuarios;
    }
}
