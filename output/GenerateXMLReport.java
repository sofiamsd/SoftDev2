package output;

import data.Salesman;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateXMLReport extends GenerateReport {

    public GenerateXMLReport(Salesman a) {
        super(a);
    }

    @Override
    protected void saveReportToFile(String fullPathName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName + ".xml")))) {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element salesmanElem = document.createElement("Salesman");
            document.appendChild(salesmanElem);

            createAndAppendElement(document, salesmanElem, "Name", salesman.getName());
            createAndAppendElement(document, salesmanElem, "AFM", salesman.getAfm());
            createAndAppendElement(document, salesmanElem, "TotalSales", Double.toString(salesman.calculateTotalSales()));
            createAndAppendElement(document, salesmanElem, "TrouserSales", Float.toString(salesman.calculateTrouserSales()));
            createAndAppendElement(document, salesmanElem, "SkirtsSales", Float.toString(salesman.calculateSkirtsSales()));
            createAndAppendElement(document, salesmanElem, "ShirtsSales", Float.toString(salesman.calculateShirtsSales()));
            createAndAppendElement(document, salesmanElem, "CoatsSales", Float.toString(salesman.calculateCoatsSales()));
            createAndAppendElement(document, salesmanElem, "Commission", Double.toString(salesman.calculateCommission()));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource domSource = new DOMSource(document);
            
            // Update the StreamResult to use the same file name with the ".xml" extension
            StreamResult streamResult = new StreamResult(new File(fullPathName + ".xml"));
            
            transformer.transform(domSource, streamResult);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException("Could not generate XML file");
        }
    }

    private void createAndAppendElement(Document document, Element parent, String tagName, String textContent) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(textContent));
        parent.appendChild(element);
    }
}
