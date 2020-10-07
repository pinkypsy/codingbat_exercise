import java.util.*;
import java.util.stream.Collectors;

public class Trials {
    public static void main(String[] args) throws InterruptedException {
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


        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put(1, "obj1");
        linkedMap.put(33, "obj33");
        linkedMap.put(2, "obj2");

        linkedMap.get(1);

        List<Integer> integerList = new ArrayList<>();
        fillList(integerList);
        System.out.println(integerList);

        List<Integer> integerListNEW;

//        integerListNEW = integerList.stream().map(a -> a * 5).collect(Collectors.toList());

//        integerListNEW = integerList.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        int sum = integerList.stream().reduce(3, (acc, a) -> acc + a);


        System.out.println(sum);

    }

    static void fillList(List<Integer> list) {

        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
}

