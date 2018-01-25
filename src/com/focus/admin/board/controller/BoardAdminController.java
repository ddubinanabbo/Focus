package com.focus.admin.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus.admin.board.model.BoardListDto;
import com.focus.admin.board.service.BoardAdminService;

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

}
