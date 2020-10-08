import java.util.*;

public class Map1 {
    public static void main(String[] args) {
        Map<String, String> map = new <String, String>HashMap();
//        java.lang.ClassLoader.
//        map.put("a", "aaa");
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "cake");
//        map.put("c", "cake");
//        map.put("potato", "ketchup");
//        map.put("b", "There");
//        map.put("d", "hi");
//        System.out.println(mapBully(map));
//        System.out.println(mapShare(map));
//        System.out.println(mapAB(map));
//        System.out.println(topping1(map));
//        System.out.println(topping2(map));
//        System.out.println(topping3(map));
//        System.out.println(mapAB2(map));
//        System.out.println(mapAB3(map));
//        System.out.println(mapAB4(map));

        String[] strings = {};
//        System.out.println(pairs(strings));
//        System.out.println(wordCount(strings));
//        System.out.println(firstChar(strings));
//        System.out.println(wordAppend(strings));
        System.out.println(wordMultiple(strings));

    }

    //    Given an array of strings, return a Map<String, Boolean> where each different string is a key
//    and its value is true if that string appears 2 or more times in the array.
//    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//    wordMultiple(["c", "c", "c", "c"]) → {"c": true}
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();


        for (int i = 0; i < strings.length; i++) {
            String matcher = strings[i];
            int count = 0;
            if (matcher == null) {
                continue;
            }
            for (int j = i; j < strings.length; j++) {
                if (matcher.equals(strings[j])) count++;
            }
            map.putIfAbsent(matcher, count >= 2);
        }
        return map;
    }


    //    Loop over the given array of strings to build a result string like this: when a string appears the 2nd,
//    4th, 6th, etc. time in the array, append the string to the result.
//    Return the empty string if no string appears a 2nd time.
//    wordAppend(["a", "b", "a"]) → "a"
//    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
//    wordAppend(["a", "", "a"]) → "a"
//    wordAppend(["a", "b", "b", "b", "a", "c", "a", "a"]) → "baa"
//    wordAppend(["a", "b", "b", "b", "a", "c", "a", "a", "a", "b", "a"]) → "baaba"
//    wordAppend(["not", "and", "or", "and", "this", "and", "or", "that", "not"]) → "andornot"
//    wordAppend(["this", "or", "that", "and", "this", "and", "that"]) → "thisandthat"
//    wordAppend(["xx", "xx", "yy", "xx", "zz", "yy", "zz", "xx"]) → "xxyyzzxx"
    public static String wordAppend(String[] strings) {
        int count = 0;
        String matcher = "";
        StringBuilder sbResult = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            matcher = strings[i];

            if (matcher == null) continue;

            for (int j = i; j < strings.length; j++) {
                if (matcher.equals(strings[j])) count++;
            }
            if (count % 2 == 0) sbResult.append(matcher);
            count = 0;
        }
        return sbResult.toString();
    }


    //    Given an array of non-empty strings, return a Map<String, String> with a key for every different
//    first character seen, with the value of all the strings starting with that character appended together
//    in the order they appear in the array.
//    firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
//    firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
//    firstChar([]) → {}
    public static Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String line : strings) {
            if (map.get(line.substring(0, 1)) != null) {

                String result = map.get(line.substring(0, 1)) + line;
                map.put(line.substring(0, 1), result);
            } else {
                map.put(line.substring(0, 1), line);
            }
        }
        return map;
    }


    //    The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
//    with a key for each different string, with the value the number of times that string appears in the array.
//    wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
//    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
//    wordCount(["c", "c", "c", "c"]) → {"c": 4}
    public static Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String s :
                strings) {
            map.putIfAbsent(s, 0);
            int count = map.get(s);
            map.put(s, ++count);
        }

        return map;
    }


    //    Given an array of non-empty strings, create and return a Map<String, String> as follows:
//        for each string add its first character as a key with its last character as the value.
//    pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//    pairs(["man", "moon", "main"]) → {"m": "n"}
//    pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        Arrays.stream(strings).forEach(s -> map.put("" + s.charAt(0), "" + s.charAt(s.length() - 1)));

        return map;
    }


    //    Given an array of strings, return a Map<String, Integer> containing a key for every different string
//    in the array, and the value is that string's length.
//    wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
//    wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
//    wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
    public static Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s :
                strings) {
            map.put(s, s.length());
        }
        return map;
    }


    //    Given an array of strings, return a Map<String, Integer> containing a key for every different string
//    in the array, always with the value 0. For example the string "hello" makes the pair "hello":0.
//    We'll do more complicated counting later, but for this problem the value is simply 0.
//    word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
//    word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
//    word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
    public static Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            map.put(string, 0);
        }

        return map;
    }


