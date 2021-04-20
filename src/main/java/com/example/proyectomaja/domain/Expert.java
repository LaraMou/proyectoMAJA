package com.example.proyectomaja.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="expertos")
public class Expert {

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
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @ApiModelProperty("Formtato texto")
    private String motivo;
    @ApiModelProperty("Formato booleano: true = yes;false=no")
    @Type(type="yes_no")
    private Boolean disponibilidad;
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
    @Column(name="contacto_email",length = 254, unique = true)
    private String email;
    @Column(name="contacto_ciudad")
    private String direccion;
    @Column(name="contacto_linkedin")
    private String LinkedIn;


    @Column(name="condiciones_porcentaje")
    private Double porcentaje;
    @Column(name="condiciones_precio_hora")
    private Double precio;

    private Double puntuacion;

    //    @Basic(fetch=FetchType.LAZY)
//    @Lob @Column(name="foto")
//    private byte[] foto;
//    @Size(max = 256)
//    @Column(name = "image_url", length = 256)
//    private String imageUrl;
//    @Basic(fetch=FetchType.LAZY)
//    @Lob @Column(name="PIC")
//    private byte[] cv;
    private String origen;

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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "expert_etiqueta",
            joinColumns = {@JoinColumn(name="expert_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="etiqueta_id", referencedColumnName = "id")}
    )
    private List<Etiqueta> etiquetas = new ArrayList<>();

    /**
     * Constructor Empty
     */
    public Expert() {
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
        this.nif = nif;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
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
                ", estado=" + estado +
                ", motivo='" + motivo + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", modalidad='" + modalidad + '\'' +
                ", autonomo=" + autonomo +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", LinkedIn='" + LinkedIn + '\'' +
                ", porcentaje=" + porcentaje +
                ", precio=" + precio +
                ", puntuacion=" + puntuacion +
                ", origen='" + origen + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
