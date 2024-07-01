package com.healthcare.ws;

import com.healthcare.ws.doctorservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class DoctorServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/DoctorService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateDoctorRequest")
	@ResponsePayload
	public UpdateDoctorResponse updateDoctor(@RequestPayload UpdateDoctorRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateDoctorResponse response = factory.createUpdateDoctorResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteDoctorRequest")
	@ResponsePayload
	public DeleteDoctorResponse deleteDoctor(@RequestPayload DeleteDoctorRequest request) throws Exception {
		System.out.println("-->deleteDoctor<--");
		ObjectFactory factory = new ObjectFactory();
		DeleteDoctorResponse response = factory.createDeleteDoctorResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDoctorsRequest")
	@ResponsePayload
	public GetDoctorsResponse getDoctors(@RequestPayload GetDoctorsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetDoctorsResponse response = factory.createGetDoctorsResponse();

		List<DoctorType> doctors = getDoctors();

		response.getDoctors().addAll(doctors);
		return response;
	}

	private List<DoctorType> getDoctors() {
		List<DoctorType> doctors = new ArrayList<>();
		DoctorType doctor1 = new DoctorType();
		doctor1.setId(1L);
		doctor1.setName("Dr. John Smith");
		doctor1.setSpecialization("Cardiology");
		doctor1.setContact("1234567890");

		DoctorType doctor2 = new DoctorType();
		doctor2.setId(2L);
		doctor2.setName("Dr. Jane Doe");
		doctor2.setSpecialization("Neurology");
		doctor2.setContact("0987654321");

		doctors.add(doctor1);
		doctors.add(doctor2);
		return doctors;
	}
}
