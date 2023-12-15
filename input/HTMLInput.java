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
    protected void parseLine(String line) {
        processCommonLines(line);
    }


}
