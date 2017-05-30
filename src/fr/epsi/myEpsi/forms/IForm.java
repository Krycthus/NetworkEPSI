package fr.epsi.myEpsi.forms;

import javax.servlet.http.HttpServletRequest;;

public interface IForm {
	
	public String getResult();
	public String getValueFromRequest (HttpServletRequest request, String name);
}
