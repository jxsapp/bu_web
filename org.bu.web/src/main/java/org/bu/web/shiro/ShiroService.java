package org.bu.web.shiro;

public interface ShiroService {

	public ShiroUser getByAccount(String username);

	public void saveOrUpdate(String username, String pwd);

	public void saveShiroInner(ShiroInner inner);

	public ShiroInner getByTarget(String target);

}
