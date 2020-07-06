package com.nexgrid.board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.nexgrid.board.dataControl.BoardListControl;
import com.nexgrid.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nexgrid.board.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;


	@RequestMapping(value = "/boarList",method = RequestMethod.GET)
	@ResponseBody
	public BoardListControl<BoardVO> boarSelectList(HttpServletRequest request, HttpServletResponse response, @RequestParam("page")int page){




		List<BoardVO> boarList = null;
		List<BoardVO> boarAllSize = null;
		BoardVO boardVO = new BoardVO();
		List<Integer> boardPageGing = new ArrayList<>();

		BoardListControl boardListControl = new BoardListControl();

		try {

			boarAllSize = boardService.boardSelectSize(); // 게시판 총곗수

			int n = page; // 이동할 페이지
			int endBoard = 10; // 게시판 보여줄 마지막 곗수
			int skipPageStart = (n-1)*endBoard; // 보여줄 게시판 시작점
			int skippageEnd = skipPageStart + endBoard - 1;
			int pageging = (boarAllSize.size()/endBoard)+1; // 최대 게시판 페이징 숫


			System.out.println("========================");
			System.out.println("게시판 페이징 :"+n);
			System.out.println("게시판 시작 번호: "+skipPageStart);
			System.out.println("게시판 마지막 번호: "+skippageEnd);
			System.out.println("게시판 페이징 총곗수: "+pageging);
			System.out.println("게시판 총곗수: "+boarAllSize.size());
			System.out.println("========================");



			boardVO.setSkipPageStart(skipPageStart);
			boardVO.setSkipPageEnd(skippageEnd);

			boardPageGing.add(boarAllSize.size());
			boardPageGing.add(pageging);

			boarList = boardService.boardSelectList(boardVO);

			// board 게시판 전체적 인 자료
			boardListControl.setBoardList(boarList);
			boardListControl.setBoardPageGing(boardPageGing);



		}catch (Exception ex){
			System.out.println("========================");
			System.out.println(ex.getMessage());
			System.out.println("========================");
		}


		return boardListControl;
	}


	@RequestMapping(value = "/boarRegistr.dao",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Integer> boarRegistr(HttpServletResponse request, HttpServletResponse response, @RequestBody BoardVO boardVO)throws Exception{

		int resultcnt = 0;

		try {
			resultcnt = boardService.boardInsert(boardVO);
		}catch (Exception ex){
			System.out.println("========================");
			System.out.println(ex.getMessage());
			System.out.println("========================");
		}

		return new ResponseEntity<Integer>(resultcnt, HttpStatus.OK);
	}


	@RequestMapping(value = "/boardDetail.dao",method = RequestMethod.GET)
	@ResponseBody
	public BoardVO boardDetail(ServletRequest request, ServletResponse response, @RequestParam("Number")int Number){

		BoardVO boarList = new BoardVO();

		try{
			// 게시판 정보 상세보기
			boarList.setRoom_idx(Number);
			boarList = boardService.boardDetail(Number);
			// 조회수
			boardService.boarClickIdx(Number);
		}catch(Exception ex){
			System.out.println("========================");
			System.out.println(ex.getMessage());
			System.out.println("========================");
		}


		return boarList;
	}

	@RequestMapping(value = "/boarUpDate.dao",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> boarUpDate(HttpServletRequest request,HttpServletResponse responseBody,@RequestBody BoardVO boardVO){

		int resultcnt = 0;
		try {
			resultcnt = boardService.boarUpDate(boardVO);
		}catch (Exception ex){
			System.out.println("========================");
			System.out.println(ex.getMessage());
			System.out.println("========================");
		}

		return new ResponseEntity<Integer>(resultcnt,HttpStatus.OK);
	}


	@RequestMapping(value = "/boardDelete.dao",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> boarDelete(HttpServletRequest request,HttpServletResponse responseBody,@RequestBody BoardVO boardVO){

		int resultcnt = 0;

		try{
			resultcnt = boardService.boardDelete(boardVO);
		}catch (Exception ex){
			System.out.println("========================");
			System.out.println(ex.getMessage());
			System.out.println("========================");
		}

		return new ResponseEntity<Integer>(resultcnt,HttpStatus.OK);
	}

}
