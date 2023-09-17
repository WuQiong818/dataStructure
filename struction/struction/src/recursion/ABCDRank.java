package recursion;

import java.util.ArrayList;
import java.util.List;

public class ABCDRank {
    public static List<String> generatePermutations(char[] chars) {
        List<String> permutations = new ArrayList<>();
        generatePermutations(chars, 0, permutations);
        return permutations;
    }

    private static void generatePermutations(char[] chars, int currentIndex, List<String> permutations) {
        if (currentIndex == chars.length - 1) {//不符合条件，就在这里一直回调
            permutations.add(new String(chars));
            return;
        }

        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);//进行顺序的交换
            generatePermutations(chars, currentIndex + 1, permutations);//在这里进行回调
            swap(chars, currentIndex, i);  // 恢复原始顺序
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C'};
        List<String> permutations = generatePermutations(chars);

        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

