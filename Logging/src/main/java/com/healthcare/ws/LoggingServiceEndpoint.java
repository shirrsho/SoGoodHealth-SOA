package com.healthcare.ws;

import com.healthcare.ws.loggingservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Random;

@Endpoint
public class LoggingServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/LoggingService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "logMessageRequest")
	@ResponsePayload
	public LogMessageResponse logMessage(@RequestPayload LogMessageRequest request) {
		ObjectFactory factory = new ObjectFactory();
		LogMessageResponse response = factory.createLogMessageResponse();
		StatusCode statusCode = factory.createStatusCode();

		String message = request.getMessage();
		String severity = request.getSeverity();

		System.out.println("Logged message: " + message + " (Severity: " + severity + ")");

		statusCode.setCode(new Random().nextInt(2) == 0 ? 200 : 500);
		response.setStatusCode(statusCode);

		return response;
	}
}
