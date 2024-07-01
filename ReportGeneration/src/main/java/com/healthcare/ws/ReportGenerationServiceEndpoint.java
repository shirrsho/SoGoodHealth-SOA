package com.healthcare.ws;

import com.healthcare.ws.reportgenerationservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

@Endpoint
public class ReportGenerationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/ReportGenerationService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generateReportRequest")
	@ResponsePayload
	public GenerateReportResponse generateReport(@RequestPayload GenerateReportRequest request) {
		ObjectFactory factory = new ObjectFactory();
		GenerateReportResponse response = factory.createGenerateReportResponse();
		StatusCode code = factory.createStatusCode();

		// Simulate report generation logic
		String reportId = request.getReportId();
		long patientId = request.getPatientId();

		// Generate report URL (sample implementation)
		String reportUrl = "http://example.com/reports/" + UUID.randomUUID().toString();

		code.setCode(200);
		response.setStatusCode(code);
		response.setReportUrl(reportUrl);

		return response;
	}
}
