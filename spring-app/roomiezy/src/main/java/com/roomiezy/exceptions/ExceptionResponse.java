package com.roomiezy.exceptions;
import java.util.Date;

public class ExceptionResponse {
	private String msg;
	private String detail;
	private Date timeStamp;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ExceptionResponse(String msg, String detail, Date timeStamp) {
		super();
		this.msg = msg;
		this.detail = detail;
		this.timeStamp = timeStamp;
	}
}
