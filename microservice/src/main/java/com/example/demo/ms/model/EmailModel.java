package com.example.demo.ms.model;

import com.example.demo.ms.enus.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data // PARA NÃO CRIAR O GET E SET E CONSTRUTORES
@Entity
@Table(name = " TB_EMAIL")
public class EmailModel implements Serializable {

	private  static  final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO) // geração automatica
	private UUID emialId; // o id do amil
	private String propietarioRef ; // referencia do propietario que esta mandando essa mensagem
	private String emialFrom; // quem esta mandando esse email
	private String emialTo; // para quem esse email esta sendo enviado
	private String subject; // sujeita , subordinr  o titulo do email
// obs todos que são stringe são limitado em 250 caracteres

	@Column(columnDefinition = "TEXT") // corpo do emial ; columnDefinition = "TEXT" para inseri mas caracter se for preciso
	private String texte;
	private LocalDateTime sendDateEmail; // data que o email foi enviado
	private StatusEmail statusEmail;



	public String getPropietarioRef() {
		return propietarioRef;
	}

	public void setPropietarioRef(String propietarioRef) {
		this.propietarioRef = propietarioRef;
	}

	public String getEmialFrom() {
		return emialFrom;
	}

	public void setEmialFrom(String emialFrom) {
		this.emialFrom = emialFrom;
	}

	public String getEmialTo() {
		return emialTo;
	}

	public void setEmialTo(String emialTo) {
		this.emialTo = emialTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}
}
