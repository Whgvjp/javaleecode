package org.leecode;

/**
 * LeetCode 第一题：两数之和
 * 题目：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class EnvTest {
    
    /**
     * 两数之和解法 - 暴力解法
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // 如果没有找到解，返回[-1, -1]
    }
    
    /**
     * 两数之和解法 - 哈希表优化解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSumOptimized(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // 如果没有找到解，返回[-1, -1]
    }
    
    /**
     * 打印数组的辅助方法
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * 运行测试案例
     */
    public static void runTests() {
        EnvTest envTest = new EnvTest();
        
        System.out.println("=== LeetCode 第一题：两数之和 测试案例 ===\n");
        
        // 测试案例1：基本案例
        System.out.println("测试案例1：");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("输入：nums = [2, 7, 11, 15], target = " + target1);
        
        int[] result1 = envTest.twoSum(nums1, target1);
        System.out.print("暴力解法结果：");
        printArray(result1);
        
        int[] result1Opt = envTest.twoSumOptimized(nums1, target1);
        System.out.print("哈希表解法结果：");
        printArray(result1Opt);
        System.out.println();
        
        // 测试案例2：包含重复元素
        System.out.println("测试案例2：");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("输入：nums = [3, 2, 4], target = " + target2);
        
        int[] result2 = envTest.twoSum(nums2, target2);
        System.out.print("暴力解法结果：");
        printArray(result2);
        
        int[] result2Opt = envTest.twoSumOptimized(nums2, target2);
        System.out.print("哈希表解法结果：");
        printArray(result2Opt);
        System.out.println();
        
        // 测试案例3：两个相同元素
        System.out.println("测试案例3：");
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("输入：nums = [3, 3], target = " + target3);
        
        int[] result3 = envTest.twoSum(nums3, target3);
        System.out.print("暴力解法结果：");
        printArray(result3);
        
        int[] result3Opt = envTest.twoSumOptimized(nums3, target3);
        System.out.print("哈希表解法结果：");
        printArray(result3Opt);
        System.out.println();
        
        // 测试案例4：较大数组
        System.out.println("测试案例4：");
        int[] nums4 = {1, 5, 8, 10, 13, 17, 20, 25, 30, 35};
        int target4 = 45;
        System.out.println("输入：nums = [1, 5, 8, 10, 13, 17, 20, 25, 30, 35], target = " + target4);
        
        int[] result4 = envTest.twoSum(nums4, target4);
        System.out.print("暴力解法结果：");
        printArray(result4);
        
        int[] result4Opt = envTest.twoSumOptimized(nums4, target4);
        System.out.print("哈希表解法结果：");
        printArray(result4Opt);
        System.out.println();
        
        // 性能测试
        System.out.println("=== 性能测试 ===");
        int[] largeNums = new int[10000];
        for (int i = 0; i < largeNums.length; i++) {
            largeNums[i] = i;
        }
        int largeTarget = 19998; // 9999 + 9999
        
        long startTime = System.currentTimeMillis();
        envTest.twoSum(largeNums, largeTarget);
        long endTime = System.currentTimeMillis();
        System.out.println("暴力解法耗时：" + (endTime - startTime) + "ms");
        
        startTime = System.currentTimeMillis();
        envTest.twoSumOptimized(largeNums, largeTarget);
        endTime = System.currentTimeMillis();
        System.out.println("哈希表解法耗时：" + (endTime - startTime) + "ms");
    }
    
    /**
     * 主方法
     */
    public static void main(String[] args) {
        runTests();
    }
}
