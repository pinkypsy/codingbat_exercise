import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trials {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
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


        }

    }
}
