package com.crudSumas.inf.inputPort;

import com.crudSumas.dom.Usuario;

import java.math.BigInteger;
import java.util.List;

public interface UsuarioInP {

    public Usuario createUser(String name, String email, Integer prio);

    public Usuario getById(BigInteger Id);

    public List<Usuario> getAll();
}
