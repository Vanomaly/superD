package com.vanomaly.jutils;

import java.io.File;   
import java.io.IOException;
import java.io.StringReader;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;  
import javax.xml.transform.Source;  
import javax.xml.transform.Transformer;   
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
  
import org.w3c.dom.Document;  
import org.xml.sax.InputSource;  
import org.xml.sax.SAXException;

public class TransformXML {
	public static boolean convertStringtoXMLDoc(String xmlString, String saveDirectory, String fileName) {
		boolean success = false;  	
        // parse String to XML
        try {
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			transformXML(doc, saveDirectory, fileName);
			success = true;
		} catch (SAXException e) {
			e.printStackTrace();
			success = false;
		} catch (IOException e) {
			e.printStackTrace();
			success = false;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			success = false;
		}
        return success;
	}
	public static boolean transformXML(Document doc, String saveDirectory, String fileName) {
    	String saveFile = null;
     	boolean success = false;
        //set up a transformer
    	try {
    		TransformerFactory transfac = TransformerFactory.newInstance();
    		Transformer trans = transfac.newTransformer();
    		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    		trans.setOutputProperty(OutputKeys.INDENT, "yes");
    		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        	
    		doc.setXmlStandalone(true);

    		saveFile = saveDirectory + fileName;
		
    		//create string from xml tree
    		Result result = new StreamResult(new File(saveFile));
    		Source source = new DOMSource(doc);
        	
    		// perform transformation of String to XML and output to file
    		trans.transform(source, result);
    		success = true;
        } catch(Exception e) {
        	e.printStackTrace();
        	success = false;
        }
        return success;
	}
}