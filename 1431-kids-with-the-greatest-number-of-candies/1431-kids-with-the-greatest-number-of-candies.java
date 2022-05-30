class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        
        List<Boolean> r = new ArrayList();
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= max)
                r.add(true);
            else r.add(false);
        }
        
        return r;
            
    }
}