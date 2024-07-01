package com.healthcare.ws;

import com.healthcare.ws.medicalrecordservice.*;
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
public class MedicalRecordServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/MedicalRecordService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createMedicalRecordRequest")
	@ResponsePayload
	public CreateMedicalRecordResponse createMedicalRecord(@RequestPayload CreateMedicalRecordRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		CreateMedicalRecordResponse response = factory.createCreateMedicalRecordResponse();
		code.setCode(201);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMedicalRecordRequest")
	@ResponsePayload
	public UpdateMedicalRecordResponse updateMedicalRecord(@RequestPayload UpdateMedicalRecordRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateMedicalRecordResponse response = factory.createUpdateMedicalRecordResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMedicalRecordsRequest")
	@ResponsePayload
	public GetMedicalRecordsResponse getMedicalRecords(@RequestPayload GetMedicalRecordsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetMedicalRecordsResponse response = factory.createGetMedicalRecordsResponse();

		List<MedicalRecordType> medicalRecords = getMedicalRecords();

		response.getMedicalRecords().addAll(medicalRecords);
		return response;
	}

	private List<MedicalRecordType> getMedicalRecords() throws DatatypeConfigurationException {
		List<MedicalRecordType> medicalRecords = new ArrayList<>();
		MedicalRecordType record1 = new MedicalRecordType();
		record1.setId(1L);
		record1.setPatientId(100L);
		record1.setDoctorId(200L);
		record1.setRecordDate(toXMLGregorianCalendar(2024, 7, 1, 10, 30));
		record1.setNotes("Patient shows signs of improvement.");

		MedicalRecordType record2 = new MedicalRecordType();
		record2.setId(2L);
		record2.setPatientId(101L);
		record2.setDoctorId(201L);
		record2.setRecordDate(toXMLGregorianCalendar(2024, 7, 2, 11, 0));
		record2.setNotes("Scheduled for follow-up appointment.");

		medicalRecords.add(record1);
		medicalRecords.add(record2);
		return medicalRecords;
	}

	private XMLGregorianCalendar toXMLGregorianCalendar(int year, int month, int day, int hour, int minute) throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}
