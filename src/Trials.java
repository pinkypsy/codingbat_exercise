import java.util.*;

public class Trials {
    public static void main(String[] args) {
      /*  HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "1");
        hm.put(2, "2");
        hm.put(3, "3");
        System.out.println(Thread.currentThread().getName());
        Set<Integer> s = hm.keySet();
        for (Integer nextInt: s){
            if (nextInt == 3){
                System.out.println(Thread.currentThread().getName());
                hm.put(4, "4");
            }
        }

        for (Map.Entry<Integer, String> entry :
                hm.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());


        }*/
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(5);
        list.add(2, 5);
        list.add(3, 5);

        System.out.println(list);

        LinkedHashMap <Integer, String> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put(1, "obj1");
        linkedMap.put(33, "obj33");
        linkedMap.put(2, "obj2");

        linkedMap.get(1);

        System.out.println(linkedMap);

    }
}