//    Modify and return the given map as follows: if the keys "a" and "b" have values that have different lengths,
//    then set "c" to have the longer value. If the values exist and have the same length,
//    change them both to the empty string in the map.
//    mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
//    mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
//    mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}

    public static Map<String, String> mapAB4(Map<String, String> map) {
        String aVal = map.get("a");
        String bVal = map.get("b");

        if (aVal == null || bVal == null) return map;

        if (aVal.length() == bVal.length()) {
            map.put("a", "");
            map.put("b", "");
            return map;
        } else {
            if (aVal.length() > bVal.length()) {
                map.put("c", aVal);
            }
            if (aVal.length() < bVal.length()) {
                map.put("c", bVal);
            }
        }
        return map;
    }


//    Modify and return the given map as follows: if exactly one of the keys "a" or "b" has a value in the map (but not both),
//    set the other to have that same value in the map.
//    mapAB3({"a": "aaa", "c": "cake"}) → {"a": "aaa", "b": "aaa", "c": "cake"}
//    mapAB3({"b": "bbb", "c": "cake"}) → {"a": "bbb", "b": "bbb", "c": "cake"}
//    mapAB3({"a": "aaa", "b": "bbb", "c": "cake"}) → {"a": "aaa", "b": "bbb", "c": "cake"}

    public static Map<String, String> mapAB3(Map<String, String> map) {
        String aVal = map.get("a");
        String bVal = map.get("b");
        if (aVal != null ^ bVal != null) {
            map.putIfAbsent("a", bVal);
            map.putIfAbsent("b", aVal);
            System.out.println("hi");
        }
        return map;
    }


    //    Modify and return the given map as follows: if the keys "a" and "b" are both in the map and have equal values, remove them both.
//    mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
//    mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
//    mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
    public static Map<String, String> mapAB2(Map<String, String> map) {
        String aVal = map.get("a");
        String bVal = map.get("b");
        if (map.containsKey("a") && map.containsKey("b") && aVal.equals(bVal)) {
            System.out.println("if stmt");
            System.out.println(map.remove("a"));
            System.out.println(map.remove("b"));
        }
        return map;
    }


    //    Given a map of food keys and topping values, modify and return the map as follows: if the key "potato" has a value, set that as the value for the key "fries".
//    If the key "salad" has a value, set that as the value for the key "spinach".
//    topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
//    topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
//    topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup", "fries": "ketchup"}
    public static Map<String, String> topping3(Map<String, String> map) {
        if (map.get("potato") != null) {
            map.put("fries", map.get("potato"));
        }
        if (map.get("salad") != null) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }


    //    Given a map of food keys and their topping values, modify and return the map as follows: if the key "ice cream" has a value,
//    set that as the value for the key "yogurt" also. If the key "spinach" has a value, change that value to "nuts".
//    topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
//    topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
//    topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
    public static Map<String, String> topping2(Map<String, String> map) {

        String iceCreamVal = map.get("ice cream");

        if (map.get("ice cream") != null) map.put("yogurt", iceCreamVal);
        if (map.get("spinach") != null) map.put("spinach", "nuts");

        return map;
    }


    //    Given a map of food keys and topping values, modify and return the map as follows: if the key "ice cream" is present, set its value to "cherry".
//    In all cases, set the key "bread" to have the value "butter".
//    topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
//    topping1({}) → {"bread": "butter"}
//    topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
    public static Map<String, String> topping1(Map<String, String> map) {

        map.put("bread", "butter");

        if (map.containsKey("ice cream")) map.put("ice cream", "cherry");


        return map;
    }


//    Modify and return the given map as follows: for this problem the map may or may not contain the "a" and "b" keys.
//    If both keys are present, append their 2 string values together and store the result under the key "ab".
//    mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
//    mapAB({"a": "Hi"}) → {"a": "Hi"}
//    mapAB({"b": "There"}) → {"b": "There"}

    public static Map<String, String> mapAB(Map<String, String> map) {
        if (map.get("a") != null && map.get("b") != null) {
            String abVal = map.get("a") + map.get("b");
            map.put("ab", abVal);
        }
        return map;
    }

    //    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value.
//    In all cases remove the key "c", leaving the rest of the map unchanged.
//    mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
//    mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
//    mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
    public static Map<String, String> mapShare(Map<String, String> map) {
        String aVal = map.get("a");
        if (aVal != null) {
            map.put("b", aVal);
        }
        map.remove("c");
        return map;
    }


    //    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that value,
//    and set the key "a" to have the value "". Basically "b" is a bully, taking the value and
//    replacing it with the empty string.
//    mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
//    mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
//    mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}
    public static Map<String, String> mapBully(Map<String, String> map) {
        String aVal = map.get("a");
        if (aVal != null) {
            map.put("b", aVal);
            map.put("a", "");
        }
        return map;
    }


}
