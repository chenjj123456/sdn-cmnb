/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gwtt.ems.cmnb.util;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

public class JaxbObjectAndXmlUtil {
    static String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    
    /**
     * 将xml字符串转换成java对象
     * @param <T>
     * @param xmlString
     * @param c
     * @return 
     */
    public static <T> T xml2Object(String xmlString, Class<T> c) {
        if(!xmlString.contains(xmlHeader)){
            xmlString = xmlHeader + xmlString;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(new StringReader(xmlString));
            return t;

        } catch (JAXBException e) {
            return null;
        }

    }
    
    /**
     * 将java对象转换成xml字符串
     * @param <T>
     * @param c
     * @param t
     * @return 
     */
    public static <T> String object2xml( Class<T> c, T t) {
        String result = "";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();;
            JAXBContext context = JAXBContext.newInstance(c);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//去掉XML头部
            marshaller.marshal(t,doc);
            
            TransformerFactory   tf   =   TransformerFactory.newInstance();
            Transformer tt = tf.newTransformer();
            //tt.setOutputProperty(/"encoding/",/"GB23121/");
            ByteArrayOutputStream   bos   =   new   ByteArrayOutputStream();
            tt.transform(new DOMSource(doc), new StreamResult(bos));
            result = bos.toString();
        } catch (JAXBException | ParserConfigurationException | TransformerException e) {
            
        }
        if(result.contains("<?xml")){
            result = result.substring(result.indexOf("?>")+2);
        }
        return result;
    }
    
}
