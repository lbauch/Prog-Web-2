package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.projeto.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {

}
