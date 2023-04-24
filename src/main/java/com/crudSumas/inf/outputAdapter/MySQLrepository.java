package com.crudSumas.inf.outputAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.crudSumas.inf.outputPort.EntityRepository;

@Component
public class MySQLrepository implements EntityRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public <T> T save(T reg) {

        Field[] entityFields = reg.getClass().getDeclaredFields();
        // crea tres arrays, uno con el contenido de los campos de la clase, otro con el nombre del campo y otro con el metodo get
        String[] fields = new String[ entityFields.length ];
        Object[] fieldValues = new Object[ entityFields.length ];

        try {
            for ( int i=0; i<entityFields.length; i++ ) {
                fields[i] = entityFields[i].getName();
                fieldValues[i] = reg.getClass()
                    .getMethod( 
                        "get"+entityFields[i].getName().substring(0,1).toUpperCase()
                              +entityFields[i].getName().substring(1) //
                    ).invoke( reg );
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
            .append( reg.getClass().getSimpleName() )
            .append( "(" ).append( String.join( ",", fields) ).append( ")" )
            .append( " VALUES " )
            .append( "(" ).append( String.join( ",", Collections.nCopies( fields.length, "?") ) ).append( ")" );
            //crea una consulta con los campos a rellenar y como valor ? repetidas veces
        jdbcTemplate.update(sql.toString(), fieldValues);
            //jbdc se ocupa de rellenar las ? con los objetos que se le pansan en el siguiente parametro.
        return reg;
    } 

    @Override
    public <T> T getById( BigInteger id, Class<T> clazz ) {
        List<T> list = jdbcTemplate.query("SELECT * FROM "+clazz.getSimpleName()+" WHERE id = ?", 
            new LombokRowMapper<T>( clazz ), 
            id );
            //devuelde el primer valor si la lista no esta vacia, LombokRowMapper?
        if ( !list.isEmpty() ) return list.get(0);

        return null;
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return jdbcTemplate.query("SELECT * FROM "+clazz.getSimpleName(), new LombokRowMapper<T>( clazz ) );
    }

    private class LombokRowMapper<T> implements RowMapper<T> {
        private Class<?> clazz = null;

        public LombokRowMapper( Class<?> clazz ) {
            this.clazz = clazz;
        }
        
        @Override
        public T mapRow(ResultSet rs, int rowNum) throws SQLException {

            try {
                Method builderMethod = clazz.getMethod("builder");
                if ( builderMethod == null ) return null;

                Object row = builderMethod.invoke(null);
                Method[] m = row.getClass().getDeclaredMethods();

                for ( int i=0; i<m.length; i++ ) {
                    int pos = -1;
                    
                    try { pos = rs.findColumn(  m[i].getName()  ); } catch ( SQLException ex ) {  }
                    //intenta asignarle a pos el numero del metodo
                    if ( pos != -1 ) {
                        Object fieldValue = rs.getObject( pos );
                        //si habia metodo se crea un objeto con el
                        m[i].invoke( row, fieldValue );
                    }
                }

                return (T) row.getClass().getMethod("build").invoke(row); // row es null?

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }

            return null;
        }
        
    }
    
}