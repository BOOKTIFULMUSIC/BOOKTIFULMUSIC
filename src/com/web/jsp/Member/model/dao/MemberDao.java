package com.web.jsp.Member.model.dao;

import static com.web.jsp.common.JDBCTemplate.close;

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
import com.web.jsp.Member.model.vo.PopListM;
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
			
			
			while(rset.next()) {
				PopListB b = new PopListB();
				b.setPop_no_B(rset.getInt(1));
				b.setUserId(rset.getString(2));
				b.setPop_list_B(rset.getString(3));
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


	public ArrayList<PopListM> selectListM(Connection con, String id) {

		ArrayList<PopListM> pm = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListM");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			pm = new ArrayList<PopListM>();
			
			
			while(rset.next()) {
				PopListM m = new PopListM();
				m.setPop_no_M(rset.getInt(1));
				m.setUserId(rset.getString(2));
				m.setPop_list_M(rset.getString(3));
				pm.add(m);
			
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pm;
	}


	public int insertBgenre(Connection con, String id, String[] bgen) {

		int result = 0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = prop.getProperty("insertBgenre");
		String sql2 = prop.getProperty("insertBgenre2");
		String bgenre=null;
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			for(int i=0; i<bgen.length; i++) {
				bgenre = bgen[i];
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, bgenre);
				result = pstmt2.executeUpdate();
			}
			System.out.println("bdao");


		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
		}
		
		
		return result;
	}


	public int insertMgenre(Connection con, String id, String[] mgen) {

		int result = 0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = prop.getProperty("insertMgenre");
		String sql2 = prop.getProperty("insertMgenre2");
		String Mgenre=null;
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			for(int i=0; i<mgen.length-1; i++) {
				Mgenre = mgen[i];
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, Mgenre);
				result = pstmt2.executeUpdate();
			}
			System.out.println("mdao");
			

		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
		}
		
		
		return result;
	}

}





















