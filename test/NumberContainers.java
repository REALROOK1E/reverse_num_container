package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class NumberContainers {
HashMap<Integer, Integer> numbers = new HashMap<>();

HashMap<Integer,HashSet <Integer>> resmap= new HashMap<>();
PriorityQueue<Integer> pq = new PriorityQueue<>();
//堆堆堆
    public NumberContainers() {

    }

    public void change(int index, int number) {


       if(!resmap.containsKey(number)&&resmap.getOrDefault(numbers.getOrDefault(index,0),new HashSet<>()).contains(index)) {
           resmap.getOrDefault(numbers.getOrDefault(index,0),new HashSet<>()).remove(index);

       }

        numbers.put(index, number);


          resmap.putIfAbsent(number, new HashSet<>());
          resmap.get(number).add(index);

       System.out.println("RESMAP="+resmap);
       System.out.println("NUMBERS="+numbers);

    }

    public int find(int number) {
        if(!numbers.containsValue(number)) return -1;
        int min=99999;
        for(int i :numbers.keySet()){
            if(numbers.get(i) == number){

                min=Math.min(i,min);}
        }
        System.out.println(min);
      return min;

    }

    public static void main(String[] args) {
        NumberContainers c = new NumberContainers();
        NumberContainers nc = new NumberContainers();
        nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
