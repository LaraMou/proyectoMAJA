package com.example.proyectomaja.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ApiModelProperty("Formato texto máximo 40 caracteres")
    private String nombre;



    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();
    @JsonIgnore
    @ManyToMany(mappedBy = "etiquetas", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Expert> experts = new ArrayList<>();

    public Etiqueta() {
    }

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

    public List<Expert> getExperts() {
        return experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Etiqueta)) return false;
//        Etiqueta etiqueta = (Etiqueta) o;
//        return nombre.equals(etiqueta.nombre);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nombre);
//    }


    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
