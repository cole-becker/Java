//Write to XML file in Java
   
import java.io.*;  //imports input output libraries
import javax.xml.parsers.*;   //imports the library to be able to read(parse) xml files
import javax.xml.transform.*;   //library used to transform source to result
import javax.xml.transform.dom.DOMSource;       
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;   //allows for XML processing
import org.xml.sax.*;   //assists in XML processing
 
public class WriteXMLFile {
 
	public static void main(String argv[]) {
 
	  try {  //this trys to catch any expections in the code
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();   //this allows for the creation of the XML file
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();  //enables information to read from XML file 
 
		// root elements
		Document doc = docBuilder.newDocument();
                
		Element rootElement = doc.createElement("Class");  //calls the root element in the XML "Class"
		doc.appendChild(rootElement);
 
		// Student elements
		Element student = doc.createElement("Student");
		rootElement.appendChild(student);
 
		// set attribute to student element
		 student.setAttribute("Grade", "9");
 
		// firstname elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("Chris"));
		student.appendChild(firstname);
 
		// lastname elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("Smith"));
		student.appendChild(lastname);
 
		// Phone number elements
		Element phone = doc.createElement("Phone");
		phone.appendChild(doc.createTextNode("555-1313"));
		student.appendChild(phone);
 
		// Sex elements
		Element sex = doc.createElement("Sex");
		sex.appendChild(doc.createTextNode("Female"));
		student.appendChild(sex);
                
    		// 2nd Student's elements
		Element student2 = doc.createElement("Student");
		rootElement.appendChild(student2);
 
		// set attribute to student element
		student2.setAttribute("Grade", "10");
 
	
		// firstname elements
		Element firstname2 = doc.createElement("firstname");
		firstname2.appendChild(doc.createTextNode("Cody"));
		student2.appendChild(firstname2);
 
		// lastname elements
		Element lastname2 = doc.createElement("lastname");
		lastname2.appendChild(doc.createTextNode("Jones"));
		student2.appendChild(lastname2);
 
		// Phone number elements
		Element phone2 = doc.createElement("Phone");
		phone2.appendChild(doc.createTextNode("555-9089"));
		student2.appendChild(phone2);
 
		// Sex elements
		Element sex2 = doc.createElement("Sex");
		sex2.appendChild(doc.createTextNode("Male"));
		student2.appendChild(sex2);
                
                Element student3 = doc.createElement("Student");
                rootElement.appendChild(student3);
                
                student3.setAttribute("Grade", "10");
                
                Element firstname3 = doc.createElement("firstname");
                firstname3.appendChild(doc.createTextNode("Dale"));
                student3.appendChild(firstname3);
                
                Element lastname3 = doc.createElement("lastname");
                lastname3.appendChild(doc.createTextNode("Chan"));
                student3.appendChild(lastname3);
                
                Element phone3 = doc.createElement("Phone");
                phone3.appendChild(doc.createTextNode("555-0001"));
                student3.appendChild(phone3);
                
                Element sex3 = doc.createElement("Sex");
                sex3.appendChild(doc.createTextNode("Female"));
                student3.appendChild(sex3);
                
                Element student4 = doc.createElement("Student");
                rootElement.appendChild(student4);
                
                student4.setAttribute("Grade", "12");
                
                Element firstname4 = doc.createElement("firstname");
                firstname4.appendChild(doc.createTextNode("Sam"));
                student4.appendChild(firstname4);
                
                Element lastname4 = doc.createElement("lastname");
                lastname4.appendChild(doc.createTextNode("Habbib"));
                student4.appendChild(lastname4);
                
                Element phone4 = doc.createElement("Phone");
                phone4.appendChild(doc.createTextNode("555-0976"));
                student4.appendChild(phone4);
                
                Element sex4 = doc.createElement("Sex");
                sex4.appendChild(doc.createTextNode("Female"));
                student4.appendChild(sex4);
                
		// write the content into xml file
                
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
                
		Transformer transformer = transformerFactory.newTransformer();
                
		DOMSource source = new DOMSource(doc);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");   //makes sure the XML file is formatted nicely with indentation
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");  //makes sure the XML file is formatted nicely with indent space of 4 
		StreamResult result = new StreamResult(new File("output.xml"));  //creates the file called output
 
		// Output to console screen  for testing, but you need to comment-out the previous "StreamResult result" line above. 
		//StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File Saved In Project Directory");  //outputs to console "File Saved!"
 
	 } catch (ParserConfigurationException pce) {   //trys to catch any exceptions
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}