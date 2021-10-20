import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {

    public static ArrayList<Integer> arrSort(ArrayList<Integer> arr) {
        ArrayList<Integer> outputArr = new ArrayList<Integer>();
        for (int element : arr) {
            outputArr.add(element);
        }
        // Removing negative elements
        outputArr.removeIf(n -> n < 0);

        Collections.sort(outputArr);
        Collections.reverse(outputArr);
        return outputArr;
    }


    public static void main(String[] args) {

    }
}
