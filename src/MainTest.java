import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void arrSort() {
        ArrayList<Integer> testArr = new ArrayList<Integer>();
        // -5 -4 -3 -2 -1 0 1 2 3 4 5
        for (int i = -5; i <= 5; i++) {
            testArr.add(i);
        }

        ArrayList<Integer> actual = Main.arrSort(testArr);

        ArrayList<Integer> expected = new ArrayList<Integer>();
        // 5 4 3 2 1 0
        for (int i = 5; i >= 0; i--) {
            expected.add(i);
        }
        assertEquals(expected, actual);
    }
}