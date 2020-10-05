import java.util.HashMap;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        Map<String, String> map = new <String, String>HashMap();

//        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "cake");
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
        System.out.println(mapAB3(map));


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
