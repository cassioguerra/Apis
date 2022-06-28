package com.example.Aplicacao_Recycle.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class AgendamentoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id// INDENTIFICADOR PK
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_agendamento;

	@ManyToOne
	private UsuarioModel usuarioModel;
	@ManyToOne
	private  EmpresaModel empresaModel;


	@Column(nullable = false, name = "nome do usuario ")
	private String nome;

	@Column (nullable = false, name = "cpf do usuario ")
	private String cpf;
@Column
	@DateTimeFormat(pattern = "HH:mm:ss")
	private String horaDoAgendamento;
@Column
	@DateTimeFormat (pattern = "DD:mm:aaaa")
	private LocalDate diaDoAgendamento;

@Column( nullable = false , name = "frequencia de coletas ")
private String 	frequencia ;

@Column (nullable = false, name =  "estado_Usuario ")
	private String estado;

	@Column (nullable = false, name =  "cidade_Usuario ")
	private String cidade;

	@Column (nullable = false, name =  "bairro_Usuario ")
	private String bairro;

	@Column (nullable = false, name =  "rua_Usuario ")
	private String rua;

	@Column (nullable = false, name =  "numero_Usuario ")
	private String numero;

	@Column (nullable = false, name =  "cep_Usuario ")
	private String cep;

	public UUID getId_agendamento() {
		return id_agendamento;
	}

	public void setId_agendamento(UUID id_agendamento) {
		this.id_agendamento = id_agendamento;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHoraDoAgendamento() {
		return horaDoAgendamento;
	}

	public void setHoraDoAgendamento(String horaDoAgendamento) {
		this.horaDoAgendamento = horaDoAgendamento;
	}

	public LocalDate getDiaDoAgendamento() {
		return diaDoAgendamento;
	}

	public void setDiaDoAgendamento(LocalDate diaDoAgendamento) {
		this.diaDoAgendamento = diaDoAgendamento;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}