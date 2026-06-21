class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k) {
                pq.remove();
            }
        }
        int[] topK = new int [k];

        int i = 0;
        while(!pq.isEmpty()) {
            topK[i++] = pq.remove()[0];
        }
        return topK;
    }
}
