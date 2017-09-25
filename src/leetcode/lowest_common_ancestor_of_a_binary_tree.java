package leetcode;

public class lowest_common_ancestor_of_a_binary_tree {
	/**
	 * 递归遍历，遇到等于p或者q或者null的节点就返回该节点，那么当返回的left和right都不为空时，此时的root就是最近的公共节点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==p || root==q || root==null)
    	   return root;
       
       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);
       
       if(left==null && right==null)
    	   return null;
       else if(left!=null && right==null)
    	   return left;
       else if(left==null && right!=null)
    	   return right;
       else
    	   return root;	
	}
}
