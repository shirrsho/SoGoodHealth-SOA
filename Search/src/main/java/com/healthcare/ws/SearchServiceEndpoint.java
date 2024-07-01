package com.healthcare.ws;

import com.healthcare.ws.searchservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class SearchServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/SearchService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchRequest")
	@ResponsePayload
	public SearchResponse search(@RequestPayload SearchRequest request) {
		ObjectFactory factory = new ObjectFactory();
		SearchResponse response = factory.createSearchResponse();

		String query = request.getParams().getQuery();
		int maxResults = request.getParams().getMaxResults();

		List<SearchResult> results = performSearch(query, maxResults);

		response.getResult().addAll(results);
		return response;
	}

	private List<SearchResult> performSearch(String query, int maxResults) {
		List<SearchResult> results = new ArrayList<>();
		for (int i = 1; i <= maxResults; i++) {
			SearchResult result = new SearchResult();
			result.setId(i);
			result.setType("Sample Type");
			result.setName("Sample Name " + i);
			results.add(result);
		}
		return results;
	}
}
