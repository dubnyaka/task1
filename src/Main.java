import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static ArrayList<Integer> arrSort(ArrayList<Integer> arr) {
        ArrayList<Integer> outputArr = new ArrayList<>(arr);
        // Removing negative elements
        outputArr.removeIf(n -> n < 0);

        Collections.sort(outputArr);
        Collections.reverse(outputArr);
        return outputArr;
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

    public static void main(String[] args) {

    }
}
