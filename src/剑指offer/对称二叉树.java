package 剑指offer;

public class 对称二叉树 {
	boolean isSymmetrical(TreeNode pRoot)
    {
		if(pRoot == null)
			return true;
		return isSymmetrical(pRoot.left, pRoot.right);
    }
	
	boolean isSymmetrical(TreeNode a,TreeNode b){
		if(a==null && b==null){
			return true;
		}
		else if(a!=null&&b!=null){
			if(a.val==b.val)
				return isSymmetrical(a.left, b.right) && isSymmetrical(a.right, b.left);
			else
				return false;
		}
		
		return false;
	}
	
//	public void midorderTravel(TreeNode root,StringBuilder stringBuilder){
//		if(root==null)
//			return;
//		midorderTravel(root.left, stringBuilder);
//		stringBuilder.append(root.val);
//		midorderTravel(root.right, stringBuilder);
//	}
	
}
