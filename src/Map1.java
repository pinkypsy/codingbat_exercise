import java.util.HashMap;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        Map <String, String> map = new <String, String> HashMap();

        map.put("a", "aaa");
        map.put("c", "meh");
        map.put("d", "hi");
//        System.out.println(mapBully(map));
        System.out.println(mapShare(map));
    }

//    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value.
//    In all cases remove the key "c", leaving the rest of the map unchanged.
//    mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
//    mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
//    mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
public static Map<String, String> mapShare(Map<String, String> map) {
    String aVal = map.get("a");
    if (aVal != null){
        map.put("b",aVal);
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
        if (aVal != null){
            map.put("b",aVal);
            map.put("a","");
        }
        return map;
}


}
