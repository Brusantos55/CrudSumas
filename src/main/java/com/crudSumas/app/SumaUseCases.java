package com.crudSumas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudSumas.inf.outputPort.EntityRepository;
import com.crudSumas.inf.inputPort.UsuarioInP;
import com.crudSumas.inf.inputPort.SumaInP;
import com.crudSumas.dom.Suma;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SumaUseCases implements SumaInP{
    
    @Autowired
    EntityRepository entityRepository;

    @Autowired
    UsuarioInP usuarioInP;

    @Override
    public Suma createSuma(BigInteger n1, BigInteger n2, BigInteger id) {
        Suma newSuma = new Suma();
        newSuma.setPrimernumero(n1);
        newSuma.setSegundonumero(n2);
        newSuma.setSuma(n1.add(n2));
        newSuma.setUsu_modificacion(usuarioInP.getById(id).getNombre());
        newSuma.setUsuario(usuarioInP.getById(id));
        newSuma.setFec_creacion(new Date());

        return entityRepository.save( newSuma );
    }

    @Override
    public Suma getById(BigInteger id) {
        return entityRepository.getById( id, Suma.class );
    }

    @Override
    public List<Suma> getByUserId(BigInteger id) {
        List<Suma> sumas = entityRepository.getAll( Suma.class );
        List<Suma> sumasId = new ArrayList<Suma>();
        for (Suma suma: sumas) {
            if(suma.getUsuario().getId() == id){
                sumasId.add(suma);
            }
        }
        return sumas;
    }

    @Override
    public List<Suma> getAll() {
        return entityRepository.getAll( Suma.class );
    }
    //modify and delete
}
