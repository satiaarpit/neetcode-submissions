class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < strs.size(); i++)  {
            String message = strs.get(i);
            strBuilder.append(message.length()+"#"+message);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int firstIndex = 0;
        int lastIndex = 0;
        while(lastIndex < str.length())    {
            if(str.charAt(lastIndex) == '#')    {
                int length = Integer.parseInt(str.substring(firstIndex,lastIndex));
                lastIndex++;//To avoid #
                result.add(str.substring(lastIndex,lastIndex +length));
                lastIndex = firstIndex = lastIndex +  length;
            } else  {
                lastIndex++;
            }
        }

        return result;
    }
}
