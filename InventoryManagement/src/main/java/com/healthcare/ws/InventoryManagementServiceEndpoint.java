package com.healthcare.ws;

import com.healthcare.ws.inventorymanagementservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class InventoryManagementServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/InventoryManagementService";

	// Simulated database or inventory system
	private Map<Long, InventoryItem> inventory = new HashMap<>();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addInventoryRequest")
	@ResponsePayload
	public AddInventoryResponse addInventory(@RequestPayload AddInventoryRequest request) {
		ObjectFactory factory = new ObjectFactory();
		AddInventoryResponse response = factory.createAddInventoryResponse();
		StatusCode statusCode = factory.createStatusCode();

		InventoryItem newItem = request.getInventoryItem();
		inventory.put(newItem.getId(), newItem);

		statusCode.setCode(200);
		response.setStatusCode(statusCode);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateInventoryRequest")
	@ResponsePayload
	public UpdateInventoryResponse updateInventory(@RequestPayload UpdateInventoryRequest request) {
		ObjectFactory factory = new ObjectFactory();
		UpdateInventoryResponse response = factory.createUpdateInventoryResponse();
		StatusCode statusCode = factory.createStatusCode();

		InventoryItem updatedItem = request.getInventoryItem();
		inventory.put(updatedItem.getId(), updatedItem);

		statusCode.setCode(200);
		response.setStatusCode(statusCode);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInventoryRequest")
	@ResponsePayload
	public GetInventoryResponse getInventory(@RequestPayload GetInventoryRequest request) {
		ObjectFactory factory = new ObjectFactory();
		GetInventoryResponse response = factory.createGetInventoryResponse();

		long id = request.getId();
		InventoryItem item = inventory.get(id);

		if (item != null) {
			response.setInventoryItem(item);
		} else {
			// Simulate fault response if item is not found
			System.out.println("error");
		}

		return response;
	}
}
