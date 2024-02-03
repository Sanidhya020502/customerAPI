package com.CustomerApi.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CustomerApi.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public String isAuthentic(String loginId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	}
