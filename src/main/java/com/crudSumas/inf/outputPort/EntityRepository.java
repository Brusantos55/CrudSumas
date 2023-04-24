package com.crudSumas.inf.outputPort;

import java.math.BigInteger;
import java.util.List;

public interface EntityRepository {

    public <T> T save( T reg );

    public <T> T getById( BigInteger id, Class<T> clas );

    public <T> List<T> getAll( Class<T> clas );
}
