package com.healthcare.ws;

import com.healthcare.ws.notificationservice.*;
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
public class NotificationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.healthcare.com/ws/NotificationService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendNotificationRequest")
	@ResponsePayload
	public SendNotificationResponse sendNotification(@RequestPayload SendNotificationRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		SendNotificationResponse response = factory.createSendNotificationResponse();
		code.setCode(201);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateNotificationRequest")
	@ResponsePayload
	public UpdateNotificationResponse updateNotification(@RequestPayload UpdateNotificationRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateNotificationResponse response = factory.createUpdateNotificationResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNotificationsRequest")
	@ResponsePayload
	public GetNotificationsResponse getNotifications(@RequestPayload GetNotificationsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetNotificationsResponse response = factory.createGetNotificationsResponse();

		List<NotificationType> notifications = getNotifications();

		response.getNotifications().addAll(notifications);
		return response;
	}

	private List<NotificationType> getNotifications() throws DatatypeConfigurationException {
		List<NotificationType> notifications = new ArrayList<>();
		NotificationType notification1 = new NotificationType();
		notification1.setId(1L);
		notification1.setMessage("Your appointment is scheduled for tomorrow at 10 AM.");
		notification1.setDate(toXMLGregorianCalendar(2024, 7, 1, 10, 30));

		NotificationType notification2 = new NotificationType();
		notification2.setId(2L);
		notification2.setMessage("Your medical report is ready for collection.");
		notification2.setDate(toXMLGregorianCalendar(2024, 7, 2, 11, 0));

		notifications.add(notification1);
		notifications.add(notification2);
		return notifications;
	}

	private XMLGregorianCalendar toXMLGregorianCalendar(int year, int month, int day, int hour, int minute) throws DatatypeConfigurationException {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}
