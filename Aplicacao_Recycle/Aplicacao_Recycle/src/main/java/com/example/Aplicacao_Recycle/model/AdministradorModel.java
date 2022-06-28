package com.example.Aplicacao_Recycle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = " TB_ADMINISTRADOR")
public class AdministradorModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id// INDENTIFICADOR PK
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_administrador ;

	@Column( nullable = false , unique = true ,length =  50)
	@NotBlank(message = "email administrador ")
	private String email ;

	@Column( nullable = false , unique = true , length = 150)
	@NotBlank(message ="senha administardor " )
	private  String senha ;

	@OneToMany
	private List<UsuarioModel> usuarioModels; // CONTATO COM O USUARIO

	@OneToMany
	private List<EmpresaModel> empresaModels; //CONTATO COM A EMPRESA

	@OneToMany
	private List<AgendamentoModel>agendamentoModellist; // CONTATO COM O AGENDAMENTO

	public UUID getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(UUID id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<UsuarioModel> getUsuarioModels() {
		return usuarioModels;
	}

	public void setUsuarioModels(List<UsuarioModel> usuarioModels) {
		this.usuarioModels = usuarioModels;
	}

	public List<EmpresaModel> getEmpresaModels() {
		return empresaModels;
	}

	public void setEmpresaModels(List<EmpresaModel> empresaModels) {
		this.empresaModels = empresaModels;
	}

	public List<AgendamentoModel> getAgendamentoModellist() {
		return agendamentoModellist;
	}

	public void setAgendamentoModellist(List<AgendamentoModel> agendamentoModellist) {
		this.agendamentoModellist = agendamentoModellist;
	}
}