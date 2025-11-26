package com.grupo14.formulario_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "formularios")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}