//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 11:36:22 AM BDT 
//


package com.healthcare.ws.appointmentservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.healthcare.ws.appointmentservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AppointmentFault_QNAME = new QName("http://www.healthcare.com/ws/AppointmentService", "appointmentFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.healthcare.ws.appointmentservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateAppointmentRequest }
     * 
     */
    public CreateAppointmentRequest createCreateAppointmentRequest() {
        return new CreateAppointmentRequest();
    }

    /**
     * Create an instance of {@link AppointmentType }
     * 
     */
    public AppointmentType createAppointmentType() {
        return new AppointmentType();
    }

    /**
     * Create an instance of {@link CreateAppointmentResponse }
     * 
     */
    public CreateAppointmentResponse createCreateAppointmentResponse() {
        return new CreateAppointmentResponse();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link CancelAppointmentRequest }
     * 
     */
    public CancelAppointmentRequest createCancelAppointmentRequest() {
        return new CancelAppointmentRequest();
    }

    /**
     * Create an instance of {@link CancelAppointmentResponse }
     * 
     */
    public CancelAppointmentResponse createCancelAppointmentResponse() {
        return new CancelAppointmentResponse();
    }

    /**
     * Create an instance of {@link GetAppointmentsRequest }
     * 
     */
    public GetAppointmentsRequest createGetAppointmentsRequest() {
        return new GetAppointmentsRequest();
    }

    /**
     * Create an instance of {@link GetAppointmentsResponse }
     * 
     */
    public GetAppointmentsResponse createGetAppointmentsResponse() {
        return new GetAppointmentsResponse();
    }

    /**
     * Create an instance of {@link AppointmentTypes }
     * 
     */
    public AppointmentTypes createAppointmentTypes() {
        return new AppointmentTypes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.healthcare.com/ws/AppointmentService", name = "appointmentFault")
    public JAXBElement<String> createAppointmentFault(String value) {
        return new JAXBElement<String>(_AppointmentFault_QNAME, String.class, null, value);
    }

}
