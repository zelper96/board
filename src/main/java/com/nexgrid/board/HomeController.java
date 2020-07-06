package com.nexgrid.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nexgrid.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	BoardService testService;
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardList() {
		return "boardList";
	}

	@RequestMapping(value = "/boardRegistr", method = RequestMethod.GET)
	public String boardRegist(HttpServletRequest request, HttpServletResponse response) {
		return "boardRegistr";
	}
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(HttpServletRequest request, HttpServletResponse response, Model model){

		String Number = request.getParameter("Number");
		model.addAttribute("Number",Number);

		return  "boardDetail";
	}


	@RequestMapping(value = "/boardUpdate", method = RequestMethod.GET)
	public String bodyUpdate(HttpServletRequest request, HttpServletResponse response, Model model){

		String room_idx = request.getParameter("Number");
		model.addAttribute("Number",room_idx);

		return  "boardUpdate";
	}

	
	
}
