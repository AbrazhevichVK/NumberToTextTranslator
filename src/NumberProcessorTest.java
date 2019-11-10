import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NumberProcessorTest {

    @Test
    public void testgetNumberAsText() {
        String expeсtedResult = "Двадцать Две Тысячи Двести Двадцать Два";
        String TestNumber = "22222";
        Map<String, String> NumberReferenceTestMap = new HashMap<String, String>();
        NumberReferenceTestMap.put("2", "Дв");//добавление элементов
        NumberReferenceTestMap.put("20", "Двадцать");
        NumberReferenceTestMap.put("200", "Двести");
        NumberReferenceTestMap.put("2triad", "Тысяч");
        NumberProcessor a = new NumberProcessor();
        String result = a.getNumberAsText(TestNumber, NumberReferenceTestMap);

        String actualResult = result;
        Assert.assertEquals(expeсtedResult, actualResult);

    }
    @Test
    public void testGetEndOfLastNumber(){
        String expeсtedEndsOfLastNumber = "Пять Триллионов Два Миллиарда Один Миллион Две Тысячи Пятнадцать";
        String TestNumber = "5002001002015";
        Map<String, String> NumberReferenceTestMap = new HashMap<String, String>();
        NumberReferenceTestMap.put("1", "Од");//добавление элементов
        NumberReferenceTestMap.put("2", "Дв");
        NumberReferenceTestMap.put("5", "Пять");
        NumberReferenceTestMap.put("15", "Пятнадцать");
        NumberReferenceTestMap.put("2triad", "Тысяч");
        NumberReferenceTestMap.put("3triad", "Миллион");
        NumberReferenceTestMap.put("4triad", "Миллиард");
        NumberReferenceTestMap.put("5triad", "Триллион");
        NumberProcessor a = new NumberProcessor();
        String result = a.getNumberAsText(TestNumber, NumberReferenceTestMap);

        String actualEndsOfLastNumber = result;
        Assert.assertEquals(expeсtedEndsOfLastNumber, actualEndsOfLastNumber);

    }

}