//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 11:45:41 AM BDT 
//


package com.healthcare.ws.medicalrecordservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="medicalRecordType" type="{http://www.healthcare.com/ws/MedicalRecordService}MedicalRecordType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medicalRecordType"
})
@XmlRootElement(name = "updateMedicalRecordRequest")
public class UpdateMedicalRecordRequest {

    @XmlElement(required = true)
    protected MedicalRecordType medicalRecordType;

    /**
     * Gets the value of the medicalRecordType property.
     * 
     * @return
     *     possible object is
     *     {@link MedicalRecordType }
     *     
     */
    public MedicalRecordType getMedicalRecordType() {
        return medicalRecordType;
    }

    /**
     * Sets the value of the medicalRecordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicalRecordType }
     *     
     */
    public void setMedicalRecordType(MedicalRecordType value) {
        this.medicalRecordType = value;
    }

}
