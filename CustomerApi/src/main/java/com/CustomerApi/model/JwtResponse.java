package com.CustomerApi.model;



public class JwtResponse {
	
	 private String jwtToken;
	    private String username;

	    // Private constructor to enforce the use of the builder
	    private JwtResponse() {}

	    public String getJwtToken() {
	        return jwtToken;
	    }

	    public String getUsername() {
	        return username;
	    }

	    // Builder class
	    public static class Builder {
	        private String jwtToken;
	        private String username;

	        public Builder jwtToken(String jwtToken) {
	            this.jwtToken = jwtToken;
	            return this;
	        }

	        public Builder username(String username) {
	            this.username = username;
	            return this;
	        }

	        public JwtResponse build() {
	            JwtResponse response = new JwtResponse();
	            response.jwtToken = this.jwtToken;
	            response.username = this.username;
	            return response;
	        }
	    }

	    // Static method to obtain a builder instance
	    public static Builder builder() {
	        return new Builder();
	    }
	
	
}
