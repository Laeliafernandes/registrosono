package me.dio.decola_tech_2025.service;

import me.dio.decola_tech_2025.domain.model.RegistroSono;

import java.util.List;

public interface RegistroSonoService {
    // Pesquisar
    RegistroSono findById(Long id);
    // Inclusão
    RegistroSono create(RegistroSono registroSono);
    // Deleção
    void delete(Long id);
    // Alteração.
    RegistroSono update(Long id, RegistroSono novoRegistro);
}
