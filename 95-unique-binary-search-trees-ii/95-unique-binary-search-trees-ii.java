/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return recur(1, n);
    }
    
    public List<TreeNode> recur(int s, int e){
        List<TreeNode> result = new ArrayList();
        if(s > e) result.add(null);
        else{
            for(int i=s; i<=e; i++){
                List<TreeNode> left = recur(s, i-1);
                List<TreeNode> right = recur(i+1, e);
                for(TreeNode l: left)
                    for(TreeNode r: right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        result.add(root);
                    }
            }
        }
        return result;
    }
}