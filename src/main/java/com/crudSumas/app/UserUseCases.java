package com.crudSumas.app;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crudSumas.dom.Usuario;
import com.crudSumas.inf.inputPort.UsuarioInP;
import com.crudSumas.inf.outputPort.EntityRepository;

public class UserUseCases implements UsuarioInP{
    
    @Autowired
    EntityRepository entityRepository;

    @Autowired
    UsuarioInP usuarioInP;

    @Override
    public Usuario createUser(String name, String email, Integer prio) {
        Usuario User = new Usuario();
        User.setNombre(name);
        User.setEmail(email);
        User.setPrioridad(prio);

        return entityRepository.save( User );
    }

    @Override
    public Usuario getById(BigInteger id) {
        return entityRepository.getById( id, Usuario.class );
    }

    @Override
    public List<Usuario> getAll() {
        return entityRepository.getAll( Usuario.class );
    }
    //modify and delete
}
