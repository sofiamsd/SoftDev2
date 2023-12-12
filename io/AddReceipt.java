package io;

import java.io.File;

import data.Address;
import data.Company;
import data.Kind;
import data.Receipt;

public abstract class AddReceipt {

    protected File fileToAppend;
    protected Receipt receiptData;
    protected Address addressData;
    protected Kind kindData;
    protected Company companyData;

    public abstract void setFileToAppend(File fileToAppend);
    
    public void appendFile() {
        try {
            performCommonOperations();
            appendFileSpecific();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void appendFileSpecific() throws Exception;

    private void performCommonOperations() throws Exception {

    }

    public AddReceipt() {
        this.receiptData = new Receipt();
        this.addressData = new Address();
        this.kindData = new Kind();
        this.companyData = new Company();
    }


    public Kind getKindData() {
        return kindData;
    }
    
    public Company getCompanyData() {
        return companyData;
    }

    public Receipt getReceiptData() {
        return receiptData;
    }

    public Address getAddressData() {
        return addressData;
    }
}
