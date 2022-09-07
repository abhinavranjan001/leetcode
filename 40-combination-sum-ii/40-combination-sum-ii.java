class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recur(0, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    public void recur(int sum, List<Integer> list, int[] candidates, int target, int start) {
        if (sum == target) {
            result.add(new ArrayList(list));
        } else if (sum > target) return;
        else {
            for (int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                recur(sum + candidates[i], list, candidates, target, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}