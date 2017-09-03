package 剑指offer;

public class 第19题_二叉树的镜像 {
	public void Mirror(TreeNode root) {
		if(root==null)
            return ;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
