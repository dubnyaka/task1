import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static List<Integer> arrSort(List<Integer> integerList) throws IllegalArgumentException  {
        if (integerList == null) throw new IllegalArgumentException("Argument can`t be null");
        else if (integerList.isEmpty()) return Collections.emptyList();
        else if (integerList.contains(null)) throw new IllegalArgumentException("Argument can`t contain null");

        return integerList.stream().filter(x -> x >= 0).sorted(Collections.reverseOrder()).toList();
    }

    public static List<Map.Entry<String, Integer>> topFiveHashtags(ArrayList<String> strings) {
        HashMap<String, Integer> hashtagsCounter = new HashMap<>();

        for (String string : strings) {
            String pattern = "(#\\w*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(string);

            HashSet<String> stringHashtags = new HashSet<>();
            // Finding hashtags using regular expressions in string and add it to HashSet
            while (m.find()) {
                stringHashtags.add(m.group());
            }
            // Putting hashtag in HashMap and increment it count
            for (String hashtag : stringHashtags) {
                if (hashtagsCounter.containsKey(hashtag)) {
                    hashtagsCounter.put(hashtag, hashtagsCounter.get(hashtag) + 1);
                } else {
                    hashtagsCounter.put(hashtag, 1);
                }
            }
        }

        // Sorting by repeatability
        List<Map.Entry<String, Integer>> sortedHashtagTop = hashtagsCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();

        List<Map.Entry<String, Integer>> topFiveHashtags = new LinkedList<>();

        // The return is no more than the top 5
        for (int i = 0; i < sortedHashtagTop.size() && i < 5; i++) {
            topFiveHashtags.add(sortedHashtagTop.get(i));
        }
        return topFiveHashtags;
    }

    public static Shape3D[] volumeSort(Shape3D[] shapes3D) {
        Shape3D[] sortedArr = shapes3D.clone();
        Arrays.sort(sortedArr, Comparator.comparing(Shape3D::getVolume).reversed());
        return sortedArr;
    }

}

abstract class Shape3D {
    private double volume;

    abstract void calcVolume();

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

class Cube extends Shape3D {

    private final double width;

    public Cube(double width) {
        this.width = width;
        calcVolume();
    }

    @Override
    void calcVolume() {
        setVolume(Math.pow(width, 3));
    }
}

class Sphere extends Shape3D {

    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
        calcVolume();
    }

    @Override
    void calcVolume() {
        setVolume((4 * Math.PI * Math.pow(radius, 3)) / 3);
    }
}

class Cylinder extends Shape3D {

    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
        calcVolume();
    }

    @Override
    void calcVolume() {
        setVolume(Math.PI * Math.pow(radius, 2) * height);
    }
}
