package com.example.Aplicacao_Recycle.service;

import com.example.Aplicacao_Recycle.model.AgendamentoModel;
import com.example.Aplicacao_Recycle.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}

	/*@Transactional
	public AgendamentoModel salvarAgendamento(AgendamentoModel agendamentoModel) {
		agendamentoRepository.save(agendamentoModel);
	return salvarAgendamento (agendamentoModel.getId_agendamento());
	}*/



}
