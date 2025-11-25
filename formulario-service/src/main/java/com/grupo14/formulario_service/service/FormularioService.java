package com.grupo14.formulario_service.service;

import com.grupo14.formulario_service.model.Formulario;
import com.grupo14.formulario_service.repository.FormularioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioService {

    private final FormularioRepository repo;

    public FormularioService(FormularioRepository repo) {
        this.repo = repo;
    }

    public List<Formulario> findAll() {
        return repo.findAll();
    }

    public Optional<Formulario> findById(Integer id) {
        return repo.findById(id);
    }

    public Formulario save(Formulario formulario) {
        return repo.save(formulario);
    }

    public Optional<Formulario> update(Integer id, Formulario nuevo) {
        return repo.findById(id).map(actual -> {
            nuevo.setId(id);
            return repo.save(nuevo);
        });
    }

    public boolean delete(Integer id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
