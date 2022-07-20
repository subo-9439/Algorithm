package al_22_06;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream공부 {
    public static void main(String[] args) {
        //배열 -> ArrayList
        int[] rocks = new int[5];
        ArrayList<Integer> list =
                Arrays.stream(rocks).boxed().collect(Collectors.toCollection(ArrayList::new));

    }
}
