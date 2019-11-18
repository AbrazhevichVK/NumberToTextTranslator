package test;

import main.NumberProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used for unit tests
 */
public class NumberProcessorTest {
    /**
     * This test is used for testing general algorithm for translating number from digital to test format
     */
    @Test
    public void testGetNumberAsText() {
        String expectedResult = "Двадцать Две Тысячи Двести Двадцать Два";
        String testNumber = "22222";

        Map<String, String> numberReferenceTestMap = new HashMap<String, String>();

        numberReferenceTestMap.put("2", "Дв");//добавление элементов
        numberReferenceTestMap.put("20", "Двадцать");
        numberReferenceTestMap.put("200", "Двести");
        numberReferenceTestMap.put("2triad", "Тысяч");

        NumberProcessor a = new NumberProcessor();
        String resultOfTranslating = a.getTranslatedNumberAsText(testNumber, numberReferenceTestMap);

        String actualResult = resultOfTranslating;
        Assert.assertEquals(expectedResult, actualResult);

    }

    /**
     * This test is used for checking the correct work of code, if there are various combinations of nulls and other number in the entered number
     */
    @Test
    public void testGetEndOfLastNumber() {
        String expecteEndsOfLastNumber = "Пять Триллионов Два Миллиарда Один Миллион Две Тысячи Пятнадцать";
        String testNumber = "5002001002015";

        Map<String, String> numberReferenceTestMap = new HashMap<String, String>();

        numberReferenceTestMap.put("1", "Од");//добавление элементов
        numberReferenceTestMap.put("2", "Дв");
        numberReferenceTestMap.put("5", "Пять");
        numberReferenceTestMap.put("15", "Пятнадцать");
        numberReferenceTestMap.put("2triad", "Тысяч");
        numberReferenceTestMap.put("3triad", "Миллион");
        numberReferenceTestMap.put("4triad", "Миллиард");
        numberReferenceTestMap.put("5triad", "Триллион");

        NumberProcessor a = new NumberProcessor();
        String resultOfTranslating = a.getTranslatedNumberAsText(testNumber, numberReferenceTestMap);

        String actualEndsOfLastNumber = resultOfTranslating;
        Assert.assertEquals(expecteEndsOfLastNumber, actualEndsOfLastNumber);

    }

}