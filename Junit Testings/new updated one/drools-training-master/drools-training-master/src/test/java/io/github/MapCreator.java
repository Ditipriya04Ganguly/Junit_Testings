package io.github;

import java.util.*;

public class MapCreator {
   List<Pair> pairs;
   Map<Integer, Set<String>> map= new HashMap<>();

    public MapCreator(List<Pair> pairs) {

        this.pairs = pairs;

        for (Pair pair: pairs){
            if (map.get(pair.pid)==null){
                map.put(pair.pid, pair.disease);
            }
            else{
                Set<String> existingdisease= new HashSet<>();
                existingdisease.addAll(map.get(pair.pid));
                map.put(pair.pid,existingdisease);
            }




        }

    }
}
