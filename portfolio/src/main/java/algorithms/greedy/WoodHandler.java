package algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoodHandler {

    static int[] lengths = {7, 5, 2}; // tilgængelige længder (sorteret fra størst til mindst)
    static Map<Integer, List<Integer>> cache = new HashMap<>();

    public static List<Integer> calculateWood(int target){
        List<Integer> result = new ArrayList<>();
        int remaining = target; // // hvor meget længde vi mangler

        if(cache.containsKey(target)){
            return cache.get(target);
        }

        // vi gennemgår længderne fra størst til mindst (grådig strategi)
        for(int l: lengths){
            int count = remaining / l; // hvor mange gange vi kan bruge denne længde
            if(count > 0){
                // tilføj længden count gange
                for(int i = 0; i < count; i++){
                    result.add(l);
                }
                // reducer hvor meget vi mangler
                remaining -= count * l;
            }
        }
        // hvis vi ikke rammer præcist, tager vi den mindste længde (2)
        if (remaining > 0) {
            result.add(lengths[lengths.length-1]);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("17 meter: " + calculateWood(17));
        System.out.println("13 meter: " + calculateWood(13));
        System.out.println("10 meter: " + calculateWood(10));
    }

}
