package opensnzTech.shopWindows.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import opensnzTech.shopWindows.beans.User;
import opensnzTech.shopWindows.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username)
		        .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec username: " + username));

		    return UserDetailsImpl.build(user);
	}

}
