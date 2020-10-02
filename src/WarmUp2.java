import java.util.*;

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
//        System.out.println(stringMatch("aaxxaaxx", "iaxxai"));

        //array123
        int[] ar4 = {
                1, 1, 2, 1, 2, 3
        };
//        System.out.println(array123(ar4));
//        System.out.println(altPairs("ThisThatTheOtherBRi"));

        System.out.println(stringYak("yak123ya"));

    }


//    Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed,
//    but the "a" can be any char. The "yak" strings will not overlap.
//    stringYak("yakpak") → "pak"
//    stringYak("pakyak") → "pak"
//    stringYak("yak123ya") → "123ya"

    public static String stringYak(String str) {
        String yak = "yak";
        return str.replace(yak, "");
        /*
        or with gap letter between Y & K
         String result = "";
            for (int i=0; i<str.length(); i++) {
            // Look for i starting a "yak" -- advance i in that case
            if (i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+2)=='k') {
                i =  i + 2;
            } else { // Otherwise do the normal append
                result = result + str.charAt(i);
            }
        }
        return result;
        */
    }


//    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//    altPairs("kitten") → "kien"
//    altPairs("Chocolate") → "Chole"
//    altPairs("CodingHorror") → "Congrr"
//    altPairs("ThisThatTheOther") → "ThThThth"

    public static String altPairs(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
//we need values like a 0, 1, _, _, 4, 5, _, _, 8, 9, _, _, 12, 13, _, _, etc
        for (int i = 0; i < str.length(); i++) {
            if (count == 2) { //when we get next '_' value
                count = 0;//reset counter
                i++;//leap over next two iterations (step 1)
                continue;//leap over next two iterations (step 2)
            }
            count++;
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
        /*
        ******or with hardcoded values:******
          List <Integer> arr = new ArrayList<>(Arrays.asList(0,1, 4,5, 8,9, 12, 13));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (arr.contains(i)) stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
        */
    }


//    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
//    array123([1, 1, 2, 3, 1]) → true
//    array123([1, 1, 2, 4, 1]) → false
//    array123([1, 1, 2, 1, 2, 3]) → true

    public static boolean array123(int[] nums) {

        if (nums.length < 3) return false;

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (first == 1 && second == 2 && third == 3) return true;
        }
        return false;
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
