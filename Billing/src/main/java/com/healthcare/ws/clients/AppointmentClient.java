package com.healthcare.ws.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class AppointmentClient {
    public static List<String> getAppointment() throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:rep=\"http://www.healthcare.com/ws/ReportGenerationService\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <rep:generateReportRequest>\n" +
                "         <rep:reportId>?</rep:reportId>\n" +
                "         <rep:patientId>?</rep:patientId>\n" +
                "         <rep:startDate>?</rep:startDate>\n" +
                "         <rep:endDate>?</rep:endDate>\n" +
                "      </rep:generateReportRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8088/wsdlfirst/appointmentService");

        NodeList nodeLst = document.getElementsByTagName("ns2:message");
        List<String> report = new ArrayList<>();
        for(int i=0;i<nodeLst.getLength();i++)
            report.add(nodeLst.item(i).getTextContent());

        return report;
    }

    public static Document getParsedOutput(String xmlInput, String link) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(link);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        byte[] buffer = xmlInput.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "");
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        OutputStream request = httpConn.getOutputStream();
        request.write(buffer);
        request.close();

        BufferedReader response = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

        String line;
        String outputString="";
        while ((line = response.readLine()) != null)
            outputString += line;

        InputSource inputSource = new InputSource(new StringReader(outputString));
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
    }
}