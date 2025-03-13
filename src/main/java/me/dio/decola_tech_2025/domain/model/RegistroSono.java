package me.dio.decola_tech_2025.domain.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registros_sono")
 public class RegistroSono {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBebeId() {
        return bebeId;
    }

    public void setBebeId(Long bebeId) {
        this.bebeId = bebeId;
    }

    public LocalDateTime getInicioSono() {
        return inicioSono;
    }

    public void setInicioSono(LocalDateTime inicioSono) {
        this.inicioSono = inicioSono;
    }

    public LocalDateTime getFimSono() {
        return fimSono;
    }

    public void setFimSono(LocalDateTime fimSono) {
        this.fimSono = fimSono;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bebeId;

    @Column(nullable = false)
    private LocalDateTime inicioSono;

    @Column(nullable = false)
    private LocalDateTime fimSono;

    private String observacoes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}