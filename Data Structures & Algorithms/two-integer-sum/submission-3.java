class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(hashMap.containsKey(rem)) {
                return new int[]{hashMap.get(rem), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
