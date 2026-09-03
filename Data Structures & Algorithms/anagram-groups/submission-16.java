class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        
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
                map.get(key).add(strs[i]);
            } else  {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        
        for(String k : map.keySet())    {
            result.add(map.get(k));
        }   
        return result;
    }
}
