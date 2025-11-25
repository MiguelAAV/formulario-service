package com.grupo14.formulario_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "formularios")
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //  DENUNCIADO
    @NotBlank(message = "El nombre del denunciado no puede estar vacío")
    @Size(max = 100)
    private String denunciadoNombre;

    @NotBlank(message = "El apellido paterno del denunciado es obligatorio")
    @Size(max = 100)
    private String denunciadoApellidoPaterno;

    @Size(max = 100)
    private String denunciadoApellidoMaterno;

    @NotBlank(message = "El RUT del denunciado es obligatorio")
    @Pattern(regexp = "^[0-9\\.\\-kK]+$", message = "Formato de RUT inválido")
    private String denunciadoRut;

    @Size(max = 100)
    private String denunciadoCargo;

    @Size(max = 100)
    private String denunciadoArea;

    // REPRESENTANTE
    @Size(max = 100)
    private String representanteNombre;

    @Size(max = 100)
    private String representanteApellidoPaterno;

    @Size(max = 100)
    private String representanteApellidoMaterno;

    @Pattern(regexp = "^[0-9\\.\\-kK]*$", message = "Formato de RUT inválido")
    private String representanteRut;

    private String representanteCargo;
    private String representanteArea;

    //  VÍCTIMA
    private String victimaNombre;
    private String victimaApellidoPaterno;
    private String victimaApellidoMaterno;

    @Pattern(regexp = "^[0-9\\.\\-kK]*$", message = "Formato de RUT inválido")
    private String victimaRut;

    private String victimaCargo;
    private String victimaArea;

    //  TESTIGO
    private String testigoNombre;
    private String testigoApellidoPaterno;
    private String testigoApellidoMaterno;

    @Pattern(regexp = "^[0-9\\.\\-kK]*$", message = "Formato de RUT inválido")
    private String testigoRut;

    private String testigoCargo;
    private String testigoArea;

    //  TIPO DE DENUNCIA
    @NotNull(message = "Debe especificar al menos un tipo de denuncia")
    private String tiposSeleccionados;

    private Boolean relacionAsimetricaVictimaDepende;
    private Boolean relacionAsimetricaDenunciadoDepende;
    private Boolean relacionSimetricaMismaArea;
    private Boolean relacionSimetricaDistintaArea;

    //  EVIDENCIAS
    private Boolean evidenciaExistente;
    private Boolean otrosAntecedentes;
    private Boolean informadaPreviamente;
    private Boolean cuentaConTestigos;

    //  RELATO
    @Column(columnDefinition = "TEXT")
    private String relatoTexto;

    @Size(max = 255)
    private String relatoAudioPath;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //  CONSTRUCTOR
    public Formulario() {}

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenunciadoNombre() {
        return denunciadoNombre;
    }

    public void setDenunciadoNombre(String denunciadoNombre) {
        this.denunciadoNombre = denunciadoNombre;
    }

    public String getDenunciadoApellidoPaterno() {
        return denunciadoApellidoPaterno;
    }

    public void setDenunciadoApellidoPaterno(String denunciadoApellidoPaterno) {
        this.denunciadoApellidoPaterno = denunciadoApellidoPaterno;
    }

    public String getDenunciadoApellidoMaterno() {
        return denunciadoApellidoMaterno;
    }

    public void setDenunciadoApellidoMaterno(String denunciadoApellidoMaterno) {
        this.denunciadoApellidoMaterno = denunciadoApellidoMaterno;
    }

    public String getDenunciadoRut() {
        return denunciadoRut;
    }

    public void setDenunciadoRut(String denunciadoRut) {
        this.denunciadoRut = denunciadoRut;
    }

    public String getDenunciadoCargo() {
        return denunciadoCargo;
    }

    public void setDenunciadoCargo(String denunciadoCargo) {
        this.denunciadoCargo = denunciadoCargo;
    }

    public String getDenunciadoArea() {
        return denunciadoArea;
    }

    public void setDenunciadoArea(String denunciadoArea) {
        this.denunciadoArea = denunciadoArea;
    }

    public String getRepresentanteNombre() {
        return representanteNombre;
    }

    public void setRepresentanteNombre(String representanteNombre) {
        this.representanteNombre = representanteNombre;
    }

    public String getRepresentanteApellidoPaterno() {
        return representanteApellidoPaterno;
    }

    public void setRepresentanteApellidoPaterno(String representanteApellidoPaterno) {
        this.representanteApellidoPaterno = representanteApellidoPaterno;
    }

    public String getRepresentanteApellidoMaterno() {
        return representanteApellidoMaterno;
    }

    public void setRepresentanteApellidoMaterno(String representanteApellidoMaterno) {
        this.representanteApellidoMaterno = representanteApellidoMaterno;
    }

    public String getRepresentanteRut() {
        return representanteRut;
    }

    public void setRepresentanteRut(String representanteRut) {
        this.representanteRut = representanteRut;
    }

    public String getRepresentanteCargo() {
        return representanteCargo;
    }

    public void setRepresentanteCargo(String representanteCargo) {
        this.representanteCargo = representanteCargo;
    }

    public String getRepresentanteArea() {
        return representanteArea;
    }

    public void setRepresentanteArea(String representanteArea) {
        this.representanteArea = representanteArea;
    }

    public String getVictimaNombre() {
        return victimaNombre;
    }

    public void setVictimaNombre(String victimaNombre) {
        this.victimaNombre = victimaNombre;
    }

    public String getVictimaApellidoPaterno() {
        return victimaApellidoPaterno;
    }

    public void setVictimaApellidoPaterno(String victimaApellidoPaterno) {
        this.victimaApellidoPaterno = victimaApellidoPaterno;
    }

    public String getVictimaApellidoMaterno() {
        return victimaApellidoMaterno;
    }

    public void setVictimaApellidoMaterno(String victimaApellidoMaterno) {
        this.victimaApellidoMaterno = victimaApellidoMaterno;
    }

    public String getVictimaRut() {
        return victimaRut;
    }

    public void setVictimaRut(String victimaRut) {
        this.victimaRut = victimaRut;
    }

    public String getVictimaCargo() {
        return victimaCargo;
    }

    public void setVictimaCargo(String victimaCargo) {
        this.victimaCargo = victimaCargo;
    }

    public String getVictimaArea() {
        return victimaArea;
    }

    public void setVictimaArea(String victimaArea) {
        this.victimaArea = victimaArea;
    }

    public String getTestigoNombre() {
        return testigoNombre;
    }

    public void setTestigoNombre(String testigoNombre) {
        this.testigoNombre = testigoNombre;
    }

    public String getTestigoApellidoPaterno() {
        return testigoApellidoPaterno;
    }

    public void setTestigoApellidoPaterno(String testigoApellidoPaterno) {
        this.testigoApellidoPaterno = testigoApellidoPaterno;
    }

    public String getTestigoApellidoMaterno() {
        return testigoApellidoMaterno;
    }

    public void setTestigoApellidoMaterno(String testigoApellidoMaterno) {
        this.testigoApellidoMaterno = testigoApellidoMaterno;
    }

    public String getTestigoRut() {
        return testigoRut;
    }

    public void setTestigoRut(String testigoRut) {
        this.testigoRut = testigoRut;
    }

    public String getTestigoCargo() {
        return testigoCargo;
    }

    public void setTestigoCargo(String testigoCargo) {
        this.testigoCargo = testigoCargo;
    }

    public String getTestigoArea() {
        return testigoArea;
    }

    public void setTestigoArea(String testigoArea) {
        this.testigoArea = testigoArea;
    }

    public String getTiposSeleccionados() {
        return tiposSeleccionados;
    }

    public void setTiposSeleccionados(String tiposSeleccionados) {
        this.tiposSeleccionados = tiposSeleccionados;
    }

    public Boolean getRelacionAsimetricaVictimaDepende() {
        return relacionAsimetricaVictimaDepende;
    }

    public void setRelacionAsimetricaVictimaDepende(Boolean relacionAsimetricaVictimaDepende) {
        this.relacionAsimetricaVictimaDepende = relacionAsimetricaVictimaDepende;
    }

    public Boolean getRelacionAsimetricaDenunciadoDepende() {
        return relacionAsimetricaDenunciadoDepende;
    }

    public void setRelacionAsimetricaDenunciadoDepende(Boolean relacionAsimetricaDenunciadoDepende) {
        this.relacionAsimetricaDenunciadoDepende = relacionAsimetricaDenunciadoDepende;
    }

    public Boolean getRelacionSimetricaMismaArea() {
        return relacionSimetricaMismaArea;
    }

    public void setRelacionSimetricaMismaArea(Boolean relacionSimetricaMismaArea) {
        this.relacionSimetricaMismaArea = relacionSimetricaMismaArea;
    }

    public Boolean getRelacionSimetricaDistintaArea() {
        return relacionSimetricaDistintaArea;
    }

    public void setRelacionSimetricaDistintaArea(Boolean relacionSimetricaDistintaArea) {
        this.relacionSimetricaDistintaArea = relacionSimetricaDistintaArea;
    }

    public Boolean getEvidenciaExistente() {
        return evidenciaExistente;
    }

    public void setEvidenciaExistente(Boolean evidenciaExistente) {
        this.evidenciaExistente = evidenciaExistente;
    }

    public Boolean getOtrosAntecedentes() {
        return otrosAntecedentes;
    }

    public void setOtrosAntecedentes(Boolean otrosAntecedentes) {
        this.otrosAntecedentes = otrosAntecedentes;
    }

    public Boolean getInformadaPreviamente() {
        return informadaPreviamente;
    }

    public void setInformadaPreviamente(Boolean informadaPreviamente) {
        this.informadaPreviamente = informadaPreviamente;
    }

    public Boolean getCuentaConTestigos() {
        return cuentaConTestigos;
    }

    public void setCuentaConTestigos(Boolean cuentaConTestigos) {
        this.cuentaConTestigos = cuentaConTestigos;
    }

    public String getRelatoTexto() {
        return relatoTexto;
    }

    public void setRelatoTexto(String relatoTexto) {
        this.relatoTexto = relatoTexto;
    }

    public String getRelatoAudioPath() {
        return relatoAudioPath;
    }

    public void setRelatoAudioPath(String relatoAudioPath) {
        this.relatoAudioPath = relatoAudioPath;
    }
}
