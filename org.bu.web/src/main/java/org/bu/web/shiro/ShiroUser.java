/**
 * 
 */
package org.bu.web.shiro;

/**
 * @author chenlf
 * 
 *         2014-3-24
 */
public class ShiroUser {
	private String name = "";
	private String password = "";
	private ShiroRole role;

	public ShiroUser() {

	}

	public ShiroUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(ShiroRole role) {
		this.role = role;
	}

	public ShiroRole getRole() {
		return role;
	}

}
