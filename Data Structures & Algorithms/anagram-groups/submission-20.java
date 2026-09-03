class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, Integer> map = new HashMap();
        
        for(int i = 0; i< strs.length; i++)  {
            StringBuilder str = new StringBuilder();
            int freq[] = new int[26];
            for(int j=0; j < strs[i].length(); j++) {
                ++freq[strs[i].charAt(j) - 'a'];
            }
            for(int j = 0; j< freq.length; j++) {
                str.append(freq[j]);
                str.append("$");
            }
            String key = str.toString();
            if(map.containsKey(key))   {
                result.get(map.get(key)).add(strs[i]);
            } else  {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                result.add(list);
                map.put(key, result.size()-1);
            }
        }
        return result;
    }
}
