package input;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTMLInput extends Input {

    private static final String NAME_TAG = "Name";
    private static final String AFM_TAG = "AFM";
    private static final String RECEIPT_TAG = "Receipts";
    private static final String RECEIPTID_TAG = "Receipt ID";
    private static final String DATE_TAG = "Date";
    private static final String KIND_TAG = "Kind";
    private static final String SALES_TAG = "Sales";
    private static final String ITEMS_TAG = "Items";
    private static final String COMPANY_TAG = "Company";
    private static final String COUNTRY_TAG = "Country";
    private static final String CITY_TAG = "City";
    private static final String STREET_TAG = "Street";
    private static final String NUMBER_TAG = "Number";

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
            processElement(doc, ITEMS_TAG);
            processElement(doc, COMPANY_TAG);
            processElement(doc, COUNTRY_TAG);
            processElement(doc, CITY_TAG);
            processElement(doc, STREET_TAG);
            processElement(doc, NUMBER_TAG);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processElement(Document doc, String tag) {
        Elements elements = doc.select(tag);
        if (!elements.isEmpty()) {
            String value = elements.first().text();
            switch (tag) {
                case NAME_TAG:
                    name = value;
                    addSalesman();
                    break;
                case AFM_TAG:
                    afm = value;
                    addSalesman();
                    break;
                case RECEIPT_TAG:
                    // Don't addReceipt() here; add it after processing all receipt-related tags.
                    break;
                case RECEIPTID_TAG:
                    receiptID = Integer.parseInt(value);
                    addReceipt();
                    break;
                case DATE_TAG:
                    date = value;
                    break;
                case KIND_TAG:
                    clothingType = value;
                    break;
                case SALES_TAG:
                    sales = Double.parseDouble(value);
                    break;
                case ITEMS_TAG:
                    items = Integer.parseInt(value);
                    break;
                case COMPANY_TAG:
                    companyName = value;
                    break;
                case COUNTRY_TAG:
                    companyCountry = value;
                    break;
                case CITY_TAG:
                    companyCity = value;
                    break;
                case STREET_TAG:
                    companyStreet = value;
                    break;
                case NUMBER_TAG:
                    companyStreetNumber = Integer.parseInt(value);
                     // AddReceipt() called only once after processing all receipt-related tags.
                    break;
            }
        }
    }

}
