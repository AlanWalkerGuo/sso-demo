/**
 * 
 */
package com.guosh.sso.server;

import com.guosh.Privilege;
import com.guosh.SysRole;
import com.guosh.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guosh
 *
 */
@Component
public class SsoUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SysRole> sysRoleList=new ArrayList<>();
		SysRole sysRole=new SysRole();
		sysRole.setRoleId("ROLE_USER");
		sysRole.setRoleName("普通用户");

		sysRoleList.add(sysRole);

		List<Privilege> privileges=new ArrayList<>();
		Privilege privilege=new Privilege();
		privilege.setId("1");
		privilege.setName("sys:user:list");
		privileges.add(privilege);


		SysUser user=new SysUser();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("123456"));
		user.setSysRoles(sysRoleList);
		user.setPrivileges(privileges);

		return  user;
	}

}
