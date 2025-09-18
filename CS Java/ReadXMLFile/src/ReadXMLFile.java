//read a XML file and display the value

import java.io.*;  //imports input output libraries
import javax.xml.parsers.*;   //imports the library to be able to read(parse) xml files
import javax.xml.transform.*;   //library used to transform source to result
import javax.xml.transform.dom.DOMSource;       
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;   //allows for XML processing
import org.xml.sax.*;   //assists in XML processing

public class ReadXMLFile {
 
   public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("studentlist.xml"));   //load xml file 
            doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is "+ doc.getDocumentElement().getNodeName());   //displays the name of the root element "Class"
            NodeList listOfPersons = doc.getElementsByTagName("Student");   
            int totalPersons = listOfPersons.getLength();  //counts the number of Student elements
            System.out.println("Total number of people: "+ totalPersons);  //displays the total number of students
            
           
            
            System.out.println("----------------------------");  //creates a line break 

            for (int s = 0; s<listOfPersons.getLength(); s++) {  //run a loop to display all student's firstnames, lastname and phone number
                Node firstPersonNode = listOfPersons.item(s);
                if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element firstPersonElement = (Element) firstPersonNode;
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("firstname");
                    Element firstNameElement = (Element) firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    System.out.println("First Name: " + ((Node)textFNList.item(0)).getNodeValue().trim());
                    NodeList lastNameList = firstPersonElement.getElementsByTagName("lastname");
                    Element lastNameElement = (Element)lastNameList.item(0);
                    NodeList textLNList = lastNameElement.getChildNodes();
                    System.out.println("Last Name: " + ((Node)textLNList.item(0)).getNodeValue().trim());
                    NodeList ageList = firstPersonElement.getElementsByTagName("Phone");
                    Element ageElement = (Element)ageList.item(0);
                    NodeList textAgeList = ageElement.getChildNodes();
                    System.out.println("Phone: " + ((Node)textAgeList.item(0)).getNodeValue().trim());

                }
            }
            
            System.out.println("----------------------------");
            
            Node DOB1 = doc.getElementsByTagName("dateofbirth").item(0);    //getting the 1st student dateofbirth element
            System.out.println("Chris's Date of Birth: " +DOB1.getFirstChild().getNodeValue());   //print dob of chris
            
            System.out.println("----------------------------");
            
            Node FN3 = doc.getElementsByTagName("firstname").item(2);  //getting 3rd student's name
            Node Sex3 = doc.getElementsByTagName("Sex").item(2);     //getting 3rd student's Sex
            System.out.println(FN3.getFirstChild().getNodeValue() +" is " + Sex3.getFirstChild().getNodeValue());  //display name and sex of 3rd student
            
            System.out.println("----------------------------");
            
        } catch (SAXParseException err) {

        }
        System.exit(0);
    }

}
