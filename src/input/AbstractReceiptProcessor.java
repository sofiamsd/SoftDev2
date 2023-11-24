package input;

import java.io.File;
import output.*;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class AbstractReceiptProcessor extends AddReceipt {

	/*
	 * private File fileToAppend;
	 * 
	 * public void setFileToAppend(File fileToAppend) { this.fileToAppend =
	 * fileToAppend; }
	 * 
	 * public abstract void appendToFile();
	 * 
	 * protected void writeCommonContent(FileWriter fileWriter) throws IOException {
	 * fileWriter.write("\n"); fileWriter.write("Receipt ID: ");
	 * fileWriter.write(receiptID); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Date: "); fileWriter.write(date); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Kind: "); fileWriter.write(kind); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Sales: "); fileWriter.write(sales); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Items: "); fileWriter.write(items); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Company: "); fileWriter.write(company);
	 * fileWriter.write("\n");
	 * 
	 * 
	 * fileWriter.write("Country: "); fileWriter.write(country);
	 * fileWriter.write("\n");
	 * 
	 * fileWriter.write("City: "); fileWriter.write(city); fileWriter.write("\n");
	 * 
	 * fileWriter.write("Street: "); fileWriter.write(street);
	 * fileWriter.write("\n");
	 * 
	 * fileWriter.write("Number: "); fileWriter.write(number);
	 * fileWriter.write("\n");
	 * 
	 * fileWriter.close(); }
	 * 
	 * protected void createXmlElements(Document doc, Node agent) throws
	 * TransformerConfigurationException { Element receiptElem =
	 * doc.createElement("Receipt"); agent.appendChild(receiptElem);
	 * 
	 * DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); try
	 * { DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); } catch
	 * (ParserConfigurationException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } //Document doc = docBuilder.parse(fileToAppend);
	 * 
	 * //Node agent = doc.getFirstChild();
	 * 
	 * Element receiptIDElem = doc.createElement("ReceiptID");
	 * receiptIDElem.appendChild(doc.createTextNode(receiptID));
	 * receiptElem.appendChild(receiptIDElem);
	 * 
	 * Element dateElem = doc.createElement("Date");
	 * dateElem.appendChild(doc.createTextNode(date));
	 * receiptElem.appendChild(dateElem);
	 * 
	 * Element kindElem = doc.createElement("Kind");
	 * kindElem.appendChild(doc.createTextNode(kind));
	 * receiptElem.appendChild(kindElem);
	 * 
	 * Element salesElem = doc.createElement("Sales");
	 * salesElem.appendChild(doc.createTextNode(sales));
	 * receiptElem.appendChild(salesElem);
	 * 
	 * Element itemsElem = doc.createElement("Items");
	 * itemsElem.appendChild(doc.createTextNode(items));
	 * receiptElem.appendChild(itemsElem);
	 * 
	 * Element companyElem = doc.createElement("Company");
	 * companyElem.appendChild(doc.createTextNode(company));
	 * receiptElem.appendChild(companyElem);
	 * 
	 * Element countryElem = doc.createElement("Country");
	 * countryElem.appendChild(doc.createTextNode(country));
	 * receiptElem.appendChild(countryElem);
	 * 
	 * Element cityElem = doc.createElement("City");
	 * cityElem.appendChild(doc.createTextNode(city));
	 * receiptElem.appendChild(cityElem);
	 * 
	 * Element streetElem = doc.createElement("Street");
	 * streetElem.appendChild(doc.createTextNode(street));
	 * receiptElem.appendChild(streetElem);
	 * 
	 * Element numberElem = doc.createElement("Number");
	 * numberElem.appendChild(doc.createTextNode(number));
	 * receiptElem.appendChild(numberElem);
	 * 
	 * TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 * Transformer transformer = transformerFactory.newTransformer();
	 * transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 * transformer.setOutputProperty(OutputKeys.METHOD, "xml"); DOMSource source =
	 * new DOMSource(doc); StreamResult result = new StreamResult(fileToAppend); try
	 * { transformer.transform(source, result); } catch (TransformerException e) {
	 * 
	 * e.printStackTrace(); } }
	 * 
	 * public File getFileToAppend() { return fileToAppend; }
	 * 
	 * protected void validateFile(File file) throws IllegalArgumentException { if
	 * (file == null || !file.exists() || !file.isFile() ||
	 * !file.getName().toLowerCase().endsWith(".xml")) { throw new
	 * IllegalArgumentException("Invalid XML file: " + file); } }
	 * 
	 * protected void handleException(Exception e) { e.printStackTrace(); // Handle
	 * the exception more appropriately (e.g., logging, throwing a specific
	 * exception) }
	 * 
	 * // Setters for other properties
	 */}
