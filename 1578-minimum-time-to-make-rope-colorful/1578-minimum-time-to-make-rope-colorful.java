class Solution {
    public int minCost(String colors, int[] nt) {
        int sum = 0;
        Stack<Character> st = new Stack();
        st.push(colors.charAt(0));

        int idx = 0;
        for (int i = 1; i < nt.length; i++) {
            if (st.peek() == colors.charAt(i)) {
                sum += Math.min(nt[idx], nt[i]);
                idx = getMaxIdx(nt, idx, i);
            } else {
                st.push(colors.charAt(i));
                idx = i;
            }
        }

        return sum;
    }
    
    public int getMaxIdx(int[] nt, int x, int y) {
        return nt[x] > nt[y] ? x : y;
    }
}