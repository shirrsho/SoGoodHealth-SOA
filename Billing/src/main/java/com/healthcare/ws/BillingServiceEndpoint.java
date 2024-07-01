package com.healthcare.ws;

import com.healthcare.ws.billingservice.*;
import com.healthcare.ws.clients.AppointmentClient;
import com.healthcare.ws.clients.LoggerClient;
import com.healthcare.ws.clients.PatientClient;
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
public class BillingServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/BillingService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createInvoiceRequest")
	@ResponsePayload
	public CreateInvoiceResponse createInvoice(@RequestPayload CreateInvoiceRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		LoggerClient loggerClient = new LoggerClient();
		PatientClient reportClient = new PatientClient();
		AppointmentClient appointmentClient = new AppointmentClient();
		CreateInvoiceResponse response = factory.createCreateInvoiceResponse();
		code.setCode(201);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateInvoiceRequest")
	@ResponsePayload
	public UpdateInvoiceResponse updateInvoice(@RequestPayload UpdateInvoiceRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateInvoiceResponse response = factory.createUpdateInvoiceResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInvoicesRequest")
	@ResponsePayload
	public GetInvoicesResponse getInvoices(@RequestPayload GetInvoicesRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetInvoicesResponse response = factory.createGetInvoicesResponse();

		List<InvoiceType> invoices = getInvoices();

		response.getInvoices().addAll(invoices);
		return response;
	}

	private List<InvoiceType> getInvoices() throws DatatypeConfigurationException {
		List<InvoiceType> invoices = new ArrayList<>();
		InvoiceType invoice1 = new InvoiceType();
		invoice1.setId(1L);
		invoice1.setPatientId(100L);
		invoice1.setAmount(150.75);
		invoice1.setDueDate(toXMLGregorianCalendar(2024, 7, 15, 10, 30));
		invoice1.setPaid(false);

		InvoiceType invoice2 = new InvoiceType();
		invoice2.setId(2L);
		invoice2.setPatientId(101L);
		invoice2.setAmount(200.00);
		invoice2.setDueDate(toXMLGregorianCalendar(2024, 8, 1, 11, 0));
		invoice2.setPaid(true);

		invoices.add(invoice1);
		invoices.add(invoice2);
		return invoices;
	}

	private XMLGregorianCalendar toXMLGregorianCalendar(int year, int month, int day, int hour, int minute) throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}
