package edu.tinzel.Cars.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class BaseAction {
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	public PrintWriter getOut() throws IOException{
		HttpServletResponse response=getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		return out;
	}
}
