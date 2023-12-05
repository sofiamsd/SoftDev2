package output;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Salesman;

public class GenerateXMLReport extends GenerateReport{

		
	public GenerateXMLReport(Salesman a){
			salesman = a;
	}	

		
	public void saveFile() {
	    try {
	        // Create a file chooser
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Save XML Report");
	        fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));

	        int userSelection = fileChooser.showSaveDialog(null);

	        if (userSelection == JFileChooser.APPROVE_OPTION) {
	            File fileToSave = fileChooser.getSelectedFile();

	            if (!fileToSave.getName().toLowerCase().endsWith(".xml")) {
	                
	                fileToSave = new File(fileToSave.getAbsolutePath() + ".xml");
	            }

	            String fullPathName = fileToSave.getAbsolutePath();

	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	            Document document = documentBuilder.newDocument();

	            // Root element
	            Element salesmanElem = document.createElement("Saleman");
	            document.appendChild(salesmanElem);

	            // Agent's name
	            Element name = document.createElement("Name");
	            name.appendChild(document.createTextNode(salesman.getName()));
	            salesmanElem.appendChild(name);

	            // Agent's AFM
	            Element afm = document.createElement("AFM");
	            afm.appendChild(document.createTextNode(salesman.getAfm()));
	            salesmanElem.appendChild(afm);

	            // Total Sales
	            Element totalSales = document.createElement("TotalSales");
	            totalSales.appendChild(document.createTextNode(Double.toString(salesman.calculateTotalSales())));
	            salesmanElem.appendChild(totalSales);

	            // Trouser Sales
	            Element trouserSales = document.createElement("TrouserSales");
	            trouserSales.appendChild(document.createTextNode(Float.toString(salesman.calculateTrouserSales())));
	            salesmanElem.appendChild(trouserSales);

	            // Skirt Sales
	            Element skirtsSales = document.createElement("SkirtsSales");
	            skirtsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateSkirtsSales())));
	            salesmanElem.appendChild(skirtsSales);

	            // Shirt Sales
	            Element shirtsSales = document.createElement("ShirtsSales");
	            shirtsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateShirtsSales())));
	            salesmanElem.appendChild(shirtsSales);

	            // Coat Sales
	            Element coatsSales = document.createElement("CoatsSales");
	            coatsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateCoatsSales())));
	            salesmanElem.appendChild(coatsSales);

	            // Commission
	            Element commission = document.createElement("Commission");
	            commission.appendChild(document.createTextNode(Double.toString(salesman.calculateCommission())));
	            salesmanElem.appendChild(commission);

	            // Transform and save to the selected file
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(fullPathName));
	            transformer.transform(domSource, streamResult);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}


}

