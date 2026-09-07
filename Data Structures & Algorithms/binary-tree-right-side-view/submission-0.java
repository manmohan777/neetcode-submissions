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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                TreeNode u = q.poll();
                if(size==1)
                    res.add(u.val);
                if(u.left!=null){
                    q.add(u.left);
                }
                if(u.right!= null){
                    q.add(u.right);
                }
                size--;
            }
        }
        return res;
    }
}
