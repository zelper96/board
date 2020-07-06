package com.nexgrid.board.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexgrid.board.mapper.BoardMapper;
import com.nexgrid.board.vo.BoardVO;

@Service
public class BoardService implements BoardMapper {

    @Autowired
    public BoardMapper boardMapper;


    @Override
    public List<BoardVO> boardSelectList(BoardVO boardVO) throws Exception {
        return boardMapper.boardSelectList(boardVO);
    }

    @Override
    public List<BoardVO> boardSelectSize() throws Exception {
        return boardMapper.boardSelectSize();
    }

    @Override
    public int boardInsert(BoardVO boardVO) throws Exception {
        return boardMapper.boardInsert(boardVO);
    }

    @Override
    public int boarUpDate(BoardVO boardVO) throws Exception {
        return boardMapper.boarUpDate(boardVO);
    }

    @Override
    public int boarClickIdx(int Number) throws Exception {
        return boardMapper.boarClickIdx(Number);
    }

    @Override
    public int boardDelete(BoardVO boardVO) throws Exception {
        return boardMapper.boardDelete(boardVO);
    }

    @Override
    public BoardVO boardDetail(int number) throws Exception {
        return boardMapper.boardDetail(number);
    }

}
