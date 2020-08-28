package com.web.jsp.Member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.Member.exception.MemberException;
import com.web.jsp.Member.model.vo.Member;
import com.web.jsp.Member.model.vo.PopListB;

import static com.web.jsp.common.JDBCTemplate.*;
public class MemberDao {
	
	private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		
		String filePath = MemberDao.class
				.getResource("/config/member-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getUserId());
			pstmt.setString(3, m.getUserPwd());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setDate(6, m.getBirth());
			pstmt.setString(7, m.getGender());
			pstmt.setString(8, m.getAddress());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int idDupCheck(Connection con, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idDupCheck");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public Member selectMember(Connection con, Member m) throws MemberException {
		Member mem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mem = new Member();

				mem.setUserId(m.getUserId());
				mem.setUserPwd(m.getUserPwd());

				mem.setUserName(rset.getString("USERNAME"));
				mem.setEmail(rset.getString("EMAIL"));
				mem.setPhone(rset.getString("PHONE"));
				mem.setBirth(rset.getDate("BIRTH"));
				mem.setGender(rset.getString("GENDER"));
				mem.setAddress(rset.getString("ADDRESS"));
			}
		}catch(Exception e) {
			throw new MemberException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return mem;
	}
	
	
	
	
	public ArrayList<PopListB> selectListB(Connection con, String id) {

		ArrayList<PopListB> pb = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListB");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			pb = new ArrayList<PopListB>();
			
			if(rset != null) {
				System.out.println("굿");
				System.out.println(rset);
			}else {
				System.out.println("zzzzzzzzzzzzzzzzzzzz");
			}
			while(rset.next()) {
				PopListB b = new PopListB();
				b.setPop_no_B(rset.getInt(1));
				b.setUserId(rset.getString(2));
				b.setPop_list_B(rset.getString(3));
				System.out.println(b);
				pb.add(b);
			
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pb;
	}

}





















