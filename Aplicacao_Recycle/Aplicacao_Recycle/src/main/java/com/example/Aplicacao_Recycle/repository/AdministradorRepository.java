package com.example.Aplicacao_Recycle.repository;

import com.example.Aplicacao_Recycle.model.AdministradorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdministradorRepository extends JpaRepository<AdministradorModel, UUID> {
}
