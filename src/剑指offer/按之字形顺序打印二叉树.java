package 剑指offer;

import java.util.ArrayList;
public class 按之字形顺序打印二叉树 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if(pRoot==null)
			return list;
		
		ArrayList<TreeNode> list1 = new ArrayList<>();
		ArrayList<TreeNode> list2 = new ArrayList<>();
		list1.add(pRoot);
		
		int count = 1;
		while(list1.size()!=0||list2.size()!=0){
			if(count%2==1){
				ArrayList<Integer> temp = new ArrayList<>();
				for(int i=list1.size()-1;i>=0;i--){
					temp.add(list1.get(i).val);
					if(list1.get(i).left!=null)
						list2.add(list1.get(i).left);
					if(list1.get(i).right!=null)
						list2.add(list1.get(i).right);
				}
				list1.clear();
				list.add(temp);
			}
			else{
				ArrayList<Integer> temp = new ArrayList<>();
				for(int i=list2.size()-1;i>=0;i--){
					temp.add(list2.get(i).val);
					if(list2.get(i).right!=null)
						list1.add(list2.get(i).right);
					if(list2.get(i).left!=null)
						list1.add(list2.get(i).left);
				}
				list2.clear();
				list.add(temp);
			}
			count++;
		}
		
		return list;
    }
}
