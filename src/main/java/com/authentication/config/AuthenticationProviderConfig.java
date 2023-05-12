package com.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.authentication.exceptions.ResourceNotFoundException;
import com.authentication.models.User;
import com.authentication.repositories.UsersRepository;

@Component
public class AuthenticationProviderConfig implements AuthenticationProvider {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userEmail = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		User userFound = this.usersRepository.findByEmail(userEmail).orElseThrow(() -> new BadCredentialsException("Incorrect email or password."));
		
		if(userFound.getUnconfirmed()) {
			throw new ResourceNotFoundException("Incorrect email or password.");
		}
		
		boolean passwordMatch = this.passwordEncoder.matches(password, userFound.getPassword());
		
		if(!passwordMatch) {
			throw new BadCredentialsException("Incorrect email or password.");
		}
	
		return new UsernamePasswordAuthenticationToken(userFound.getEmail(), null, userFound.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	

}
