package UnitTestExample;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final FileReader fileReader;

    public Calculator() {
        fileReader = new FileReader();
    }

    public Calculator(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    private List<Double> getValuesFromFile(String filePath) {
        List<Double> values = new ArrayList<Double>();
        List<String> fileInputs = new ArrayList<String>();
        try {
            fileInputs = fileReader.getLinesFromTextFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find numbers.txt file.");
            System.out.println(e.getMessage());
            return null;
        }

        if (fileInputs.size() == 0) {
            System.out.println("Please fill in the numbers.txt file found with this programme.");
            return null;
        }


        for (String fileInput : fileInputs) {
            try {
                values.add(Double.parseDouble(fileInput));
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong while parsing the value " + fileInput);
                System.out.println(e.getMessage());
                return null;
            }
        }

        return values;
    }

    public double add(String filePath) {
        List<Double> values = getValuesFromFile(filePath);
        if (values == null) {
            return 0;
        }
        double result = 0.0;
        for (double value : values) {
            result += value;
        }
        return result;
    }

    public double multiply(String filePath) {
        List<Double> values = getValuesFromFile(filePath);
        if (values == null) {
            return 0;
        }
        double result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result *= values.get(i);
        }
        return result;
    }

    public double subtract(String filePath) {
        List<Double> values = getValuesFromFile(filePath);
        if (values == null) {
            return 0;
        }
        double result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result -= values.get(i);
        }
        return result;
    }

    public double average(String filePath) {
        List<Double> values = getValuesFromFile(filePath);
        if (values == null) {
            return 0;
        }
        double sum = add(filePath);
        return sum / values.size();
    }
}
