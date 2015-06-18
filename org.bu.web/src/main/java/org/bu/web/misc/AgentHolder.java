package org.bu.web.misc;

import javax.servlet.http.HttpServletRequest;

public class AgentHolder {

	public static boolean isIE(HttpServletRequest request) {
		return request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") != -1 ? true : false;
	}

}
