package com.example.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class CustomTagHandler2 extends BodyTagSupport{
	
	private String style;
	
	public void setStyle(String style) {
		this.style = style;
		System.out.println(this.style);
	}
	
	@Override
	public int doStartTag() throws JspException{
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException{
		try {
			if(bodyContent != null) {
				String content = bodyContent.getString();
				String output = "<span";
				if(style != null && !style.isEmpty()) {
					output+= " style =\"" + style + "\"";
				}
				output += ">" + content + "</span>";
				pageContext.getOut().write(output);
			}
			
		}
		catch(Exception e) {
			throw new JspException();
		}
		finally {
			return EVAL_PAGE;
		}
	}
	

}
