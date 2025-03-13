package me.dio.decola_tech_2025.service.impl;

import me.dio.decola_tech_2025.domain.model.RegistroSono;
import me.dio.decola_tech_2025.domain.repository.RegistroSonoRepository;
import me.dio.decola_tech_2025.service.RegistroSonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegistroSonoServiceImpl implements RegistroSonoService {

    private final RegistroSonoRepository repository;

    public RegistroSonoServiceImpl(RegistroSonoRepository repository) {
        this.repository = repository;
    }

    @Override
    public RegistroSono create(RegistroSono registroSonoToCreate) {

        Optional<RegistroSono> registro = repository.existsByRegistroSono(
                registroSonoToCreate.getBebeId(),
                registroSonoToCreate.getInicioSono(),
                registroSonoToCreate.getFimSono());
        registro.ifPresent(r -> {
            throw new IllegalArgumentException("Registro de sono já existe para este bebê.");
        });

        return repository.save(registroSonoToCreate);
    }

    @Override
    public void deletarRegistro(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Registro de sono não encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public RegistroSono findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    public RegistroSono update(Long id, RegistroSono novoRegistro) {
        RegistroSono registroExistente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Registro de sono não encontrado"));

        // Atualiza os campos necessários
        registroExistente.setInicioSono(novoRegistro.getInicioSono());
        registroExistente.setFimSono(novoRegistro.getFimSono());
        registroExistente.setBebeId(novoRegistro.getBebeId());
        registroExistente.setObservacoes(novoRegistro.getObservacoes());
        return repository.save(registroExistente); // Persiste no banco
    }
}
