package input;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class HTMLInput extends Input {

    private static final String NAME_TAG = "name";
    private static final String AFM_TAG = "afm";
    private static final String RECEIPT_TAG = "receipts";
    private static final String RECEIPTID_TAG = "receipt id";
    private static final String DATE_TAG = "date";
    private static final String KIND_TAG = "kind";
    private static final String SALES_TAG = "sales";
    private static final String ITEM_TAG = "items";
    private static final String COMPANY_TAG = "company";
    private static final String COUNTRY_TAG = "country";
    private static final String CITY_TAG = "city";
    private static final String STREET_TAG = "street";
    private static final String NUMBER_TAG = "number";




    public HTMLInput(File receiptFileHTML) {
        this.inputFile = receiptFileHTML;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        try {
            Document doc = Jsoup.parse(inputFile, "UTF-8");

            processElement(doc, NAME_TAG);
            processElement(doc, AFM_TAG);
            processElement(doc, RECEIPT_TAG);
            processElement(doc, RECEIPTID_TAG);
            processElement(doc, DATE_TAG);
            processElement(doc, KIND_TAG);
            processElement(doc, SALES_TAG);
            processElement(doc, ITEM_TAG);
            processElement(doc, COMPANY_TAG);
            processElement(doc, COUNTRY_TAG);
            processElement(doc, CITY_TAG);
            processElement(doc, STREET_TAG);
            processElement(doc, NUMBER_TAG);
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void processElement(Document doc, String tag) {
//        Elements elements = doc.select(tag);
//        if (!elements.isEmpty()) {
//            String value = elements.first().text();
//            switch (tag) {
//                case NAME_TAG:
//                    name = value;
//                    addSalesman();
//                    break;
//                case AFM_TAG:
//                    afm = value;
//                    addSalesman();
//                    break;
//                case RECEIPT_TAG:
//                   // receipts = Integer.parseInt(value);
//                    //addReceipt();
//                    break;
//                case RECEIPTID_TAG:
//                    receiptID = Integer.parseInt(value);
//                    addReceipt();
//                    break;
//                case DATE_TAG:
//                    date = value;
//                    addReceipt();
//                    break;
//                case KIND_TAG:
//                    clothingType = value;
//                    addReceipt();
//                    break;
//                case SALES_TAG:
//                    sales = Integer.parseInt(value);
//                    addReceipt();
//                    break;
//                case ITEM_TAG:
//                    items = Integer.parseInt(value);
//                    addReceipt();
//                    break;
//                case COMPANY_TAG:
//                    companyName = value;
//                    addReceipt();
//                    break;
//                case COUNTRY_TAG:
//                    companyCountry = value;
//                    addReceipt();
//                    break;
//                case CITY_TAG:
//                    companyCity = value;
//                    addReceipt();
//                    break;
//                case STREET_TAG:
//                    companyStreet = value;
//                    addReceipt();
//                    break;
//                case NUMBER_TAG:
//                    companyStreetNumber = Integer.parseInt(value);
//                    addReceipt();
//                    break;
//            }
//        }
//    }

    private void processElement(Document doc, String tag) {
        Elements elements = doc.select(tag);
        if (!elements.isEmpty()) {
            String value = elements.first().text();
            switch (tag) {
            	case NAME_TAG:
            		name = value.substring(value.indexOf(":") + 1).trim();
            		addSalesman();
            		break;
            	case AFM_TAG:
            		afm = value.substring(value.indexOf(":") + 1).trim();
            		addSalesman();
            		break;
                case RECEIPTID_TAG:
                    receiptID = Integer.parseInt(value.substring(value.indexOf(":") + 1).trim());
                    addReceipt();
                    break;
                case DATE_TAG:
                    date = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case KIND_TAG:
                    clothingType = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case SALES_TAG:
                    sales = Double.parseDouble(value.substring(value.indexOf(":") + 1).trim());
                    addReceipt();
                    break;
                case ITEM_TAG:
                    items = Integer.parseInt(value.substring(value.indexOf(":") + 1).trim());
                    addReceipt();
                    break;
                case COMPANY_TAG:
                    companyName = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case COUNTRY_TAG:
                    companyCountry = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case CITY_TAG:
                    companyCity = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case STREET_TAG:
                    companyStreet = value.substring(value.indexOf(":") + 1).trim();
                    addReceipt();
                    break;
                case NUMBER_TAG:
                    companyStreetNumber = Integer.parseInt(value.substring(value.indexOf(":") + 1).trim());
                    addReceipt();
                    break;
            }
        }
    }
}
