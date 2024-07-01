package com.healthcare.ws;

import com.healthcare.ws.patientservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
public class PatientServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/PatientService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerPatientRequest")
	@ResponsePayload
	public RegisterPatientResponse registerPatient(@RequestPayload RegisterPatientRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		RegisterPatientResponse response = factory.createRegisterPatientResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePatientRequest")
	@ResponsePayload
	public UpdatePatientResponse updatePatient(@RequestPayload UpdatePatientRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdatePatientResponse response = factory.createUpdatePatientResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPatientDetailsRequest")
	@ResponsePayload
	public GetPatientDetailsResponse getPatientDetails(@RequestPayload GetPatientDetailsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetPatientDetailsResponse response = factory.createGetPatientDetailsResponse();

		List<PatientType> patients = getPatientDetails();

		response.getPatient().addAll(patients);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePatientRequest")
	@ResponsePayload
	public DeletePatientResponse deletePatient(@RequestPayload DeletePatientRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		DeletePatientResponse response = factory.createDeletePatientResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	private List<PatientType> getPatientDetails() throws DatatypeConfigurationException {
		List<PatientType> patients = new ArrayList<>();
		PatientType patient1 = new PatientType();
		patient1.setId(1L);
		patient1.setFirstName("John");
		patient1.setLastName("Doe");
		patient1.setDob(createXMLGregorianCalendar("1990-01-01"));
		patient1.setGender("Male");
		patient1.setContact("1234567890");
		patient1.setAddress("1234 Elm Street");

		PatientType patient2 = new PatientType();
		patient2.setId(2L);
		patient2.setFirstName("Jane");
		patient2.setLastName("Doe");
		patient2.setDob(createXMLGregorianCalendar("1992-02-02"));
		patient2.setGender("Female");
		patient2.setContact("0987654321");
		patient2.setAddress("5678 Oak Street");

		patients.add(patient1);
		patients.add(patient2);
		return patients;
	}

	private XMLGregorianCalendar createXMLGregorianCalendar(String date) throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(java.sql.Date.valueOf(date));
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}