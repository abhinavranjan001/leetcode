class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap();
        char[] ch = s.toCharArray();
        char[] ch1 = t.toCharArray();
        for(char c: ch1)
            map.put(c, 1 + map.getOrDefault(c, 0));

        int distinctChars = map.size();
        int sizeTillNow = 0;

        int x = 0, y = 0;
        int min = 1000000;
        int[] ans = new int[2];

        HashMap<Character, Integer> windowMap = new HashMap();
        while(y < ch.length){
            windowMap.put(ch[y], 1 + windowMap.getOrDefault(ch[y], 0));
            if(map.containsKey(ch[y]) && map.get(ch[y]).intValue() == windowMap.get(ch[y]).intValue())
                sizeTillNow++;

            while(x <= y && sizeTillNow == distinctChars){
                if(min > y-x){
                    min = y-x;
                    ans[0] = x;
                    ans[1] = y;
                }

                windowMap.put(ch[x], -1 + windowMap.get(ch[x]));
                if(map.containsKey(ch[x]) && map.get(ch[x]).intValue() > windowMap.get(ch[x]).intValue())
                    sizeTillNow--;
                x++;
            }
            y++;
        }

        return min == 1000000 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}