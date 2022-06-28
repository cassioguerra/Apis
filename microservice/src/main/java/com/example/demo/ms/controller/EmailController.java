package com.example.demo.ms.controller;

import com.example.demo.ms.dtos.EmailDto;
import com.example.demo.ms.model.EmailModel;
import com.example.demo.ms.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {
	@Autowired
	EmailService emailService;

	// primeiro dtos de entrada para fazer a validação tbm opassar o dto para model e tbm enviar o email para o usuario
	//@PostMapping("/sending-email")  para criar um metodo post
// obs @PostMapping("/sending-email" é igual a sendingEmail(@RequestBody @Valid EmailDto emailDto) )
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel); // esse metodo faz a converção de dto para model
		emailService.sendEmail(emailModel); // para salvar em service em sendEmail
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);


	}
}