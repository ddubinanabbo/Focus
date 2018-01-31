package com.focus.admin.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus.admin.board.model.BoardListDto;
import com.focus.admin.board.model.HotListDto;
import com.focus.admin.board.model.RecentBookListDto;
import com.focus.admin.board.service.BoardAdminService;
import com.focus.util.StringEncoder;

@Controller
@RequestMapping("/boardadmin")
public class BoardAdminController {
	
	@Autowired
	private BoardAdminService boardAdminService;
	
	@RequestMapping("/sidebar.focus")
	public String sideBar(HttpServletRequest request) {
		System.out.println("sideBar");
		List<BoardListDto> list = boardAdminService.boardMenu();
		ServletContext context = request.getServletContext();
		context.setAttribute("boardmenu", list);
		return "redirect:/main.jsp";
	}
	
	@RequestMapping(value="/hotlist.focus", method=RequestMethod.POST)
	public @ResponseBody String hotlist() {
		
		List<HotListDto> list = boardAdminService.hotlist();
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		
		for(HotListDto hotlistDto : list) {
			JSONObject hlist = new JSONObject();
			hlist.put("bcode", hotlistDto.getBcode());
			hlist.put("seq", hotlistDto.getSeq());
			hlist.put("subject", StringEncoder.urlUtf(hotlistDto.getSubject()).replaceAll("\\+", "%20"));
			hlist.put("logtime", hotlistDto.getLogtime());
			hlist.put("cname", StringEncoder.urlUtf(hotlistDto.getCname()).replaceAll("\\%2B", "+"));
			hlist.put("btype_name", StringEncoder.urlUtf(hotlistDto.getBtype_name()).replaceAll("\\+", "%20"));
			jarray.add(hlist);
		}
		json.put("hlist", jarray);
		return json.toJSONString();
	}
	@RequestMapping(value="/rblist.focus", method=RequestMethod.POST)
	public @ResponseBody String rblist() {
		
		System.out.println("rblist controller");
		List<RecentBookListDto> list = boardAdminService.rblist();
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		
		for(RecentBookListDto rblistDto : list) {
			JSONObject rblist = new JSONObject();
			rblist.put("bcode", rblistDto.getBcode());
			rblist.put("seq", rblistDto.getSeq());
			System.out.println(rblistDto.getSAVEFOLDER() + rblistDto.getSAVE_PICTURE());
			rblist.put("savefolder",rblistDto.getSAVEFOLDER());
			rblist.put("save_picture", rblistDto.getSAVE_PICTURE());
			rblist.put("subject", StringEncoder.urlUtf(rblistDto.getSubject()).replaceAll("\\+", "%20"));
			rblist.put("content", StringEncoder.urlUtf(rblistDto.getContent()).replaceAll("\\+", "%20"));
			rblist.put("cname", StringEncoder.urlUtf(rblistDto.getCname()).replaceAll("\\%2B", "+"));
			jarray.add(rblist);
		}
		json.put("rblist", jarray);
		return json.toJSONString();
	}


}
