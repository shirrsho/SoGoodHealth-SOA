package com.healthcare.ws;

import com.healthcare.ws.insurancemanagementservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class InsuranceManagementServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/InsuranceManagementService";

	// Simulated database or storage for policies
	private Map<Long, Policy> policies = new HashMap<>();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPolicyRequest")
	@ResponsePayload
	public CreatePolicyResponse createPolicy(@RequestPayload CreatePolicyRequest request) {
		ObjectFactory factory = new ObjectFactory();
		CreatePolicyResponse response = factory.createCreatePolicyResponse();
		StatusCode statusCode = factory.createStatusCode();

		Policy newPolicy = request.getPolicy();
		policies.put(newPolicy.getId(), newPolicy);

		statusCode.setCode(200);
		response.setStatusCode(statusCode);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePolicyRequest")
	@ResponsePayload
	public UpdatePolicyResponse updatePolicy(@RequestPayload UpdatePolicyRequest request) {
		ObjectFactory factory = new ObjectFactory();
		UpdatePolicyResponse response = factory.createUpdatePolicyResponse();
		StatusCode statusCode = factory.createStatusCode();

		Policy updatedPolicy = request.getPolicy();
		policies.put(updatedPolicy.getId(), updatedPolicy);

		statusCode.setCode(200);
		response.setStatusCode(statusCode);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPolicyRequest")
	@ResponsePayload
	public GetPolicyResponse getPolicy(@RequestPayload GetPolicyRequest request) {
		ObjectFactory factory = new ObjectFactory();
		GetPolicyResponse response = factory.createGetPolicyResponse();

		long id = request.getId();
		Policy policy = policies.get(id);

		if (policy != null) {
			response.setPolicy(policy);
		} else {
			// Simulate fault response if policy is not found
			System.out.println("error");;
		}

		return response;
	}
}
