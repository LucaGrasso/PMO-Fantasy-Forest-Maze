package it.lucagrasso.models;

/**
 * @author lgras  on  30/05/2022
 * @project interactive-maze
 */


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Setup {

    // variable on main memory
    private static volatile Setup instance;

    private int totChar;
    private String url_character;

    private static final String URL_SETUP =  "src/setup.xml";

    private static String readXML(String element, String attribute, String attributeValue) {
        try {
            File inputFile = new File("src/setup.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName(element);
            //System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    //System.out.println("Attribute : " + eElement.getAttribute("section"));
                    if (eElement.getAttribute(attribute).equals(attributeValue)) {
                        System.out.println(eElement.getElementsByTagName("value").item(0).getTextContent());
                        return (eElement.getElementsByTagName("value").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String getFindValue(String element, String attribute,String attrValue) {
//        readXML(element,attribute, attrValue);
//        return findValue;
//    }

//    private static String setup(String element, String attribute) {
//        return setup(element, attribute, "");
//    }
//
//    private static String setup(String element) {
//        return setup(element, "", "");
//    }

    // Singleton Pattern

    public int getTotChar() {
        return totChar = Integer.parseInt(readXML("setup","section","total_character"));
    }
    public String getUrl_character() {
        return url_character = readXML("setup","section","url_character");
    }

    public String getHead_File_Name() {
        return url_character = readXML("setup","section","head_file_name");
    }

    public String getBody_File_Name() {
        return url_character = readXML("setup","section","body_file_name");
    }



//    // da valurare
//    private static Setup getInstance(){
//        if (instance == null){
//            instance = new Setup();
//        }
//        return instance;
//    }

}


