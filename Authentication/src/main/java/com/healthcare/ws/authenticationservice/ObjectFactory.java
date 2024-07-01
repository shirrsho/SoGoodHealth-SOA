//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 02:36:15 AM BDT 
//


package com.healthcare.ws.authenticationservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.healthcare.ws.authenticationservice package. 
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

    private final static QName _AuthenticationFault_QNAME = new QName("http://www.healthcare.com/ws/AuthenticationService", "authenticationFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.healthcare.ws.authenticationservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthenticateUserRequest }
     * 
     */
    public AuthenticateUserRequest createAuthenticateUserRequest() {
        return new AuthenticateUserRequest();
    }

    /**
     * Create an instance of {@link AuthenticateUserResponse }
     * 
     */
    public AuthenticateUserResponse createAuthenticateUserResponse() {
        return new AuthenticateUserResponse();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link AuthorizeUserRequest }
     * 
     */
    public AuthorizeUserRequest createAuthorizeUserRequest() {
        return new AuthorizeUserRequest();
    }

    /**
     * Create an instance of {@link AuthorizeUserResponse }
     * 
     */
    public AuthorizeUserResponse createAuthorizeUserResponse() {
        return new AuthorizeUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.healthcare.com/ws/AuthenticationService", name = "authenticationFault")
    public JAXBElement<String> createAuthenticationFault(String value) {
        return new JAXBElement<String>(_AuthenticationFault_QNAME, String.class, null, value);
    }

}
