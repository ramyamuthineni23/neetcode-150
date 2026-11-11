class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();

        HashMap<String, List<String>> hashMap= new HashMap<>();
        int m = strs.length;

        for (String str : strs) {
            int[] strKey = new int[26];

            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i)-'a';
                strKey[index]++;
            }
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += strKey[i]+'@';
            }

            List<String> values = new ArrayList<>();
            if(hashMap.containsKey(key)) {
                values = hashMap.get(key);
            } 
            values.add(str);
            hashMap.put(key, values);
        }
        for (List<String> values : hashMap.values()) {
            resultList.add(values);
        }
        return resultList;
    }
}
