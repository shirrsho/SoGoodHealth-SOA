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


public class LoggerClient {
    public static List<String> log() throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:log=\"http://www.healthcare.com/ws/LoggingService\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <log:logMessageRequest>\n" +
                "         <log:message>?</log:message>\n" +
                "         <log:severity>?</log:severity>\n" +
                "         <log:timestamp>?</log:timestamp>\n" +
                "      </log:logMessageRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8088/wsdlfirst/loggingService");

        NodeList nodeLst = document.getElementsByTagName("ns2:message");
        List<String> messages = new ArrayList<>();
        for(int i=0;i<nodeLst.getLength();i++)
            messages.add(nodeLst.item(i).getTextContent());

        return messages;
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