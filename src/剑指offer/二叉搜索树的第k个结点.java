package 剑指offer;

public class 二叉搜索树的第k个结点 {
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        Holder holder = new Holder();
        midorderThravel(pRoot, holder, k);
        return holder.result;
    }
    
	void midorderThravel(TreeNode root,Holder holder,int k){
        if(root==null)
        	return;
        
        midorderThravel(root.left, holder, k);
        holder.count++;
        if(holder.count==k)
        	holder.result = root;
        midorderThravel(root.right, holder, k);
    }
	
	class Holder{
		int count = 0;
		TreeNode result = null;
	}
	
}
