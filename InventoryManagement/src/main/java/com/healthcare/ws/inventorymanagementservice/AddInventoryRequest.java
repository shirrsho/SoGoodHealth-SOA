//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 02:17:59 AM BDT 
//


package com.healthcare.ws.inventorymanagementservice;

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
 *         &lt;element name="inventoryItem" type="{http://www.healthcare.com/ws/InventoryManagementService}inventoryItem"/&gt;
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
    "inventoryItem"
})
@XmlRootElement(name = "addInventoryRequest")
public class AddInventoryRequest {

    @XmlElement(required = true)
    protected InventoryItem inventoryItem;

    /**
     * Gets the value of the inventoryItem property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryItem }
     *     
     */
    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    /**
     * Sets the value of the inventoryItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryItem }
     *     
     */
    public void setInventoryItem(InventoryItem value) {
        this.inventoryItem = value;
    }

}
