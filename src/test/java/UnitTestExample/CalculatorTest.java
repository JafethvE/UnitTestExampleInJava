package UnitTestExample;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    private Calculator calculator;

    private static final String filePath = System.getProperty("user.dir") + "\\numbers.txt";

    @Test
    public void defaultConstructorShouldInitialiseWithFileReader() {
        calculator = new Calculator();
        assertNotNull(calculator.getFileReader());
    }

    @Test
    public void overloadedConstructorShouldInitialiseWithCorrectFileReader() {
        FileReader fileReader = new FileReader();
        calculator = new Calculator(fileReader);
        assertEquals(fileReader, calculator.getFileReader());
    }

    @Test
    public void additionWithOnlyPositiveNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(2, calculator.add(filePath));
    }

    @Test
    public void additionWithPositiveAndNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("-1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(0, calculator.add(filePath));
    }

    @Test
    public void additionWithOnlyNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("-1");
        values.add("-1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(-2, calculator.add(filePath));
    }

    @Test
    public void subtractionWithOnlyPositiveNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(0, calculator.subtract(filePath));
    }

    @Test
    public void subtractionWithPositiveAndNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("-1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(2, calculator.subtract(filePath));
    }

    @Test
    public void subtractionWithOnlyNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("-1");
        values.add("-1");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(0, calculator.subtract(filePath));
    }

    @Test
    public void multiplicationWithOnlyPositiveNumbersShouldReturn() throws FileNotFoundException {

        List<String> values = new ArrayList<String>();
        values.add("2");
        values.add("2");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(4, calculator.multiply(filePath));
    }

    @Test
    public void multiplicationWithPositiveAndNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("2");
        values.add("-2");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(-4, calculator.multiply(filePath));
    }

    @Test
    public void multiplicationWithOnlyNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("-2");
        values.add("-2");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(4, calculator.multiply(filePath));
    }

    @Test
    public void averageWithOnlyPositiveNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("2");
        values.add("3");
        values.add("4");
        values.add("5");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(3, calculator.average(filePath));
    }

    @Test
    public void averageWithPositiveAndNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("2");
        values.add("3");
        values.add("4");
        values.add("-5");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(1, calculator.average(filePath));
    }

    @Test
    public void averageWithOnlyNegativeNumbersShouldReturn() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        values.add("-1");
        values.add("-2");
        values.add("-3");
        values.add("-4");
        values.add("-5");
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(-3, calculator.average(filePath));
    }

    @Test
    public void operationWithZeroValuesShouldReturnZero() throws FileNotFoundException {
        List<String> values = new ArrayList<String>();
        FileReader fileReader = mock(FileReader.class);
        when(fileReader.getLinesFromTextFile(filePath)).thenReturn(values);
        calculator = new Calculator(fileReader);
        assertEquals(0, calculator.add(filePath));
        assertEquals(0, calculator.subtract(filePath));
        assertEquals(0, calculator.multiply(filePath));
        assertEquals(0, calculator.average(filePath));
    }
}
