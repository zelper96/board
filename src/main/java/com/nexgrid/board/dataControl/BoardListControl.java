package com.nexgrid.board.dataControl;


import java.util.List;

public class BoardListControl<T> {

    // board 리스트
    private List<T> boardList;
    // board 페이징 위한 데이터
    private List<T> boardPageGing;

    public List<T> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<T> boardList) {
        this.boardList = boardList;
    }

    public List<T> getBoardPageGing() {
        return boardPageGing;
    }

    public void setBoardPageGing(List<T> boardPageGing) {
        this.boardPageGing = boardPageGing;
    }
}
