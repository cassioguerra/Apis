package com.example.demo.ms.service;

import com.example.demo.ms.enus.StatusEmail;
import com.example.demo.ms.model.EmailModel;
import com.example.demo.ms.repositoes.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

	@Autowired
	EmailRepository emailRepository ;  // para chama o email repository
	@Autowired
	private JavaMailSender emailSender;
	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		try{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmialFrom());
			message.setTo(emailModel.getEmialTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getTexte());
			emailSender.send(message);

			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e){
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return emailRepository.save(emailModel);
		}
	}

	public Page<EmailModel> findAll(Pageable pageable) {
		return  emailRepository.findAll(pageable);
	}

	}

