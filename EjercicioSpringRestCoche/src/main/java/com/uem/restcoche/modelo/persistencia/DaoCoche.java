package com.uem.restcoche.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.restcoche.modelo.entidad.Coche;

@Repository
public interface DaoCoche extends JpaRepository<Coche, Integer> {

}
