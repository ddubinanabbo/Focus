package com.focus.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.focus.board.model.AlbumDto;
import com.focus.board.model.BbsDto;
import com.focus.board.model.ReboardDto;
import com.focus.board.service.BbsService;
import com.focus.common.service.CommonService;
import com.focus.member.model.MemberDto;
import com.focus.util.BoardConstance;
import com.focus.util.PageNavigation;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	@Autowired
	BbsService bbsService;
		
	@Autowired
	CommonService commonService;
	
	private String upFolder;

	public BbsController() {
//		this.upFolder = "D:\\Java\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\focusGit\\upload";
		this.upFolder = "C:\\javadata\\workspace\\framework\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\focus\\upload";
	}
	
	@RequestMapping("/list.focus")
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<BbsDto> list = bbsService.listArticle(map);
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
		mav.setViewName("/WEB-INF/bbs/bbs_list");
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
		mav.setViewName("/WEB-INF/bbs/write");
		}
		else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	@RequestMapping(value="/write.focus", method=RequestMethod.POST)
	public ModelAndView write(BbsDto bbsDto, 
			@RequestParam Map<String, String> map,
			HttpSession session) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			bbsDto.setSeq(seq);
			bbsDto.setMseq(memberDto.getMSEQ());
			bbsDto.setId(memberDto.getM_ID());
			bbsDto.setName(memberDto.getM_NAME());
			bbsDto.setEmail(memberDto.getM_EMAIL());
			
			DateFormat df = new SimpleDateFormat("yyMMdd");
			String saveFolder = "file" + df.format(new Date());//20180103
			String uploadPath = upFolder + File.separator + saveFolder;
			File folder = new File(uploadPath);
			if(!folder.exists())
				folder.mkdirs();
			bbsDto.setSAVEFOLDER(saveFolder);
			
			List<MultipartFile> list = bbsDto.getUpfile();
			for (MultipartFile multipartFile : list) {
				if(!multipartFile.isEmpty()) {
					String ofile = multipartFile.getOriginalFilename();
					int size = (int) multipartFile.getSize();
					bbsDto.setFILESIZE(size);
					bbsDto.setORIGIN_FILE(ofile);
					String saveFile = UUID.randomUUID().toString() + ofile.substring(ofile.lastIndexOf("."));//12312312.jpg
					bbsDto.setSAVE_FILE(saveFile);
					multipartFile.transferTo(new File(uploadPath, saveFile));
				}
			}			
			
			int cnt = bbsService.writeArticle(bbsDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/bbs/writeOk");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	@RequestMapping(value="/view.focus", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam Map<String, String> map,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			BbsDto bbsDto = bbsService.viewArticle(seq);			
			mav.addObject("querystring", map);
			mav.addObject("article", bbsDto);
			mav.setViewName("/WEB-INF/bbs/view");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	 @RequestMapping("/download.focus")
	    public ModelAndView download(@RequestParam("path")String path, @RequestParam("fileName")String fileName){
	        ModelAndView mav = new ModelAndView("downLoad");
		 	String fullPath = upFolder + "\\" + path + "\\" + fileName;
	        File file = new File(fullPath);
	        mav.addObject("downloadFile", file);
	        return mav;
	    }
	 
	 @RequestMapping(value="/modify.focus", method=RequestMethod.GET)
		public ModelAndView modify(@RequestParam Map<String, String> map,
				HttpSession session) {
			ModelAndView mav = new ModelAndView();
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			if(memberDto != null) {
				int seq = Integer.parseInt(map.get("seq"));
				BbsDto bbsDto = bbsService.viewArticle(seq);
				mav.addObject("querystring", map);
				mav.addObject("article", bbsDto);
				mav.setViewName("/WEB-INF/bbs/modify");
			} else {
				mav.setViewName("/login");
			}
			return mav;
		}

		@RequestMapping(value="/modify.focus", method=RequestMethod.POST)
		public ModelAndView modify(BbsDto bbsDto, 
				@RequestParam Map<String, String> map,
				HttpSession session) throws IllegalStateException, IOException {
			ModelAndView mav = new ModelAndView();
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			if(memberDto != null) {
				System.out.println("seq : " + map.get("seq"));
				int seq = Integer.parseInt(map.get("seq"));
				bbsDto.setSeq(seq);
				bbsDto.setMseq(memberDto.getMSEQ());
				bbsDto.setId(memberDto.getM_ID());
				bbsDto.setName(memberDto.getM_NAME());
				bbsDto.setEmail(memberDto.getM_EMAIL());
				
				DateFormat df = new SimpleDateFormat("yyMMdd");
				String saveFolder = "file" + df.format(new Date());//20180103
				String uploadPath = upFolder + File.separator + saveFolder;
				File folder = new File(uploadPath);
				if(!folder.exists())
					folder.mkdirs();
				bbsDto.setSAVEFOLDER(saveFolder);
				
				List<MultipartFile> list = bbsDto.getUpfile();
				for (MultipartFile multipartFile : list) {
					if(!multipartFile.isEmpty()) {
						String ofile = multipartFile.getOriginalFilename();
						int size = (int) multipartFile.getSize();
						bbsDto.setFILESIZE(size);
						bbsDto.setORIGIN_FILE(ofile);
						String saveFile = UUID.randomUUID().toString() + ofile.substring(ofile.lastIndexOf("."));//12312312.jpg
						bbsDto.setSAVE_FILE(saveFile);
						multipartFile.transferTo(new File(uploadPath, saveFile));
					}
				}							
				int cnt = bbsService.modifyArticle(bbsDto);
				mav.addObject("querystring", map);
				mav.addObject("seq", seq);
				mav.setViewName("/WEB-INF/bbs/writeOk");
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
				bbsService.deleteArticle(seq);
				mav.addObject("querystring", map);
				mav.addObject("seq", seq);
				mav.setViewName("/WEB-INF/bbs/deleteOK");
			} else {
				mav.setViewName("/login");
			}
			return mav;
		}

}
