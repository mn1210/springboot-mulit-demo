package org.springboot.multi.demo.web.security;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// SysAccount user = repository.findByUserAccount(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
		
		// 加密后的密码 123
        String str = "$2a$10$bVGTsG6Mjby.Ug2fIty/JuQp4U7uzqXw4./tQHbWZPIL5fQ.PGAde";

        // 添加权限
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        User user = new User(username,str,authorities);


        return user;
	}

}
