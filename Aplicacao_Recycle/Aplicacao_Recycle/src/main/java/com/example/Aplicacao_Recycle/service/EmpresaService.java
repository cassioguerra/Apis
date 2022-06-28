package com.example.Aplicacao_Recycle.service;

import com.example.Aplicacao_Recycle.model.EmpresaModel;
import com.example.Aplicacao_Recycle.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}


}
