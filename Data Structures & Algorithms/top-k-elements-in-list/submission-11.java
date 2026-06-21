class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqList = new List[nums.length + 1];

        for (int i = 0; i < freqList.length; i++) {
            freqList[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            freqList[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freqList.length - 1; i > 0 && index < k; i--) {
            for (int n : freqList[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
