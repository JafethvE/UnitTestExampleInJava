package UnitTestExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> getLinesFromTextFile(String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }

    public static void createEmptyFile(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }
}
