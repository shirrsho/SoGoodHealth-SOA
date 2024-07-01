package com.healthcare.ws;

import com.healthcare.ws.appointmentservice.*;
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
public class AppointmentServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/AppointmentService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAppointmentRequest")
	@ResponsePayload
	public CreateAppointmentResponse createAppointment(@RequestPayload CreateAppointmentRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		CreateAppointmentResponse response = factory.createCreateAppointmentResponse();
		code.setCode(201);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "cancelAppointmentRequest")
	@ResponsePayload
	public CancelAppointmentResponse cancelAppointment(@RequestPayload CancelAppointmentRequest request) throws Exception {
		System.out.println("-->cancelAppointment<--");
		ObjectFactory factory = new ObjectFactory();
		CancelAppointmentResponse response = factory.createCancelAppointmentResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAppointmentsRequest")
	@ResponsePayload
	public GetAppointmentsResponse getAppointments(@RequestPayload GetAppointmentsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetAppointmentsResponse response = factory.createGetAppointmentsResponse();

		List<AppointmentType> appointments = getAppointments();

		response.getAppointments().addAll(appointments);
		return response;
	}

	private List<AppointmentType> getAppointments() throws DatatypeConfigurationException {
		List<AppointmentType> appointments = new ArrayList<>();
		AppointmentType appointment1 = new AppointmentType();
		appointment1.setId(1L);
		appointment1.setPatientId(100L);
		appointment1.setDoctorId(200L);
		appointment1.setAppointmentDate(toXMLGregorianCalendar(2024, 7, 1, 10, 30));

		AppointmentType appointment2 = new AppointmentType();
		appointment2.setId(2L);
		appointment2.setPatientId(101L);
		appointment2.setDoctorId(201L);
		appointment2.setAppointmentDate(toXMLGregorianCalendar(2024, 7, 2, 11, 0));

		appointments.add(appointment1);
		appointments.add(appointment2);
		return appointments;
	}

	private XMLGregorianCalendar toXMLGregorianCalendar(int year, int month, int day, int hour, int minute) throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}
