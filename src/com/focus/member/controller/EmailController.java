package com.focus.member.controller;


import javax.mail.internet.MimeMessage; 
import org.springframework.mail.javamail.JavaMailSenderImpl; 
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.core.io.FileSystemResource;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


	@Controller
	@RequestMapping("/mail")
	public class EmailController {
		
		@Autowired 
		private JavaMailSender mailSender; 
		
		@RequestMapping(value = "/mailForm")
		  public String mailForm() {
		   
		    return "/mail/mailForm";
		  }  
		
		
		@RequestMapping(value = "/mail.focus") 
		public String sendMail(@RequestParam(value="M_MAIL",required = true) String M_MAIL) throws Exception {
				
			 	String from = "ddubinanabo@gmail.com"; 
			 	String subject	= "회원님에게 드리는 임시 비밀번호 입니다.";
			 	String to = M_MAIL;
			 	String text = "이제는 메일이 갔으면 좋겠다";

			 	 try {
			 	      MimeMessage message = mailSender.createMimeMessage();
			 	      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			 	     
			 	      
			 	     messageHelper.setFrom(from);
			 	     messageHelper.setTo(to);     // 받는사람 이메일
			 	     messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
			 	     messageHelper.setText(text);
			 	
			 	     mailSender.send(message);
			     } catch(Exception e){
			       System.out.println(e);
			     }
			return "redirect:/mail/mailForm";
			
			}

}
