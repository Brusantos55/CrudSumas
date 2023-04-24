package com.crudSumas.inf.inputPort;

import com.crudSumas.dom.Suma;

import java.math.BigInteger;
import java.util.List;

public interface SumaInP {
    
    public Suma createSuma(BigInteger n1, BigInteger n2, BigInteger id);

    public Suma getById(BigInteger Id);

    public List<Suma> getByUserId(BigInteger Id);

    public List<Suma> getAll();

}
