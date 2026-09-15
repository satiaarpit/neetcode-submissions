class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < words.length) {
            int j = i;
            int lineLength = 0;
            while(i<words.length && ((lineLength + words[i].length()) < maxWidth))  {
                lineLength+=words[i].length();
                if(j != i)  {
                    //If not first word in the line add space
                    lineLength += 1;
                }
                i++;
            }
            int numberOfSpacesToAdd = maxWidth - lineLength;
            int totalSpaces = numberOfSpacesToAdd + (i-j-1);
            int spacesForAll = (i == words.length) || ((i-j-1) == 0)? 0 : totalSpaces/(i-j-1);
            int leftOver = (i == words.length) || ((i-j-1) == 0)? totalSpaces :  totalSpaces%(i-j-1);
            StringBuilder space = new StringBuilder();
            StringBuilder line = new StringBuilder();
            while(spacesForAll > 0) {
                space.append(' ');
                spacesForAll--;
            }
            int index = j;
            while(index < i)   {
                if(index!=j)    {
                    line.append(space);
                    if(leftOver > 0)    {
                        line.append(' ');
                        leftOver--;
                    }
                }
                line.append(words[index]);
                index++;
            }
            while(leftOver > 0) {
                line.append(' ');
                leftOver--;
            }
            list.add(line.toString());
        }
        return list;
    }
}