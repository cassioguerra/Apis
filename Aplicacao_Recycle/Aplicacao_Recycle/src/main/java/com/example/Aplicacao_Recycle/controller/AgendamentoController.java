package com.example.Aplicacao_Recycle.controller;

import com.example.Aplicacao_Recycle.service.AgendamentoService;
import com.example.Aplicacao_Recycle.service.EmpresaService;
import com.example.Aplicacao_Recycle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AgendamentoController {
	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private UsuarioService usuarioService;


	}

