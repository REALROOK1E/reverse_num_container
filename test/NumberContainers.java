package test;

import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {
    // 存储索引到数字的映射
    private HashMap<Integer, Integer> numbers = new HashMap<>();
    // 存储每个数字对应的索引有序集合
    private HashMap<Integer, TreeSet<Integer>> resmap = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        // 如果索引已经存在，从旧数字的有序集合中移除该索引
        if (numbers.containsKey(index)) {
            int oldNumber = numbers.get(index);
            // 检查旧数字的有序集合是否存在
            if (resmap.containsKey(oldNumber)) {
                resmap.get(oldNumber).remove(index);
                // 如果旧数字的有序集合为空，则从resmap中移除
                if (resmap.get(oldNumber).isEmpty()) {
                    resmap.remove(oldNumber);
                }
            }
        }

        // 如果新旧数字相同，无需操作
        if (numbers.containsKey(index) && numbers.get(index) == number) {
            return;
        }

        // 更新索引到数字的映射
        numbers.put(index, number);

        // 确保数字对应的有序集合存在
        resmap.putIfAbsent(number, new TreeSet<>());
        // 将索引加入到数字对应的有序集合中
        resmap.get(number).add(index);

        // 打印调试信息
        System.out.println("RESMAP=" + resmap);
        System.out.println("NUMBERS=" + numbers);
    }



    public int find(int number) {
        // 获取数字对应的有序集合
        TreeSet<Integer> ts = resmap.get(number);
        // 如果集合不存在或为空，返回-1
        if (ts == null || ts.isEmpty()) {
            return -1;
        } else {
            // 返回集合的最小索引
            return ts.first();
        }
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        System.out.println(nc.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        System.out.println(nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
    }
}