package org.bu.web.shiro;

public class ShiroInner {

	private String session;
	private String uid;

	public ShiroInner() {
		super();
	}

	public ShiroInner(String session, String uid) {
		super();
		this.session = session;
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSession() {
		return session;
	}

	public static void main(String[] args) {
		ShiroInner inner = new ShiroInner("14sbntcjh0n1v1cx00zlrq51qv", "d");
		System.out.println(inner.getSession());
	}

}
