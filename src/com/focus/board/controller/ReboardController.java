package com.focus.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.focus.board.model.BoardDto;
import com.focus.board.model.ReboardDto;
import com.focus.board.service.BoardService;
import com.focus.board.service.ReboardService;
import com.focus.common.service.CommonService;
import com.focus.util.BoardConstance;
import com.focus.util.PageNavigation;
import com.focus.member.model.MemberDto;

@Controller
@RequestMapping("/reboard")
public class ReboardController {
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	ReboardService reboardService;
	
	@RequestMapping("/list.focus")
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<ReboardDto> list = reboardService.listArticle(map);
		map.put("listsize", BoardConstance.BOARD_LIST_SIZE + "");
		PageNavigation navigation = commonService.makePageNavigation(map);
		navigation.setRoot(request.getContextPath());
		navigation.setBcode(Integer.parseInt(map.get("bcode")));
		navigation.setKey(map.get("key"));
		navigation.setWord(map.get("word"));
		navigation.setNavigator();
		mav.addObject("articlelist", list);
		mav.addObject("navigator", navigation);
		mav.addObject("querystring", map);
		mav.setViewName("/WEB-INF/kboard/kboard_list");
		return mav;
	}
	
	@RequestMapping(value="/write.focus", method=RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String, String> map, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		if(memberDto != null) {
		int seq = commonService.getNextSeq();
		mav.addObject("querystring", map);
		mav.addObject("seq", seq);
		mav.addObject("name", memberDto.getM_NAME());
		mav.setViewName("/WEB-INF/kboard/write");
		}
		else {
			mav.setViewName("/login");
		}
		return mav;
	}
	

	@RequestMapping(value="/write.focus", method=RequestMethod.POST)
	public ModelAndView write(ReboardDto reboardDto, 
			@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			int seq = commonService.getNextSeq();
			reboardDto.setSeq(seq);
			reboardDto.setMseq(memberDto.getMSEQ());
			reboardDto.setId(memberDto.getM_ID());
			reboardDto.setName(memberDto.getM_NAME());
			reboardDto.setEmail(memberDto.getM_EMAIL());
			reboardDto.setRef(seq);
			int cnt = reboardService.writeArticle(reboardDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/kboard/writeOk");
		return mav;
	}
	
	@RequestMapping(value="/view.focus", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			ReboardDto reboardDto = reboardService.viewArticle(seq);			
			mav.addObject("querystring", map);
			mav.addObject("article", reboardDto);
			mav.setViewName("/WEB-INF/kboard/view");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	@RequestMapping(value="/comment.focus", method=RequestMethod.GET)
	public ModelAndView comment(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			ReboardDto reboardDto = reboardService.viewArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("article", reboardDto);
			mav.setViewName("/WEB-INF/kboard/comment");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}

	@RequestMapping(value="/comment.focus", method=RequestMethod.POST)
	public ModelAndView comment(ReboardDto reboardDto, @RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			System.out.println("SEQ : " + seq);
			reboardDto.setSeq(seq);
			reboardDto.setMseq(memberDto.getMSEQ());
			reboardDto.setId(memberDto.getM_ID());
			reboardDto.setName(memberDto.getM_NAME());
			reboardDto.setEmail(memberDto.getM_EMAIL());
			int cnt = reboardService.commentArticle(reboardDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/kboard/writeOk");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	@RequestMapping(value="/modify.focus", method=RequestMethod.GET)
	public ModelAndView modify(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			ReboardDto reboardDto = reboardService.viewArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("article", reboardDto);
			mav.setViewName("/WEB-INF/kboard/modify");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	@RequestMapping(value="/modify.focus", method=RequestMethod.POST)
	public ModelAndView modify(ReboardDto reboardDto, @RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			reboardDto.setSeq(seq);
			reboardDto.setMseq(memberDto.getMSEQ());
			reboardDto.setId(memberDto.getM_ID());
			reboardDto.setName(memberDto.getM_NAME());
			reboardDto.setEmail(memberDto.getM_EMAIL());
			int cnt = reboardService.modifyArticle(reboardDto);
			if(cnt == 1) {
				mav.setViewName("/WEB-INF/kboard/writeOk");
				mav.addObject("querystring", map);
				mav.addObject("seq", seq);
			}else {
				mav.setViewName("/WEB-INF/kboard/writeFail");
				mav.addObject("querystring", map);
				mav.addObject("seq", seq);
			}
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete.focus", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			reboardService.deleteArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/kboard/deleteOK");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
}
