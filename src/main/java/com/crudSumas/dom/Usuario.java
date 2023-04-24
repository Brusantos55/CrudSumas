package com.crudSumas.dom;

import javax.persistence.*;
import java.math.BigInteger;


@Entity(name="usuarios")
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name="usersMail_unique", 
            columnNames = "email"    
        )
    }
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, name="id")
    private BigInteger id;

    @Column(name="nombre")
    private String nombre;

    @Column(nullable = false, name="email")
    private String email;

    @Column(name="prioridad")
    private Integer prioridad;

    //no existe en la bd @JsonIgnore
    // @OneToMany(mappedBy = "suma")
    // private List<SumaModel> suma;

    public Usuario(){}

    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
    
}
