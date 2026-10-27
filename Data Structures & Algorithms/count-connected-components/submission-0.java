class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0; i < n; i++)  {
            root[i] = i;
        }
        int totalComp = n;
        for(int i =0; i < edges.length; i++)    {
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if(root1 != root2)  {
                root[root1] = root2;
                totalComp--;
            }
        }
        return totalComp;
    }

    public int find(int[] parent, int i)   {
        if(parent[i] == i)  {
            return i;
        }
        return find(parent,parent[i]);
    }
}
