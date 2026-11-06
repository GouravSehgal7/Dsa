import java.util.Map;
import java.util.TreeMap;

public class Tm {

    // Fundamentals of TreeMap in Java

    // A TreeMap is a map implementation backed by a Red-Black Tree (a self-balancing Binary Search Tree).

    // Core Characteristics

    // Sorted Order: Unlike HashMap, entries in a TreeMap are always sorted by their keys. By default, this 
    // is natural ordering (ascending, e.g., alphabetical for strings, numerical for numbers).

    // Custom Ordering: You can provide a custom Comparator during initialization to define your own sorting logic.

    // Time Complexity: Basic operations like get(), put(), and remove() run in O(log n) time, which is slower 
    // than HashMap's O(1) average time, but it keeps data sorted automatically.

    // Null Keys: A TreeMap does not allow null keys (as it needs to compare them using .compareTo()), 
    // but it does allow multiple null values.


    public static void main(String[] args) {
        // a-b = Integer.compare(a, b) = ascending
        // b-a = Integer.compare(b,a) = descending 
       TreeMap<Integer, Integer> tm = new TreeMap<>((a,b)->{
        return Integer.compare(b,a);
       });
            
        tm.put(1, 1);                         // O(log n)
        tm.put(4, 2);                         // O(log n)
        tm.put(3, 8);                         // O(log n)
        System.out.println(tm);               // {1=1, 3=8, 4=2}
            
        System.out.println(tm.get(1));        // O(log n) -> 1
            
        tm.put(2, tm.getOrDefault(2, 0)+1);    // O(log n) -> {2=1}
        System.out.println(tm.get(2));        // O(log n) -> 1
            
        tm.put(2, tm.getOrDefault(2, 0)+1);    // O(log n) -> {2=2}
        System.out.println(tm.get(2));        // O(log n) -> 2
            
        System.out.println(tm.size());        // O(1) -> 4
        System.out.println(tm.containsKey(2));// O(log n) -> true
            
        System.out.println(tm.remove(2));     // O(log n) -> 2
        System.out.println(tm.containsKey(2));// O(log n) -> false
            
        System.out.println(tm.firstKey());    // O(log n) -> 1
        System.out.println(tm.lastKey());     // O(log n) -> 4
            
        System.out.println(tm.firstEntry());  // O(log n) -> 1=1
        System.out.println(tm.lastEntry());   // O(log n) -> 4=2
            
        System.out.println(tm.pollFirstEntry());// O(log n) -> 1=1
        System.out.println(tm.pollLastEntry()); // O(log n) -> 4=2
            
        System.out.println(tm);               // {3=8}
            
        // Add more elements for range operations
        tm.put(20, 200);
        tm.put(30, 300);
        tm.put(40, 400);
        tm.put(50, 500);
            
        // Navigation
        System.out.println(tm.floorEntry(30));   // O(log n) -> 30=300
        System.out.println(tm.ceilingEntry(20)); // O(log n) -> 20=200
            
        // Range-based operations for ascending order
        System.out.println(tm.subMap(20, 40));   // tm.subMap(40, 20)
        // O(log n) to create view -> {20=200, 30=300}
            
        System.out.println(tm.headMap(30));      
        // O(log n) to create view -> {3=8, 20=200}
            
        System.out.println(tm.tailMap(30));      
        // O(log n) to create view -> {30=300, 40=400, 50=500}
            
        System.out.println(tm.subMap(20, true, 40, true));
        // O(log n) to create view -> {20=200, 30=300, 40=400}
            
        // Iteration using forEach
        tm.forEach((k, v) -> {                   // O(n)
            System.out.println(k + " : " + v);
        });
        
        // Iteration using entrySet
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }                                        // O(n)




    }


    
}
