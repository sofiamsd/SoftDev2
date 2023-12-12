package input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HTMLInput extends Input {

    public HTMLInput(File receiptFileHTML) {
        this.inputFile = receiptFileHTML;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        try {
            Path path = Paths.get(inputFilePath);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                line = line.replaceAll("<[^>]*>", "").trim();
                parseLine(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void parseLine(String line) {
        if (line.contains("Name")) {
            name = getValueFromLine(line);
            addSalesman();
        } else if (line.contains("AFM")) {
            afm = getValueFromLine(line);
            addSalesman();
        } else if (line.contains("Receipt ID")) {
            receiptID = Integer.parseInt(getValueFromLine(line));
        } else if (line.contains("Date")) {
            date = getValueFromLine(line);
        } else if (line.contains("Kind")) {
            clothingType = getValueFromLine(line);
        } else if (line.contains("Sales")) {
            sales = Double.parseDouble(getValueFromLine(line));
        } else if (line.contains("Items")) {
            items = Integer.parseInt(getValueFromLine(line));
        } else if (line.contains("Company")) {
            companyName = getValueFromLine(line);
        } else if (line.contains("Country")) {
            companyCountry = getValueFromLine(line);
        } else if (line.contains("City")) {
            companyCity = getValueFromLine(line);
        } else if (line.contains("Street")) {
            companyStreet = getValueFromLine(line);
        } else if (line.contains("Number")) {
            companyStreetNumber = Integer.parseInt(getValueFromLine(line));
            addReceipt();
        }
    }

    private String getValueFromLine(String line) {
        return line.substring(line.indexOf(":") + 1).trim();
    }
}
