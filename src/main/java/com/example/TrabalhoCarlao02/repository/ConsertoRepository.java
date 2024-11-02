package com.example.TrabalhoCarlao02.repository;

import com.example.TrabalhoCarlao02.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Integer> {
    List<Conserto> findAllByAtivoTrue();
}
