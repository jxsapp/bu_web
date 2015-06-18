package org.bu.web.misc;

public enum Error {

	SUCCESS(-1, "success"), //
	FAILURE(0, "failure"), //
	UN_KONWN_ERROR(1, "UnKnown Error!!"), //
	NO_PERMISSIONS(2, "No permissions"), //
	LOGIN_ERR(1001, "用户名或密码错误"), //

	MATTER_TEMPLATE_NOT_FOUND(3, "not found this matter template"), //
	EXCEPTION_404(404, "页面不存在"), //
	EXCEPTION_500(404, "Server error");//

	public int index = 0;
	public String desc = "";

	private Error(int index, String desc) {
		this.index = index;
		this.desc = desc;
	}

}
