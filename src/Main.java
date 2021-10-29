import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static List<Integer> arrSort(List<Integer> integerList) throws IllegalArgumentException {
        if (integerList == null) throw new IllegalArgumentException("Argument can`t be null");
        else if (integerList.isEmpty()) return Collections.emptyList();
        else if (integerList.contains(null)) throw new IllegalArgumentException("Argument can`t contain null");

        return integerList.stream().filter(x -> x >= 0).sorted(Collections.reverseOrder()).toList();
    }

    public static Map<String, Integer> topFiveHashtags(List<String> strings) throws IllegalArgumentException {
        if (strings == null) throw new IllegalArgumentException("Argument can`t be null");
        else if (strings.isEmpty()) return new HashMap<>();
        else if (strings.contains(null)) throw new IllegalArgumentException("Argument can`t contain null");

        HashMap<String, Integer> hashtagsCounter = new HashMap<>();

        String pattern = "(#\\w*)";
        Pattern r = Pattern.compile(pattern);

        for (String string : strings) {
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

        Map<String, Integer> topHashtags = new LinkedHashMap<>();

        // taking top 5 (or less) max count hashtags
        int hashtagsCounterSize = hashtagsCounter.size();
        for (int i = 0; i < hashtagsCounterSize && topHashtags.size() < 5; i++) {
            Optional<Map.Entry<String, Integer>> optionalMaxEntry = hashtagsCounter.entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue));

            if (optionalMaxEntry.isPresent()) {
                topHashtags.put(optionalMaxEntry.get().getKey(), optionalMaxEntry.get().getValue());
                hashtagsCounter.remove(optionalMaxEntry.get().getKey());
            }
        }
        return topHashtags;
    }

    public static List<Shape3D> volumeSort(List<Shape3D> shape3DList) throws IllegalArgumentException {
        if (shape3DList == null) throw new IllegalArgumentException("Argument can`t be null");
        else if (shape3DList.isEmpty()) return Collections.emptyList();
        else if (shape3DList.contains(null)) throw new IllegalArgumentException("Argument can`t contain null");

        return shape3DList.stream().sorted(Comparator.comparing(Shape3D::getVolume).reversed()).toList();
    }

}

abstract class Shape3D {
    abstract double getVolume();
}

class Cube extends Shape3D {

    private final double width;

    public Cube(double width) {
        if (width >= 0) this.width = width;
        else this.width = 0;
    }

    @Override
    double getVolume() {
        return Math.pow(width, 3);
    }
}

class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double radius) {
        if (radius >= 0) this.radius = radius;
        else this.radius = 0;
    }

    @Override
    double getVolume() {
        return ((4 * Math.PI * Math.pow(radius, 3)) / 3);
    }
}

class Cylinder extends Shape3D {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        if (radius >= 0) this.radius = radius;
        else this.radius = 0;
        if (height >= 0) this.height = radius;
        else this.height = 0;
    }

    @Override
    double getVolume() {
        return (Math.PI * Math.pow(radius, 2) * height);
    }
}
