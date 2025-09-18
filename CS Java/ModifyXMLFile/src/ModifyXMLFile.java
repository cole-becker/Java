//Modify XML file 
/*  Append a new "dateOfBirth" to Student 1 Chris 
    Change Sam's name to Samaiya
    Update the student3 (Dale) grade to = 11
    Append a new "age" to Student 3 Dale
    Update sex of Dale to Male
    Delete “lastname” element under student3 Dale */

import java.io.*;  //imports input output libraries
import javax.xml.parsers.*;   //imports the library to be able to read(parse) xml files
import javax.xml.transform.*;   //library used to transform source to result
import javax.xml.transform.dom.DOMSource;       
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;   //allows for XML processing
import org.xml.sax.*;   //assists in XML processing

public class ModifyXMLFile {

    public static void main(String[] args) {
        
          try {
		String filepath = "output.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);
 
		// Get the root element
		Node Class = doc.getFirstChild();
 
		// Get the student element , it may not working if tag has spaces, or
		// whatever weird characters in front...it's better to use
		// getElementsByTagName() to get it directly.
		// Node student = Class.getFirstChild();
 
                 //Get the first student's(Chris) element by tag name directly  
                Node Student = doc.getElementsByTagName("Student").item(0);

                 //append a new node to Chris
                Element dateOfBirth = doc.createElement("dateofbirth");
                dateOfBirth.appendChild(doc.createTextNode("12/11/2000"));
                Student.appendChild(dateOfBirth);


                // change the name of the 4th student Sam to Samaiya
                Node a = doc.getElementsByTagName("firstname").item(3);
                a.setTextContent("Samaiya");

                
                
		// Get Dale's element by tag name directly
		Node student = doc.getElementsByTagName("Student").item(2);
 
		// update student attribute to grade 11
		NamedNodeMap attr = student.getAttributes();
		Node nodeAttr = attr.getNamedItem("Grade");
		nodeAttr.setTextContent("11");
 
		// append a new node "age" to student 3(Dale)
		Element age = doc.createElement("age");
		age.appendChild(doc.createTextNode("17"));
		student.appendChild(age);
 
		// loop Dale's student child node . You can also change these directly like above, but using a loop also possible to change multiple elements
		NodeList list = student.getChildNodes();
 
		for (int i = 0; i < list.getLength(); i++) {  
 
                   Node node = list.item(i);
 
		   // get the sex element, and update the value to male
		   if ("Sex".equals(node.getNodeName())) {
			node.setTextContent("Male");  
		   }
 
                   //remove his lastname
		   if ("lastname".equals(node.getNodeName())) {
			student.removeChild(node);
		   }
 
		}
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");   //makes sure the XML file is formatted nicely with indentation
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");  //makes sure the XML file is formatted nicely with indent space of 4 
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);
 
		System.out.println("Your XML is updated, check the project directory for output");
 
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }

    }
    
}
