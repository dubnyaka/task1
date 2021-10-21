import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void arrSort() {
        ArrayList<Integer> testArr = new ArrayList<>();
        // -5 -4 -3 -2 -1 0 1 2 3 4 5
        for (int i = -5; i <= 5; i++) {
            testArr.add(i);
        }

        ArrayList<Integer> actual = Main.arrSort(testArr);

        ArrayList<Integer> expected = new ArrayList<>();
        // 5 4 3 2 1 0
        for (int i = 5; i >= 0; i--) {
            expected.add(i);
        }
        assertEquals(expected, actual);
    }

    @Test
    void topFiveHashtags() {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("#Lorem #Lorem #Lorem ipsum dolor sit #amet, consectetur adipiscing #elit, sed do eiusmod #tempor incididunt ut #labore et dolore magna aliqua.");
        strings.add("#Lorem #Lorem ipsum dolor sit #amet, consectetur adipiscing #elit #elit, sed do eiusmod #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit #amet, consectetur adipiscing elit, sed do eiusmod #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod #tempor #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod #tempor #tempor incididunt ut labore et dolore magna aliqua.");

        List<Map.Entry<String, Integer>> actual;
        actual = Main.topFiveHashtags(strings);

        // Size checking
        if (actual.size() > 5) fail("Array size more than 5: " + actual.size());

        // Hashtag checking
        for (Map.Entry<String, Integer> entry : actual) {
            if (entry.getKey().toCharArray()[0] != '#') {
                fail("Not hashtag in top\n" + actual);
            }
        }

        // Checking for correct sorting
        Iterator<Map.Entry<String, Integer>> entryIterator = actual.iterator();
        int value = entryIterator.next().getValue();
        while (entryIterator.hasNext()) {
            int nextValue = entryIterator.next().getValue();
            if (nextValue > value) {
                fail("Incorrect sorting\n" + actual);
            }
        }

    }
}