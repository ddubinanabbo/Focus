package com.focus.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.focus.member.model.MemberDto;
import com.focus.member.model.ProfileDto;
import com.foucs.member.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService memberService;

	private String upFolder;

	public MemberController() {
		this.upFolder = "D:\\Java\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\focusGit\\profile";
	}

	@RequestMapping("/idcheck.focus")
	public @ResponseBody String idCheck(@RequestParam("sid") String sid) {
		System.out.println(memberService);
		int cnt = memberService.idcheck(sid);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		json.put("sid", sid);
		return json.toJSONString();
	}

	@RequestMapping(value = "/join.focus", method = RequestMethod.POST)
	public ModelAndView join(MemberDto memberDto) {
		ModelAndView mav = new ModelAndView();
		int cnt = memberService.registerMember(memberDto);
		String viewName = "/main";
		if (cnt != 0) {
			mav.addObject("registerInfo", memberDto);
			viewName = "/login";
		}
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/login.focus", method = RequestMethod.POST)
	public String login(@RequestParam(value = "M_ID", required = true) String M_ID,
			@RequestParam(value = "M_PASS", required = true) String M_PASS, HttpSession session,
			HttpServletRequest request) {
		String url = request.getHeader("referer");
		MemberDto memberDto = memberService.login(M_ID, M_PASS);
		ProfileDto profileDto = memberService.viewProfile(memberDto.getMSEQ());
		session.setAttribute("userInfo", memberDto);
		session.setAttribute("profileInfo", profileDto);
		if (url.contains("login.jsp"))
			url = "/main.jsp";
		return "redirect:" + url;

	}

	@RequestMapping(value = "/logout.focus", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/join.focus", method = RequestMethod.GET)
	public String join() {
		return "redirect:/join.jsp";
	}

	@RequestMapping(value = "/login.focus", method = RequestMethod.GET)
	public String login() {
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/upprofile.focus", method = RequestMethod.POST)
	public String upprofile(ProfileDto profileDto, HttpSession session)
			throws IllegalStateException, IOException {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path = "";
		if (memberDto != null) {
			profileDto.setMSEQ(memberDto.getMSEQ());
			DateFormat df = new SimpleDateFormat("yyMMdd");
			String saveFolder = df.format(new Date());
			String uploadPath = upFolder + File.separator + saveFolder;
			File folder = new File(uploadPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			profileDto.setSAVEFOLDER(saveFolder);
			MultipartFile multipartFile = profileDto.getUpfile();

			if (!multipartFile.isEmpty()) {
				String ofile = multipartFile.getOriginalFilename();
				profileDto.setORIGIN_PHOTO(ofile);
				String savePicture = UUID.randomUUID().toString() + ofile.substring(ofile.lastIndexOf("."));
				profileDto.setSAVE_PHOTO(savePicture);
				multipartFile.transferTo(new File(uploadPath, savePicture));
				int cnt = memberService.uploadProfile(profileDto);
				if (cnt != 0) {
					profileDto = memberService.viewProfile(memberDto.getMSEQ());
					session.setAttribute("profileInfo", profileDto);
					path = "redirect:/profile.jsp";
				}
			}
		}
		return path;
	}

}
