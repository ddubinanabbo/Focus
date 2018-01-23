package com.focus.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.focus.member.model.MemberDto;
import com.foucs.member.service.MailService;
import com.foucs.member.service.MemberService;

@Controller
@RequestMapping("/mail")
public class EmailController {

	private MemberService memberService;
	private MailService mailService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	@RequestMapping(value = "/mail.focus", method = RequestMethod.POST)
	public void sendMailPassword(HttpSession session, @RequestParam String M_ID, @RequestParam String M_EMAIL,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberDto memberDto = memberService.findAccount(M_ID, M_EMAIL);
		if (memberDto != null) {
			if (!memberDto.getM_ID().equals(M_ID)) {
				out.println("<script>alert('입력하신 이메일의 회원정보와 가입된 아이디가 일치하지 않습니다.'); history.go(-1);</script>");
				out.flush();
			}
			int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
			String M_PASS = String.valueOf(ran);
			memberService.updatepwd(M_ID, M_PASS);
			String subject = "임시 비밀번호 발급 안내 입니다.";
			StringBuilder sb = new StringBuilder();
			sb.append("귀하의 임시 비밀번호는 " + M_PASS + " 입니다.");
			mailService.send(subject, sb.toString(), "ddubinanabo@gmail.com", M_EMAIL, null);
			out.println("<script>alert('귀하의 이메일 주소로 새로운 임시 비밀번호를 발송 하였습니다.'); history.go(-1);</script>");
			out.flush();
		} else {
			out.println("<script>alert('귀하의 이메일로 가입된 아이디가 존재하지 않습니다.'); history.go(-1);</script>");
			out.flush();
		}
	}

}

// @Autowired
// private JavaMailSender mailSender;
//
// @RequestMapping(value = "/mailForm")
// public String mailForm() {
//
// return "/mail/mailForm";
// }
//
//
// @RequestMapping(value = "/mail.focus")
// public String sendMail(@RequestParam(value="M_MAIL",required = true) String
// M_MAIL) throws Exception {
//
// String from = "ddubinanabo@gmail.com";
// String subject = "회원님에게 드리는 임시 비밀번호 입니다.";
// String to = M_MAIL;
// String text = "이제는 메일이 갔으면 좋겠다";
//
// try {
// MimeMessage message = mailSender.createMimeMessage();
// MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,
// "UTF-8");
//
//
// messageHelper.setFrom(from);
// messageHelper.setTo(to); // 받는사람 이메일
// messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
// messageHelper.setText(text);
//
// mailSender.send(message);
// } catch(Exception e){
// System.out.println(e);
// }
// return "redirect:/mail/mailForm";
//
// }

// }
