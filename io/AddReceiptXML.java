package io;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AddReceiptXML extends AddReceipt {

    @Override
    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    @Override
	public void appendFileSpecific() throws IOException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc;

            // Check if the file already exists
            if (fileToAppend.exists()) {
                doc = docBuilder.parse(fileToAppend);
            } else {
                // If the file doesn't exist, create a new document
                doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Salesman");
                doc.appendChild(rootElement);
            }

            Node salesman = doc.getFirstChild();

            Element receiptElem = doc.createElement("Receipt");
            salesman.appendChild(receiptElem);

            Element receiptIDElem = doc.createElement("ReceiptID");
            receiptIDElem.appendChild(doc.createTextNode(String.valueOf(receiptData.getReceiptId())));
            receiptElem.appendChild(receiptIDElem);

            Element dateElem = doc.createElement("Date");
            dateElem.appendChild(doc.createTextNode(receiptData.getDate()));
            receiptElem.appendChild(dateElem);

            Element kindElem = doc.createElement("Kind");
            kindElem.appendChild(doc.createTextNode(String.valueOf(kindData.getType())));
            receiptElem.appendChild(kindElem);

            Element salesElem = doc.createElement("Sales");
            salesElem.appendChild(doc.createTextNode(String.valueOf(receiptData.getSales())));
            receiptElem.appendChild(salesElem);

            Element itemsElem = doc.createElement("Items");
            itemsElem.appendChild(doc.createTextNode(String.valueOf(receiptData.getItems())));
            receiptElem.appendChild(itemsElem);

            Element companyElem = doc.createElement("Company");
            companyElem.appendChild(doc.createTextNode(String.valueOf(companyData.getCompany())));
            receiptElem.appendChild(companyElem);

            Element countryElem = doc.createElement("Country");
            countryElem.appendChild(doc.createTextNode(addressData.getCountry()));
            receiptElem.appendChild(countryElem);

            Element cityElem = doc.createElement("City");
            cityElem.appendChild(doc.createTextNode(addressData.getCity()));
            receiptElem.appendChild(cityElem);

            Element streetElem = doc.createElement("Street");
            streetElem.appendChild(doc.createTextNode(addressData.getStreet()));
            receiptElem.appendChild(streetElem);

            Element numberElem = doc.createElement("Number");
            numberElem.appendChild(doc.createTextNode(String.valueOf(addressData.getStreetNumber())));
            receiptElem.appendChild(numberElem);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fileToAppend);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
