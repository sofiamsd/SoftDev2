package input;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class XMLInput extends Input {

    public XMLInput(File receiptFileXML) {
        inputFile = receiptFileXML;
    }

    @Override
    public void readFile() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Salesman");

            name = getValueFromNode(nodeLst, "Name");
            afm = getValueFromNode(nodeLst, "AFM");
            addSalesman();

            NodeList receiptsNodeList = doc.getElementsByTagName("Receipt");
            int size = receiptsNodeList.getLength();

            for (int i = 0; i < size; i++) {
                Element receiptElement = (Element) receiptsNodeList.item(i);

                receiptID = Integer.parseInt(getValueFromNode(receiptElement, "ReceiptID"));
                date = getValueFromNode(receiptElement, "Date");
                clothingType = getValueFromNode(receiptElement, "Kind");
                sales = Double.parseDouble(getValueFromNode(receiptElement, "Sales"));
                items = Integer.parseInt(getValueFromNode(receiptElement, "Items"));
                companyName = getValueFromNode(receiptElement, "Company");
                companyCountry = getValueFromNode(receiptElement, "Country");
                companyCity = getValueFromNode(receiptElement, "City");
                companyStreet = getValueFromNode(receiptElement, "Street");
                companyStreetNumber = Integer.parseInt(getValueFromNode(receiptElement, "Number"));

                addReceipt();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while reading XML file");
        }
    }

    private String getValueFromNode(NodeList nodeList, String tagName) {
        return ((Element) nodeList.item(0)).getElementsByTagName(tagName)
                .item(0).getTextContent().trim();
    }

    private String getValueFromNode(Element element, String tagName) {
        return element.getElementsByTagName(tagName)
                .item(0).getTextContent().trim();
    }

    @Override
    protected void parseLine(String line) {
    }
}
