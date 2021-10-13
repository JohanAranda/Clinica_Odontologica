package com.dh.clinicaCountry.repository.impl;

import com.dh.clinicaCountry.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
