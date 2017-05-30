package fr.epsi.myEpsi.forms;

import javax.servlet.http.HttpServletRequest;

public abstract class AForm implements IForm {
	
	protected String result;

	@Override
	public String getResult() {
		return result;
	}

	@Override
	public String getValueFromRequest(HttpServletRequest request, String name) {
		String value = request.getParameter(name);
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}

}
