package com.web.jsp.Music.model.dao;

import static com.web.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.Music.model.vo.Music;

public class MusicDao {
	
	private Properties prop;
	
	public MusicDao() {
		
    prop = new Properties();
	String filePath = MusicDao.class.getResource("/config/music-query.properties").getPath();
	
	try {
		prop.load(new FileReader(filePath));
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	public ArrayList<Music> musicChart(Connection con) {
		
		ArrayList<Music> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("musicChart");
		
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Music>();
			
			while(rset.next()) {
				Music m = new Music();
				
				m.setMusicNo(rset.getInt(1));
				m.setMusicNm(rset.getString("music_Nm"));
				m.setMusicArtist(rset.getString("music_Artist"));
				m.setMusicGenre(rset.getString("music_Genre"));
				m.setRelativeAlbumNo(rset.getString("relative_Album_No"));
				m.setLikeMusic(rset.getString("like_Music"));
				m.setMusicImage(rset.getString("music_Image"));
				m.setMusicType(rset.getString("music_Type"));
				
//				m.setAlbumImage(rset.getString("album_Image"));
//				m.setReviewAlbum(rset.getString("review_Album"));
				
				list.add(m);				
				
			}
			System.out.println(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

}
