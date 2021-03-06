package com.example.proyectomaja.domain;

import com.example.proyectomaja.domain.validation.NifValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expertos")
public class Expert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    @Column(name="id")
    private Long id;
    @ApiModelProperty("Formato texto No puede ser nulo")
    @NotNull
    @Column(nullable = false)
    private String nombre;
    @ApiModelProperty("Formato texto patter: [[A-H][J-N][P-S]UVW][0-9]{7}[0-9A-J]")
    private String nif;


    @ApiModelProperty("Estado tipo Enum enum: VALIDADO, PENDIENTE, DESCARTADO ")
    private String estado;
    @ApiModelProperty("Formtato texto")
    private String motivo;
    @ApiModelProperty("Seleccion Mañana, Tarde , Otros")

    private String disponibilidad;
    @ApiModelProperty("Formtato texto")
    private String modalidad;
    @ApiModelProperty("Formato booleano: true = yes;false=no")
    @Type(type="yes_no")
    private Boolean autonomo;

    @ApiModelProperty("Campos relacionados con el contacto")
    @NotNull
    @Column(name="contacto_telefono", nullable = false)
    private String telefono;
    @Email
    @Size(min = 5, max = 254)
    //todo unique
    @Column(name="contacto_email",length = 254)
    private String email;
    @Column(name="contacto_ciudad")
    private String ciudad;
    private String direccion;
    @Column(name="contacto_linkedin")
    private String LinkedIn;


    @Column(name="condiciones_porcentaje")
    private Double porcentaje;
    @Column(name="condiciones_precio_hora")
    private Double precio;

    private Double puntuacion;

    private String imageUrl;
    private String cv;
    private String origen;
    @Column(length = 4000)
    private String observaciones;

    /**
     * Auditory Attributes
     */
    @ApiModelProperty("Fecha creación entidad formato fecha. Autogenerado")
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();
    @ApiModelProperty("Fecha ultima modifcación entidad formato fecha. Autogenerado ")
    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();


    @ApiModelProperty("Entidad relacionada many to many etiquetas")
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "expert_tag",
            joinColumns = {@JoinColumn(name = "expert_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    @JsonIgnoreProperties("experts")
    private List<Etiqueta> etiquetas = new ArrayList<>();

    /**
     * Constructor Empty
     */
    public Expert() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        NifValidator nifValildator = new NifValidator(nif);
        Boolean valido = nifValildator.NIF(nif);
        if(valido==true){
            this.nif = nif;
        }else{
            this.nif = "error";
        }

    }

    public Expert(String nombre, String nif, String estado, String motivo, String disponibilidad, String modalidad, Boolean autonomo, String telefono, String email, String ciudad, String direccion, String linkedIn, Double porcentaje, Double precio, Double puntuacion, String imageUrl, String cv, String origen, String observaciones, Instant createdDate, Instant lastModifiedDate) {
        this.nombre = nombre;
        this.nif = nif;
        this.estado = estado;
        this.motivo = motivo;
        this.disponibilidad = disponibilidad;
        this.modalidad = modalidad;
        this.autonomo = autonomo;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.direccion = direccion;
        LinkedIn = linkedIn;
        this.porcentaje = porcentaje;
        this.precio = precio;
        this.puntuacion = puntuacion;
        this.imageUrl = imageUrl;
        this.cv = cv;
        this.origen = origen;
        this.observaciones = observaciones;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }



    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Boolean getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Boolean autonomo) {
        this.autonomo = autonomo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }


}
