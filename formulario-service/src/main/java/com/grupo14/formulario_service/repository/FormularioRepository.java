package com.grupo14.formulario_service.repository;

import com.grupo14.formulario_service.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario,Integer> {
}
