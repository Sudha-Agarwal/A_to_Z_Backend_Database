package com.example.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class CustomSimpleTagHandler extends SimpleTagSupport{
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}	
	@Override
	public void doTag() throws JspException, IOException{
		getJspContext().getOut().write("CustomSimpleTagHandler: " + message);
	}

}
