package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;

public class ConceptoRedencion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idConceptoRedencion;
    private String codigo;
    private String nombre;

    public ConceptoRedencion() {
    }

    public Long getIdConceptoRedencion() {
        return idConceptoRedencion;
    }

    public void setIdConceptoRedencion(Long idConceptoRedencion) {
        this.idConceptoRedencion = idConceptoRedencion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
