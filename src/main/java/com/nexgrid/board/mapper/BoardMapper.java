package com.nexgrid.board.mapper;

import java.util.List;


import com.nexgrid.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	// 게시판 페이징 처리
	public List<BoardVO> boardSelectList(BoardVO boardVO)throws Exception;
	// 게시판 총 계수
	public List<BoardVO> boardSelectSize()throws Exception;
	// 게시판 작성
	public int boardInsert(BoardVO boardVO)throws Exception;
	// 게시판 수정
	public int boarUpDate(BoardVO boardVO) throws Exception;
	// 게시판 조회수
	public int boarClickIdx(int number) throws Exception;
	// 게시판 삭제
	public int boardDelete(BoardVO boardVO) throws Exception;
	// 상세보기
	public BoardVO boardDetail (int number)throws Exception;
}



