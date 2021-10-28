import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void arrSort() {
        List<Integer> testList = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        Collections.shuffle(testList);
        List<Integer> actual = Main.arrSort(testList);
        // correct sorting test
        assertEquals(Arrays.asList(5, 4, 3, 2, 1, 0), actual);
        // empty list in argument test
        assertEquals(Collections.emptyList(), Main.arrSort(Collections.emptyList()));
        // null argument test
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.arrSort(null);
        });
        // only negative digits
        assertEquals(Collections.emptyList(), Main.arrSort(Arrays.asList(-5, -4, -3, -2, -1)));
        // only positive digits
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), Main.arrSort(Arrays.asList(1, 2, 3, 4, 5)));
        // null inside list test
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.arrSort(Arrays.asList(null, null, null, null, null));
        });
    }

    @Test
    void topFiveHashtags() {

        // argument example
        ArrayList<String> strings = new ArrayList<>();
        strings.add("#Lorem #Lorem #Lorem ipsum dolor sit #amet, consectetur adipiscing #elit, sed do eiusmod #tempor incididunt ut #labore et dolore magna aliqua.");
        strings.add("#Lorem #Lorem ipsum dolor sit #amet, consectetur adipiscing #elit #elit, sed do eiusmod #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit #amet, consectetur adipiscing elit, sed do eiusmod #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod #tempor #tempor incididunt ut labore et dolore magna aliqua.");
        strings.add("#Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod #tempor #tempor incididunt ut labore et dolore magna aliqua.");

        Map<String, Integer> actual;
        actual = Main.topFiveHashtags(strings);

        // Size checking
        if (actual.size() > 5) fail("Array size more than 5: " + actual.size());
        // Hashtag checking
        for (Map.Entry<String, Integer> entry : actual.entrySet()) {
            if (entry.getKey().toCharArray()[0] != '#') {
                fail("Not hashtag in top\n" + actual);
            }
        }
        // Checking for correct sorting top
        Iterator<Map.Entry<String, Integer>> entryIterator = actual.entrySet().iterator();
        int value = entryIterator.next().getValue();
        while (entryIterator.hasNext()) {
            int nextValue = entryIterator.next().getValue();
            if (nextValue > value) {
                fail("Incorrect sorting\n" + actual);
            }
        }
        // Hashtag count test (expected tags/quantity)
        assertEquals("{#tempor=5, #Lorem=5, #amet=3, #elit=2, #labore=1}", actual.toString());
        // empty list in argument test
        assertEquals(Collections.emptyMap(), Main.topFiveHashtags(Collections.emptyList()));
        // null argument test
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.topFiveHashtags(null);
        });
        // null inside list test
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.topFiveHashtags(Arrays.asList("#null", "null", null, null, null));
        });
        // no hashtags in argument
        assertEquals(Collections.emptyMap(), Main.topFiveHashtags(Arrays.asList("no hashtags in this string")));
    }

    @Test
    void volumeSort() {
        Shape3D cub = new Cube(10);
        Shape3D sph = new Sphere(10);
        Shape3D cyl = new Cylinder(10, 5);
        Shape3D sph2 = new Sphere(12);

        Shape3D[] shapes = new Shape3D[]{cub, sph, cyl, sph2};

        Shape3D[] sortedShapes = Main.volumeSort(shapes);

        // Checking for correct sorting
        for (int i = 0; i < sortedShapes.length - 1; i++) {
            if (sortedShapes[i].getVolume() < sortedShapes[i + 1].getVolume()) {
                fail("Incorrect sorting");
            }
        }
    }
}