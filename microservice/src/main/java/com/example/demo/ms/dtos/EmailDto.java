package com.example.demo.ms.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {


	@NotBlank
	private String propietarioRef ; // referencia do propietario que esta mandando essa mensagem
	@NotBlank
	@Email // PARA VERIFICAR SE O EMAIL É VALIDO
	private String emialFrom; // quem esta mandando esse email
	@NotBlank
	@Email
	private String emialTo; // para quem esse email esta sendo enviado
	@NotBlank
	private String subject; // sujeita , subordinr  o titulo do email
// obs todos que são stringe são limitado em 250 caracteres
	@NotBlank
	private String texte;
}
