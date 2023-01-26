import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ListTests implements StringChecker {

    public boolean checkString(String s) {
        return s.contains("b");
    }

    @Test
    public void testFilter() {
        ArrayList<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");
        input.add("d");
        input.add("e");
        input.add("bc");

        List<String> expectedResult = new ArrayList<>();
        StringChecker sc = new ListTests();
        expectedResult.add("b");
        expectedResult.add("bc");
        assertEquals(expectedResult, ListExamples.filter(input, sc));
    }

    @Test
    public void testMerge() {
        ArrayList<String> input1 = new ArrayList<>();
        ArrayList<String> input2 = new ArrayList<>();
        input1.add("a");
        input2.add("a");
        input1.add("b");
        input1.add("z");
        input2.add("c");
        input2.add("k");

        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("a");
        expectedResult.add("a");
        expectedResult.add("b");
        expectedResult.add("c");
        expectedResult.add("k");
        expectedResult.add("z");
        assertEquals(expectedResult, ListExamples.merge(input1, input2));
    }
}
