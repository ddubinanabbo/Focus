package com.focus.member.controller;



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
		private JavaMailSenderImpl mailSender; 
		private String from = "ddubinanabo@gmail.com"; 
		private String subject	= "회원님에게 드리는 임시 비밀번호 입니다.";
		
		@RequestMapping(value = "/mail.focus") 
		public String sendMail(@RequestParam(value="M_MAIL",required = true) String M_MAIL) throws Exception {
			
				SimpleMailMessage message = new SimpleMailMessage();
				mailSender = new JavaMailSenderImpl();
				message.setTo(M_MAIL); 
				message.setText("메일이 잘 갔으려나"); 
				message.setFrom(from); 
				message.setSubject(subject);// 메일제목은 생략이 가능하다 
				System.out.println("<<<<<<" + message.getText());
				System.out.println("<<<<<<" + message.getFrom());
				System.out.println("<<<<<<" + message.getSubject());
				System.out.println("<<<<<<" + message.getTo());
				System.out.println("<<<<<<");
				System.out.println(M_MAIL);
				System.out.println(mailSender);
				mailSender.send(message); 
				
			return "redirect:/login.jsp";
			
			}

}
