/*
File Name:	XMLcar
Programmer:	Cole Becker
Date:		June 26 2024
Purpose:        To create a program that creates a XML file with the information if create button clicked and if update
                button clicked it can add cars to the existing file.
*               
*/

import java.io.*;  //import XML packages
import javax.swing.JOptionPane;
import javax.xml.parsers.*;   
import javax.xml.transform.*;  
import javax.xml.transform.dom.DOMSource;       
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;   
import org.xml.sax.*;   

public class XMLcar extends javax.swing.JFrame {

    /**
     * Creates new form XMLcar
     */
    public XMLcar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yearIn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        companyIn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        styleIn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        colourIn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mileageIn = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XMLcar");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Car Inventory");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Year");

        yearIn.setBackground(new java.awt.Color(51, 51, 51));
        yearIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        yearIn.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Company");

        companyIn.setBackground(new java.awt.Color(51, 51, 51));
        companyIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        companyIn.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Style");

        styleIn.setBackground(new java.awt.Color(51, 51, 51));
        styleIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        styleIn.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Colour");

        colourIn.setBackground(new java.awt.Color(51, 51, 51));
        colourIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        colourIn.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mileage");

        mileageIn.setBackground(new java.awt.Color(51, 51, 51));
        mileageIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mileageIn.setForeground(new java.awt.Color(255, 255, 255));

        btnCreate.setBackground(new java.awt.Color(51, 51, 51));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create New XML File");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update XML");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(companyIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(yearIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(styleIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(colourIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mileageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(companyIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(styleIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colourIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mileageIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        try {
            
            int check = Integer.parseInt(yearIn.getText());
            int check2 = Integer.parseInt(mileageIn.getText());
 
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();   // allows xml file to be created
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
            Document doc = docBuilder.newDocument(); // root elements
                
            Element rootElement = doc.createElement("Inventory");  // calls the root Inventory
            doc.appendChild(rootElement);
 
            Element car = doc.createElement("Car"); // create element car
            rootElement.appendChild(car);
 
            Element year = doc.createElement("Year"); // create year element
            year.appendChild(doc.createTextNode(yearIn.getText()));

            Element company = doc.createElement("Company"); // create company element
            company.appendChild(doc.createTextNode(companyIn.getText()));
 
            Element style = doc.createElement("Style"); // create style element
            style.appendChild(doc.createTextNode(styleIn.getText()));
 
            Element colour = doc.createElement("Colour"); // create colour element
            colour.appendChild(doc.createTextNode(colourIn.getText()));
                
            Element mileage = doc.createElement("Mileage"); // create mileage element
            mileage.appendChild(doc.createTextNode(mileageIn.getText()));
            
            car.appendChild(year);
            car.appendChild(company);
            car.appendChild(style);
            car.appendChild(colour);
            car.appendChild(mileage);
            rootElement.appendChild(car);
                
            TransformerFactory transformerFactory = TransformerFactory.newInstance(); // allows the xml file content to be written
            Transformer transformer = transformerFactory.newTransformer();
                
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");   // gives the xml file indentation
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");  // set indent to 4
            StreamResult result = new StreamResult(new File("cars.xml"));  // creates file cars.xml
 
            transformer.transform(source, result);
 
            JOptionPane.showMessageDialog(null, "File has been sucessfully created!");  // outputs that the file is saved
 
	    }  catch (ParserConfigurationException pce) { // catch any exceptions
		pce.printStackTrace();
            } catch (TransformerException tfe) {
		tfe.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error invalid number for year/mileage."); // if non number added for milage or year
            }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            
            int check = Integer.parseInt(yearIn.getText());
            int check2 = Integer.parseInt(mileageIn.getText());
            
            String filepath = "cars.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();   // allows xml file to be created
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
            Document doc = docBuilder.parse(filepath); // parses the cars.xml file for existing cars
                
            Element rootElement = doc.getDocumentElement(); // gets inventory element
 
            Element car = doc.createElement("Car"); // create element car
            rootElement.appendChild(car);
 
            Element year = doc.createElement("Year"); // create year element
            year.appendChild(doc.createTextNode(yearIn.getText()));

            Element company = doc.createElement("Company"); // create company element
            company.appendChild(doc.createTextNode(companyIn.getText()));
 
            Element style = doc.createElement("Style"); // create style element
            style.appendChild(doc.createTextNode(styleIn.getText()));
 
            Element colour = doc.createElement("Colour"); // create colour element
            colour.appendChild(doc.createTextNode(colourIn.getText()));
                
            Element mileage = doc.createElement("Mileage"); // create mileage element
            mileage.appendChild(doc.createTextNode(mileageIn.getText()));
            
            car.appendChild(year); // append new car
            car.appendChild(company);
            car.appendChild(style);
            car.appendChild(colour);
            car.appendChild(mileage);
            rootElement.appendChild(car);
                
            TransformerFactory transformerFactory = TransformerFactory.newInstance(); // allows the xml file content to be written
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");   // gives the xml file indentation
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");  // set indent to 4
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath)); // creates new file with all cars that were saved in doc
            transformer.transform(source, result);
 
            JOptionPane.showMessageDialog(null, "File has been updated!");  // outputs that the file is saved
 
            }  catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	    } catch (TransformerException tfe) {
		tfe.printStackTrace();
	    } catch (IOException ioe) {
		ioe.printStackTrace();
	    } catch (SAXException sae) {
		sae.printStackTrace();
	    } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error invalid number for year/mileage."); // if non number added for milage or year
            }                             
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XMLcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XMLcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XMLcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XMLcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XMLcar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField colourIn;
    private javax.swing.JTextField companyIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mileageIn;
    private javax.swing.JTextField styleIn;
    private javax.swing.JTextField yearIn;
    // End of variables declaration//GEN-END:variables
}
