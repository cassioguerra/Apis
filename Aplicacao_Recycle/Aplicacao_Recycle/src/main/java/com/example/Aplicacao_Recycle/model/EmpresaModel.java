package com.example.Aplicacao_Recycle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name =  "TB_EMPRESA")
public class EmpresaModel implements Serializable {
	private  static  final Long serialversionUID = 1L ;

	@Id
	@NotBlank(message = "cnjp da empresa ")
	private  String cnpj;

	@Column ( nullable = false, unique = true , length = 150, name = "EMAIL DA EMPRESA ")
	@NotBlank(message = "email empresa ")
	private  String emial ;

	@Column ( nullable = false , unique = true  ,length =150,name =" Senha da EMPRESA " )
	@NotBlank(message = "senha empresa ")
	private  String senha ;

	@Column ( nullable = false , unique = false , length = 150 , name = "Nome EMPRESA  ")
	@NotBlank(message = "nome empresa ")
	private String nome ;

	@Column (nullable = false, name =  "estado_Empresa")
	@NotBlank(message = " estado da empresa ")
	private String estado;

	@Column (nullable = false, name =  "cidade_EMPRESA")
	@NotBlank(message = " cidade da empresa ")
	private String cidade;

	@Column (nullable = false, name =  "bairro_EMPRESA")
	@NotBlank(message = " bairro da empresa ")
	private String bairro;

	@Column (nullable = false, name =  "rua_EMPRESA")
	@NotBlank(message = "rua da empresa ")
	private String rua;

	@Column (nullable = false, name =  "numero_EMPRESA")
	@NotBlank(message = "numero da empresa ")
	private String numero;

	@Column (nullable = false, name =  "cep_EMPRESA")
	@NotBlank(message = "cep da empresa")
	private String cep;


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
