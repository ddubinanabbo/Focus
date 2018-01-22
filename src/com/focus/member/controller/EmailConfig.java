package com.focus.member.controller;

	import org.springframework.context.annotation.Bean; 
	import org.springframework.context.annotation.Configuration; 
	import org.springframework.mail.javamail.JavaMailSender; 
	import org.springframework.mail.javamail.JavaMailSenderImpl; 
	
	@Configuration 
	public class EmailConfig { 
		
		@Bean 
		public static JavaMailSender mailSender(){ 
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); 
			mailSender.setHost("smtp.gmail.com"); 
			mailSender.setUsername("ddubinanabo@gamil.com"); 
			mailSender.setPassword("wjdtmdgh1!");
			
			return mailSender; 
		} 
	}

