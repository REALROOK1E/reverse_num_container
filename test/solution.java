package test;

import java.util.HashMap;
import java.util.Map;

class solution {
    public static long countBadPairs(int[] nums) {
        long totalBadPairs = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;//是k满足好pair的所需要的数值
            int count = countMap.getOrDefault(key, 0);
            totalBadPairs += i - count; // 应该出现i次，但是实际出现了0次，所以+=i-count
            countMap.put(key, count + 1); // 更新哈希表
            System.out.println(countMap);
        }

        return totalBadPairs;
        //我差一点其实参透这题了，其实就是  一对good pair两个数和自己的角标差值应该是一样的，那就把所有的差值算出来，
        //在一个数的前面只要有差值不一样的全是坏对，也就是i-count
        //一个数的序号是10，但是他这个差值只出现两次，那就是有8个坏对！
    }

    public static void main(String[] args) {
        int [] nums =new int[] {4,1,3,3};
        4133 0123 4010
        System.out.println(countBadPairs(nums));
    }
}