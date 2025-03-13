package me.dio.decola_tech_2025.domain.repository;
import me.dio.decola_tech_2025.domain.model.RegistroSono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroSonoRepository extends JpaRepository<RegistroSono, Long> {
   // boolean existsByRegistroSono(Long bebeId, LocalDateTime inicioSono, LocalDateTime fimSono);

    @Query("SELECT sr FROM RegistroSono sr WHERE sr.bebeId = :bebeId AND sr.inicioSono = :inicioSono AND sr.fimSono = :fimSono")
    Optional<RegistroSono> existsByRegistroSono(
            @Param("bebeId") Long bebeId,
            @Param("inicioSono") LocalDateTime inicioSono,
            @Param("fimSono") LocalDateTime fimSono
    );
    List<RegistroSono> findByBebeIdAndInicioSonoAndFimSono(Long bebeId, LocalDateTime inicioSono, LocalDateTime fimSono);
}

