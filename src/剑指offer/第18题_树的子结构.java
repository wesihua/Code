package 剑指offer;

public class 第18题_树的子结构 {
//	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
//        if(root1==null||root2==null)
//            return false;
//        
//        StringBuffer root1_preorderTraversal = new StringBuffer("");
//        preorderTraversalRecur(root1, root1_preorderTraversal);
//        
//        StringBuffer root2_preorderTraversal = new StringBuffer("");
//        preorderTraversalRecur(root2, root2_preorderTraversal);
//        
//        if(root1_preorderTraversal.toString().contains(root2_preorderTraversal.toString()))
//        	return true;
//        else
//        	return false;
//    }
//	
//	public void preorderTraversalRecur(TreeNode root1,StringBuffer stringBuffer){
//		if(root1==null)
//			return;
//		stringBuffer.append(root1.val);
//		preorderTraversalRecur(root1.left, stringBuffer);
//		preorderTraversalRecur(root1.right, stringBuffer);
//	}
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1==null||root2==null)
			return false;
		
		//先判断root2是否root1以root1为跟的子结构，若不是，则通过递归调用判断root2是否root1左子树的子结构或者root1右子树的子结构
		boolean result = isSubtree(root1, root2) || 
				   HasSubtree(root1.left, root2) || 
				   HasSubtree(root1.right, root2);
		
		return result;
	}
	
	//判断pRoot2是否是pRoot1的子结构
	public boolean isSubtree(TreeNode pRoot1,TreeNode pRoot2) {
		if(pRoot2==null) return true;
		if(pRoot1==null) return false;
		
		if(pRoot1.val==pRoot2.val) {
			boolean result = isSubtree(pRoot1.left, pRoot2.left) && isSubtree(pRoot1.right, pRoot2.right);
			return result;
		}
		else
			return false;
		
	}
	
	
}
