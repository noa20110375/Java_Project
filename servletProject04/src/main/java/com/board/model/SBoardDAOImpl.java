package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.util.DBConnection;



public class SBoardDAOImpl implements SBoardDAO{
	private static SBoardDAO instance = new SBoardDAOImpl();
	 public static SBoardDAO getInstnace(){
		 return instance;
	 }
	
	@Override
	//추가
	public void boardInsert(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps =null;
		try {
			con =DBConnection.getConnection();
			String sql =  "insert into simpleboard values(simpleboard_seq.nextval,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);

			ps.setString(1,board.getUserid());
			ps.setString(2,board.getSubject());
			ps.setString(3,board.getEmail());
			ps.setInt(4,board.getReadcount());
			ps.setString(5,board.getContent());
		//	ps.setString(7,board.getRegdate());
			ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
	closeConnection(con, ps, ps, null);
	}
	}
	@Override
	public void boardUpatde(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BoardDTO> boardList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr =  new ArrayList<BoardDTO>();
		
		try {
			con =DBConnection.getConnection();
			String sql = "select * from simpleboard";
			st  = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO addr = new BoardDTO();
				addr.setNum(rs.getInt("num"));
				addr.setSubject(rs.getString("subject"));
				addr.setUserid(rs.getString("userid"));
				
				addr.setRegdate(rs.getString("regdate"));
				addr.setReadcount(rs.getInt("readcount"));
				arr.add(addr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		
		
		return arr;
	}

	@Override
	public ArrayList<BoardDTO> boardList(int startRow, int endRow, String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void BoardDelete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//상세보기
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	
		BoardDTO ad = null;
		try {
			con =DBConnection.getConnection();
			String  sql = "select * from simpleboard where num = " +  num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				
				  ad = new BoardDTO();
				  //sql developer에 들어 있는 컬럼명이 들어감  그러니 일치 해야함.
				  ad.setNum(rs.getInt("num"));
					ad.setSubject(rs.getString("subject"));
					ad.setUserid(rs.getString("userid"));
					ad.setContent(rs.getString("content"));
					ad.setRegdate(rs.getString("regdate"));
					ad.setReadcount(rs.getInt("readcount"));
					
				  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return null;
	}

	@Override
	public void commentList(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commentInsert(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CommentDTO> findAllComment(int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int commetList(int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			
			if (con != null)
				con.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
