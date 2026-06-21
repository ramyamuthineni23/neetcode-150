class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(pq.size() >= k) {
                if (pq.peek()[1] < entry.getValue()) {
                    pq.remove();
                } else {
                    continue;
                }
            }
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] topK = new int [k];

        int i = 0;
        while(!pq.isEmpty()) {
            topK[i++] = pq.remove()[0];
        }
        return topK;
    }
}
