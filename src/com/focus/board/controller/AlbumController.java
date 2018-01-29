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
import com.focus.board.model.ReboardDto;
import com.focus.board.service.AlbumService;
import com.focus.common.service.CommonService;
import com.focus.util.BoardConstance;
import com.focus.util.PageNavigation;
import com.focus.member.model.MemberDto;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	CommonService commonService;
	
	private String upFolder;

	public AlbumController() {
//		this.upFolder = "D:\\Java\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\focusGit\\upload";
		this.upFolder = "C:\\javadata\\workspace\\framework\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\focus\\upload";
	}
	
	@RequestMapping("/list.focus")
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<AlbumDto> list = albumService.listArticle(map);
		map.put("listsize", BoardConstance.ALBUM_LIST_SIZE + "");
		PageNavigation navigation = commonService.makePageNavigation(map);
		navigation.setRoot(request.getContextPath());
		navigation.setBcode(Integer.parseInt(map.get("bcode")));
		navigation.setKey(map.get("key"));
		navigation.setWord(map.get("word"));
		navigation.setNavigator();
		mav.addObject("articlelist", list);
		mav.addObject("navigator", navigation);
		mav.addObject("querystring", map);
		mav.setViewName("/WEB-INF/bboard/bboard_list");
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
			mav.setViewName("/WEB-INF/bboard/write");
			}
			else {
				mav.setViewName("/login");
			}
			return mav;
	}
	
	@RequestMapping(value="/write.focus", method=RequestMethod.POST)
	public ModelAndView write(AlbumDto albumDto, 
			@RequestParam Map<String, String> map,
			HttpSession session) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			albumDto.setSeq(seq);
			albumDto.setMseq(memberDto.getMSEQ());
			albumDto.setId(memberDto.getM_ID());
			albumDto.setName(memberDto.getM_NAME());
			albumDto.setEmail(memberDto.getM_EMAIL());
			
			DateFormat df = new SimpleDateFormat("yyMMdd");
			String saveFolder = df.format(new Date());//20180103
			String uploadPath = upFolder + File.separator + saveFolder;
			File folder = new File(uploadPath);
			if(!folder.exists())
				folder.mkdirs();
			albumDto.setSAVEFOLDER(saveFolder);
			
			List<MultipartFile> list = albumDto.getUpfile();
			for (MultipartFile multipartFile : list) {
				if(!multipartFile.isEmpty()) {
					String ofile = multipartFile.getOriginalFilename();
					albumDto.setORIGIN_PICTURE(ofile);
					String savePicture = UUID.randomUUID().toString() + ofile.substring(ofile.lastIndexOf("."));//12312312.jpg
					albumDto.setSAVE_PICTURE(savePicture);
					multipartFile.transferTo(new File(uploadPath, savePicture));
				}
			}			
			
			int cnt = albumService.writeArticle(albumDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/bboard/writeOk");
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
			AlbumDto albumDto = albumService.viewArticle(seq);			
			mav.addObject("querystring", map);
			mav.addObject("article", albumDto);
			mav.setViewName("/WEB-INF/bboard/view");
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
			albumService.deleteArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/bboard/deleteOK");
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
}
