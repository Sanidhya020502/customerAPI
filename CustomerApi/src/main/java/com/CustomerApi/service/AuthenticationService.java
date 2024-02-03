package com.CustomerApi.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
	public String isAuthentic(String loginId, String password);
}
