package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
			///추가
	
	public void boardInsert(BoardDTO board);
	
	//수정
	
	
	public void boardUpatde(BoardDTO board);
	
	//전체보기
	public ArrayList<BoardDTO> boardList();
	public ArrayList<BoardDTO>boardList(int startRow,int endRow, String field, String word);
	
	
	
	
	//삭제
	public void BoardDelete(int num);
	
	//게시글 수
	public int boardCount(String field,String word);
	
	
	//상세보기
	public BoardDTO findByNum(int num);
	
	//코멘트
	public void commentList(CommentDTO comment);
	//추가
	public void commentInsert(CommentDTO comment);
	//전체보기
	public ArrayList<CommentDTO> findAllComment(int bnum);
	//댓글 개수
	public int commetList(int bnum);
}
