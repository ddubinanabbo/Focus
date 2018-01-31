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
import com.focus.common.service.CommonService;
import com.focus.member.model.MemberDto;
import com.focus.util.BoardConstance;
import com.focus.util.PageNavigation;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("/list.focus")
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<BoardDto> list = boardService.listArticle(map);
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
		mav.setViewName("/WEB-INF/aboard/aboard_list");
		return mav;
	}
	
	@RequestMapping(value="/write.focus", method=RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String, String> map, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		if(memberDto != null) {
		mav.addObject("querystring", map);
		mav.addObject("name", memberDto.getM_NAME());
		mav.setViewName("/WEB-INF/aboard/write");
		}
		else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/write.focus", method=RequestMethod.POST)
	public ModelAndView write(BoardDto boardDto,
			@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			int seq = commonService.getNextSeq();
			boardDto.setSeq(seq);
			boardDto.setMseq(memberDto.getMSEQ());
			boardDto.setId(memberDto.getM_ID());
			boardDto.setName(memberDto.getM_NAME());
			boardDto.setEmail(memberDto.getM_EMAIL());
			int cnt = boardService.writeArticle(boardDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/aboard/writeOk");
		return mav;
	}
	
	
	@RequestMapping(value="/view.focus", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			BoardDto boardDto = boardService.viewArticle(seq);			
			mav.addObject("querystring", map);
			mav.addObject("article", boardDto);
			mav.setViewName("/WEB-INF/aboard/view");
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
			BoardDto boardDto = boardService.viewArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("article", boardDto);
			mav.setViewName("/WEB-INF/aboard/modify");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	@RequestMapping(value="/modify.focus", method=RequestMethod.POST)
	public ModelAndView modify(BoardDto boardDto, @RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			boardDto.setSeq(seq);
			boardDto.setMseq(memberDto.getMSEQ());
			boardDto.setId(memberDto.getM_ID());
			boardDto.setName(memberDto.getM_NAME());
			boardDto.setEmail(memberDto.getM_EMAIL());
			int cnt = boardService.modifyArticle(boardDto);
			if(cnt == 1) {
				mav.setViewName("/WEB-INF/aboard/writeOk");
				mav.addObject("querystring", map);
				mav.addObject("seq", seq);
			}else {
				mav.setViewName("/WEB-INF/aboard/writeFail");
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
			boardService.deleteArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/aboard/deleteOK");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	

}
