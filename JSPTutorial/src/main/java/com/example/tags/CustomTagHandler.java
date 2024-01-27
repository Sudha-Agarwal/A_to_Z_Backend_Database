package com.example.tags;

import org.apache.jasper.el.JspELException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CustomTagHandler extends TagSupport{
	@Override
	public int doStartTag() throws JspException{
		try {
			pageContext.getOut().print("Hello from CustomTagHandler");
		}
		catch (Exception e) {
			throw new JspException(e.getMessage());
		}		
		return SKIP_BODY;
	}
	

}
