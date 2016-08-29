package com.pastor.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastor.projeto.model.Carro;

public interface Carros extends JpaRepository<Carro, Long> {

}
