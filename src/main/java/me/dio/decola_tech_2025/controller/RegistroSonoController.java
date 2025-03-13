package me.dio.decola_tech_2025.controller;

import me.dio.decola_tech_2025.domain.model.RegistroSono;
import me.dio.decola_tech_2025.domain.repository.RegistroSonoRepository;
import me.dio.decola_tech_2025.service.RegistroSonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/registro_sono")
public class RegistroSonoController {

    private final RegistroSonoService service;

    public RegistroSonoController(RegistroSonoService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegistroSono> create(@RequestBody RegistroSono registroSono) {

        RegistroSono novoRegistro = service.create(registroSono);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoRegistro.getId())
                .toUri();
        return ResponseEntity.created(location).body(novoRegistro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroSono> findById(@PathVariable Long id) {
        var user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroSono> update(@PathVariable Long id, @RequestBody RegistroSono registroSono) {
        RegistroSono registroAtualizado = service.update(id, registroSono);
        return ResponseEntity.ok(registroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}