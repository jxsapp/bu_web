package org.bu.web.shiro;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository("shiroService")
public class ShiroServiceCache implements ShiroService {

	private static HashMap<String, String> roleCache = new HashMap<String, String>();
	private static HashMap<String, String> innerCache = new HashMap<String, String>();

	public ShiroUser getByAccount(String username) {
		ShiroUser user = new ShiroUser();
		user.setName(username);
		if (roleCache.containsKey(username)) {
			user.setPassword(roleCache.get(username));
		}
		ShiroRole role = new ShiroRole("member");
		user.setRole(role);
		return user;
	}

	@Override
	public void saveOrUpdate(String username, String pwd) {
		roleCache.put(username, pwd);
	}

	@Override
	public void saveShiroInner(ShiroInner inner) {
		innerCache.put(inner.getSession(), inner.getUid());
	}

	@Override
	public ShiroInner getByTarget(String session) {
		ShiroInner user = new ShiroInner();
		if (innerCache.containsKey(session)) {
			user.setUid(innerCache.get(session));
		}
		return user;
	}

}
