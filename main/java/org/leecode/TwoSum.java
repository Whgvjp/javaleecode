package org.leecode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> hashMap = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (hashMap.containsKey(tmp)) {
                return new int[]{hashMap.get(tmp), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("ints:" + Arrays.toString(ints));
    }
}
