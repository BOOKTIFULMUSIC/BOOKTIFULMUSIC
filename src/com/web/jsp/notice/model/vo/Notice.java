package com.web.jsp.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{


	private static final long serialVersionUID = -9010856112129664199L;
	
	private String nno;
	private String type;
	private String ntitle;
	private String nwriter;
	private String ncontent;
	private Date ndate;
	
	public Notice() {}

	public Notice(String nno, String type, String ntitle, String nwriter, String ncontent, Date ndate) {
		super();
		this.nno = nno;
		this.type = type;
		this.ntitle = ntitle;
		this.nwriter = nwriter;
		this.ncontent = ncontent;
		this.ndate = ndate;
	}

	public String getNno() {
		return nno;
	}

	public void setNno(String nno) {
		this.nno = nno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	@Override
	public String toString() {
		return "nno=" + nno + ", type=" + type + ", ntitle=" + ntitle + ", nwriter=" + nwriter + ", ncontent="
				+ ncontent + ", ndate=" + ndate;
	}
	
	
	

}
