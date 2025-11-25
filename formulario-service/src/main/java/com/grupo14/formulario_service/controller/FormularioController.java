package com.grupo14.formulario_service.controller;

import com.grupo14.formulario_service.model.Formulario;
import com.grupo14.formulario_service.service.FormularioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formularios")
@CrossOrigin(origins = "*") // para que la app Android/otra pueda consumir
public class FormularioController {

    private final FormularioService service;

    public FormularioController(FormularioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Formulario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulario> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Formulario> create(@RequestBody Formulario formulario) {
        Formulario creado = service.save(formulario);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formulario> update(@PathVariable Integer id,
                                             @RequestBody Formulario formulario) {
        return service.update(id, formulario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean eliminado = service.delete(id);
        if (!eliminado) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
