package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTInput extends Input {

    public TXTInput(File receiptFileTXT) {
        this.inputFile = receiptFileTXT;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void parseLine(String line) {
        processCommonLines(line);
    }
}
