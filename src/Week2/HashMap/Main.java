package Week2.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Double> hashMap=new HashMap<>();
        hashMap.put("emre",1.1);
        hashMap.put("elif",1.0);

        Iterator iterator=hashMap.entrySet().iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Set<Map.Entry<String,Double>> set=hashMap.entrySet();
        for (Map.Entry<String,Double> a:set){
            System.out.print(a.getKey());
            System.out.println(a.getValue());
        }

        double balance=hashMap.get("emre");
        hashMap.put("emre",balance+1000);

        System.out.println(hashMap.get("emre"));
    }
}
