package com.mail.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mail.api.service.EmailSenderService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SendingMailApplication {
	
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SendingMailApplication.class, args);
	}

	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException
	{
		senderService.sendEmail("Praveensonu1999@gmail.com","This is email body",
				"Hi Praveen How Are You");
	}
}
