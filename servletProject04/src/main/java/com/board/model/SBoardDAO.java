package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
			///�߰�
	
	public void boardInsert(BoardDTO board);
	
	//����
	
	
	public void boardUpatde(BoardDTO board);
	
	//��ü����
	public ArrayList<BoardDTO> boardList();
	public ArrayList<BoardDTO>boardList(int startRow,int endRow, String field, String word);
	
	
	
	
	//����
	public void BoardDelete(int num);
	
	//�Խñ� ��
	public int boardCount(String field,String word);
	
	
	//�󼼺���
	public BoardDTO findByNum(int num);
	
	//�ڸ�Ʈ
	public void commentList(CommentDTO comment);
	//�߰�
	public void commentInsert(CommentDTO comment);
	//��ü����
	public ArrayList<CommentDTO> findAllComment(int bnum);
	//��� ����
	public int commetList(int bnum);
}
