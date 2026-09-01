class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> hm = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String st = strs[i];
            int arr[] = new int[26];
            for(int j=0; j<st.length(); j++){
                arr[st.charAt(j) - 'a']++;
            }

            String key = Arrays.toString(arr);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(st);
        }

        return new ArrayList<>(hm.values());
    }
}
