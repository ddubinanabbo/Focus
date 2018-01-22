package com.focus.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.focus.member.model.MemberDto;
import com.foucs.member.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/idcheck.focus")
	public @ResponseBody String idCheck(@RequestParam("sid") String sid){
		int cnt = memberService.idcheck(sid);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		json.put("sid", sid);
		return json.toJSONString();	
	}
	
	@RequestMapping(value="/join.focus",method=RequestMethod.POST)
	public ModelAndView join(MemberDto memberDto){
		ModelAndView mav = new ModelAndView();
		int cnt = memberService.registerMember(memberDto);
		String viewName = "/main";
		if(cnt != 0){
			mav.addObject("registerInfo",memberDto);
			viewName = "/login";
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/login.focus",method=RequestMethod.POST)
	public String login(@RequestParam(value="M_ID",required = true) String M_ID,
						@RequestParam(value="M_PASS",required = true) String M_PASS, HttpSession session, HttpServletRequest request){
		String url = request.getHeader("referer");
		MemberDto memberDto = memberService.login(M_ID, M_PASS);
		System.out.println(">>>"+ memberDto.getM_ID());
		System.out.println(">>>>>>" + memberDto.getM_NAME());
		session.setAttribute("userInfo", memberDto);
		if(url.contains("login.jsp"))
			url = "/main";
		return url;
		
	}
	
	@RequestMapping(value="/logout.focus",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("userInfo");
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value="/join.focus",method=RequestMethod.GET)
	public String join(){
		return "redirect:/join.jsp";
	}
	
	@RequestMapping(value="/login.focus",method=RequestMethod.GET)
	public String login(){
		return "redirect:/login.jsp";
	}
	
	
}
