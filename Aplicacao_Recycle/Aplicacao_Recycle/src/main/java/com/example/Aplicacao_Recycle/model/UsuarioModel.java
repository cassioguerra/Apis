package com.example.Aplicacao_Recycle.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel  implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@NotBlank( message =  " cpf do usuario ")
	private String cpf;

	@Column(nullable = false, length = 150, name = "Nome usuario ")
	@NotBlank( message =  " campo do nome do usuario ")
	//NULLABLE PARA INFOR,A QUE NÃO PODE SER NULO ; length PARA DIZER QUAL NUIMERO DE CARACTER ; UNIQUE É UNICO
	private String nome;

	@Column(nullable = false, unique = true, length = 150, name = "Email usuario  ") // email
	@NotBlank( message =  " campo do email do usuario ")
	private String email;

	@Column(nullable = false, unique = true, length = 15, name = "Contato usuario ") // telefone
	@NotBlank(message = " campodo telefone do usuario ")
	private int telefone;

	@Column(nullable = false, unique = true, length = 150, name = "Senha  usuario ") // senha
	@NotBlank(message =  "senha do usuario " )
	private String senha;

	@Column(nullable = false, length = 100, name = "Resposta  usuario ") // resposta
	@NotBlank(message = "Resposta do usuario")
	private String resposta;

	@Column(nullable = false)  // data de nascimento
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	@Column(nullable = false)
	private LocalDateTime registrationDate;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
}