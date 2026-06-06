class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new ArrayList<> ();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            int strLength = str.length();
            int[] temp = new int[26];

            for (int i = 0; i < strLength; i++) {
                temp[str.charAt(i) - 'a']++;
            }

            String sorted = "";
            for (int i = 0; i < 26; i++){
                sorted += temp[i] + '#';
            }
            System.out.println(sorted);

            List<String> tempList = hashMap.getOrDefault(sorted, new ArrayList<String> ());
            tempList.add(str);
            hashMap.put(sorted,tempList);
        }

        anagramsList.addAll(hashMap.values());
        
        return anagramsList;
    }
}
