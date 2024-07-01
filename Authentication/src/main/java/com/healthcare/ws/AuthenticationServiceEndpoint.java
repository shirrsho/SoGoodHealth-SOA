package com.healthcare.ws;

import com.healthcare.ws.authenticationservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class AuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/AuthenticationService";

	private Map<String, String> tokenStore = new HashMap<>();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "authenticateUserRequest")
	@ResponsePayload
	public AuthenticateUserResponse authenticateUser(@RequestPayload AuthenticateUserRequest request) {
		ObjectFactory factory = new ObjectFactory();
		AuthenticateUserResponse response = factory.createAuthenticateUserResponse();
		StatusCode statusCode = factory.createStatusCode();

		String username = request.getUsername();
		String password = request.getPassword();

		// (always return success for demo)
		if (username.equals("demo") && password.equals("password")) {
			String token = generateToken();
			tokenStore.put(token, username);
			statusCode.setCode(200);
			response.setToken(token);
		} else {
			statusCode.setCode(401); // Unauthorized
		}

		response.setStatusCode(statusCode);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "authorizeUserRequest")
	@ResponsePayload
	public AuthorizeUserResponse authorizeUser(@RequestPayload AuthorizeUserRequest request) {
		ObjectFactory factory = new ObjectFactory();
		AuthorizeUserResponse response = factory.createAuthorizeUserResponse();
		StatusCode statusCode = factory.createStatusCode();

		String token = request.getToken();
		String resource = request.getResource();
		String action = request.getAction();

		// (always return success for demo)
		if (tokenStore.containsKey(token)) {
			statusCode.setCode(200);
		} else {
			statusCode.setCode(403); // Forbidden
		}

		response.setStatusCode(statusCode);
		return response;
	}

	private String generateToken() {
		return "generated-token";
	}
}
