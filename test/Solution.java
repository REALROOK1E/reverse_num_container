package test;

/**
 * @author: ZeKai
 * @date: 2025/2/9
 * @description:
 **/

import java.util.HashMap;
import java.util.TreeSet;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        long totalBadPairs = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            int count = countMap.getOrDefault(key, 0);
            totalBadPairs += i - count; // 当前索引之前的“坏对”数量
            countMap.put(key, count + 1); // 更新哈希表
        }

        return totalBadPairs;
    }

    public static void main(String[] args) {
        int [] nums =new int[] {4,1,3,3};
        System.out.println(countBadPairs(nums));
    }
}