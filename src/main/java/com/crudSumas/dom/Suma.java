package com.crudSumas.dom;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity(name="suma")
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name="idUsuarioFK", 
            columnNames = "idusuario"    
        )
    }
)
public class Suma {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false, name="id")
    private BigInteger id;

    @Column(name="primernumero")
    private BigInteger primernumero;

    @Column(name="segundonumero")
    private BigInteger segundonumero;
    
    @Column(name="suma")
    private BigInteger suma;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Column(name="fec_creacion")
    private Date fec_creacion;

    @Column(name="usu_creacion")
    private String usu_creacion;

    @Column(name="fec_modificacion")
    private Date fec_modificacion;

    @Column(name="usu_modificacion")
    private String usu_modificacion;
    
    public Suma(){}

    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public BigInteger getPrimernumero() {
        return primernumero;
    }
    public void setPrimernumero(BigInteger primernumero) {
        this.primernumero = primernumero;
    }
    public BigInteger getSegundonumero() {
        return segundonumero;
    }
    public void setSegundonumero(BigInteger segundonumero) {
        this.segundonumero = segundonumero;
    }
    public BigInteger getSuma() {
        return suma;
    }
    public void setSuma(BigInteger suma) {
        this.suma = suma;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFec_creacion() {
        return fec_creacion;
    }
    public void setFec_creacion(Date fec_creacion) {
        this.fec_creacion = fec_creacion;
    }
    public String getUsu_creacion() {
        return usu_creacion;
    }
    public void setUsu_creacion(String usu_creacion) {
        this.usu_creacion = usu_creacion;
    }
    public Date getFec_modificacion() {
        return fec_modificacion;
    }
    public void setFec_modificacion(Date fec_modificacion) {
        this.fec_modificacion = fec_modificacion;
    }
    public String getUsu_modificacion() {
        return usu_modificacion;
    }
    public void setUsu_modificacion(String usu_modificacion) {
        this.usu_modificacion = usu_modificacion;
    }
    
    public String toJson() {
        return "{ \n\tid: " + id + 
        "\n\tprimernumero: "+ primernumero +
        "\n\tsegundonumero: "+ segundonumero +
        "\n\tsuma: " + suma +
        "\n\tusuario: " + usuario.getNombre() 
        +"\n}";
    }
}
