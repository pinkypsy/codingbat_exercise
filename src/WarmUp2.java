import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WarmUp2 {

    public static void main(String[] args) {
        //stringX
//        System.out.println(stringX("sven"));
//        System.out.println("===");
        //array667
        int[] ar1 = {4};
//        System.out.println(array667(ar1));
//        System.out.println("===");
        //noTriples
        int[] ar2 = {
                1, 1, 2, 2, 1
        };
//        System.out.println(noTriples(ar2));
//        System.out.println("===");
        //has271
        int[] ar3 = {
                2, 7, -2, 4, 10, 2
        };
//        System.out.println(has271(ar3));
//        System.out.println(doubleX("xaxx"));
//        System.out.println(last2("hixxhi"));
        System.out.println(stringMatch("aaxxaaxx", "iaxxai"));


    }


    //    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
//    So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place
//    in both strings.
//    stringMatch("xxcaazz", "xxbaaz") → 3
//    stringMatch("abc", "abc") → 2
//    stringMatch("abc", "axc") → 0
//    stringMatch("aabbccdd", "abbbxxd") → 1
//    stringMatch("aaxxaaxx", "iaxxai") → 3
    public static int stringMatch(String a, String b) {


        int count = 0;

        int lengthMin = Math.min(a.length(), b.length());

        for (int i = 0; i < lengthMin - 1; i++) {
            String aSub = a.substring(i, i + 2);
            String bSub = b.substring(i, i + 2);
            if (aSub.equals(bSub)) count++;
        }

        return count;
    }


//    Given a string, return the count of the number of times that a substring length 2 appears in the string and
//    also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
//    last2("hixxhi") → 1
//    last2("xaxxaxaxx") → 1
//    last2("axxxaaxx") → 2

    public static int last2(String str) {

        if (str.length() < 2) return 0;

        String subStr = str.substring(str.length() - 2);
        int counter = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            System.out.println(str.substring(i, i + 2));
            if (str.substring(i, i + 2).equals(subStr)) counter++;
        }
        return counter;
    }


//    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
//    stringBits("Hello") → "Hlo"
//    stringBits("Hi") → "H"
//    stringBits("Heeololeo") → "Hello"

    public static String stringBits(String str) {
//objective is unclear
        return "";
    }


//    Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
//    doubleX("axxbb") → true
//    doubleX("axaxax") → false
//    doubleX("xxxxx") → true

    static boolean doubleX(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x') return true;
            else if (str.charAt(i) == 'x' && str.charAt(i + 1) != 'x') return false;
        }
        return false;
    }


//    Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5,
//    followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or
//    less from the correct value.
//has271([1, 2, 7, 1]) → true
//has271([1, 2, 8, 1]) → false
//has271([2, 7, 1]) → true

    public static boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (nums[i + 1] == (first + 5) &&
                    (Math.abs(nums[i + 2] - (first - 1)) <= 2)) return true;
        }
        return false;
    }


//    Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
//    Return true if the array does not contain any triples.
//    noTriples([1, 1, 2, 2, 1]) → true
//    noTriples([1, 1, 2, 2, 2, 1]) → false
//    noTriples([1, 1, 1, 2, 2, 2, 1]) → false

    public static boolean noTriples(int[] nums) {

        int counter = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                counter++;
                if (counter == 3) return false;
            } else {
                counter = 1;
            }
        }
        return true;
    }


    //    Given an array of ints, return the number of times that two 6's are next to each other in the array.
    //    Also count instances where the second "6" is actually a 7.
    //    array667([6, 6, 2]) → 1
    //    array667([6, 6, 2, 6]) → 1
    //    array667([6, 7, 2, 6]) → 1
    public static int array667(int[] nums) {

        int counter = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == 6 && nums[i + 1] == 6 || nums[i + 1] == 7) counter++;
        }
        return counter;
    }

    //    Given a string, return a version where all the "x" have been removed.
    //    Except an "x" at the very start or end should not be removed.
    public static String stringX(String str) {

        //    String result = str.substring(1, str.length()-1);

        StringBuilder sb_result = new StringBuilder();

        if (str.length() == 0 || str.length() == 1) return str;

        sb_result.append(str.charAt(0));

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x') continue;
            sb_result.append(str.charAt(i));
        }
        sb_result.append(str.charAt(str.length() - 1));
        return sb_result.toString();
    }
}
