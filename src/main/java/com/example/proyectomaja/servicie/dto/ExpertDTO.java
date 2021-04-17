package com.example.proyectomaja.servicie.dto;


import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ExpertDTO implements Serializable {

    private Long id;
    private String nombre;
    private String nif;


    private String createdBy;

    private Instant createdDate = Instant.now();

    private String lastModifiedBy;

    private Instant lastModifiedDate = Instant.now();


    private List<EtiquetaDTO> etiquetas = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<EtiquetaDTO> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<EtiquetaDTO> etiquetas) {
        this.etiquetas = etiquetas;
    }

//    /**
//     * Method equals
//     * @param o object to check equals
//     * @return boolean to detect unique record
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Expert)) {
//            return false;
//        }
//       // return id.equals(expert.id) && nombre.equals(expert.nombre);
//        return id != null && id.equals(((Expert) o).id) && nombre.equals(((Expert) o).nombre);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, nombre);
//    }

    @Override
    public String toString() {
        return "Expert{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}
