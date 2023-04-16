package com.stocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.payloads.JwtAuthRequest;
import com.stocks.payloads.JwtAuthResponse;
import com.stocks.repositories.UserRepository;
import com.stocks.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<JwtAuthResponse> registerUser(@RequestBody JwtAuthRequest request) throws Exception{
		
		System.out.println(request.getUsername() + " " + request.getPassword());
//		request.setPassword(request.getPassword())
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = this.jwtTokenHelper.generateToken(authentication);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(), request.getPassword());
		System.out.println(request.getUsername() + " " + request.getPassword());
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(authentication);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			this.authenticationManager.authenticate(authenticationToken);
		}
		catch (BadCredentialsException e){
			System.out.println("Invalid Details Entered!");
			throw new Exception("Invalid username or password !");
		}
		
	}
	
}
