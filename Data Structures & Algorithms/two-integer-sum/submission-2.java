class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int j = 0; j < n; j++) {
            int remaining = target - nums[j];

            if (hashMap.containsKey(remaining)) {
                return new int[] {hashMap.get(remaining), j};
            }
            hashMap.put(nums[j], j);
        }
        return new int[-1];
    }
}
