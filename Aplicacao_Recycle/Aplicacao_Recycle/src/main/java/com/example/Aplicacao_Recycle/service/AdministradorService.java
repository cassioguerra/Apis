package com.example.Aplicacao_Recycle.service;

import com.example.Aplicacao_Recycle.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}
}
