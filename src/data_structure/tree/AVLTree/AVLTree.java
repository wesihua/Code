package data_structure.tree.AVLTree;

import data_structure.tree.Tree;
import data_structure.tree.TreeNode;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
	
	public AVLNode<T> root;
	
	@Override
    public boolean isEmpty() {
        return root==null;
    }


    @Override
    public int size() {
        return size(root);
    }


    public int size(AVLNode<T> subtree){
        if(subtree==null){
            return 0;
        }else {
            return size(subtree.left) + 1 + size(subtree.right);
        }


    }
	
	public int height() {
		return height(root);
	}
	
	public int height(AVLNode<T> node) {
		//空结点高度为-1;
		return node==null?-1:node.height;
	}
	
	/**
	 * 插入方法
	 * @param data
	 */
	public void insert(T data) {
		if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
		this.root = insert(data, root);
	}
	
	/**
	 * 插入操作
	 * @param data
	 * @param node
	 * @return
	 */
	public AVLNode<T> insert(T data,AVLNode<T> node) {
		
		//node为null，表明已经找到插入的位置了，可以创建新结点了
		if(node==null) {
			node = new AVLNode<T>(data);
		}
		
		int comp = data.compareTo(node.data);
		
		//插入的值比当前node结点要小，因此要插入到结点的左子树，否则要插入到结点的右子树
		if(comp<0) {
			node.left = insert(data, node.left);
			
			//判断插入结点后，左右子树的高度差是否等于2，一旦都等于2，表明该结点为失衡点，就要开始旋转操作进行恢复平衡
			if(height(node.left)-height(node.right)==2) {
				//判断插入的数据是插入到失衡点左孩子的左子树还是右子树
				if(data.compareTo(node.left.data)<0) {
					//若是左子树，则是LL型
					node = singleRotateRight(node);
				}
				else {
					//若是右子树，则是LR型
					node = doubleRotateLeftRight(node);
				}
			}
		}
		else if(comp>0) {
			node.right = insert(data, node.right);
			
			//判断插入结点后，左右子树的高度差是否等于2，一旦都等于2，表明该结点为失衡点，就要开始旋转操作进行恢复平衡
			if(height(node.right)-height(node.left)==2) {
				//判断插入的数据是插入到失衡点左孩子的左子树还是右子树
				if(data.compareTo(node.right.data)<0) {
					//若是左子树，则是RL型
					node = doubleRotateRightLeft(node);
				}
				else {
					//若是右子树，则是RR型
					node = singleRotateLeft(node);
				}
			}
		}
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		
		return node;
	}
	
	/**
     * 删除方法
     * @param data
     */
    public void remove(T data) {
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root=remove(data,root);
    }

    /**
     * 删除操作
     * @param data
     * @param p
     * @return
     */
    private AVLNode<T> remove(T data,AVLNode<T> p){

        if(p ==null)
            return null;

        int result=data.compareTo(p.data);

        //从左子树查找需要删除的元素
        if(result<0){
            p.left=remove(data,p.left);

            //检测是否平衡
            if(height(p.right)-height(p.left)==2){
                AVLNode<T> currentNode=p.right;
                //判断需要那种旋转
                if(height(currentNode.right)>=height(currentNode.left)){
                    //RR
                    p=singleRotateLeft(p);
                }else{
                    //RL
                    p=doubleRotateRightLeft(p);
                }
            }

        }
        //从右子树查找需要删除的元素
        else if(result>0){
            p.right=remove(data,p.right);
            //检测是否平衡
            if(height(p.left)-height(p.right)==2){
                AVLNode<T> currentNode=p.left;
                //判断需要那种旋转
                if(height(currentNode.left)>=height(currentNode.right)){
                    //LL
                    p=singleRotateRight(p);
                }else{
                    //LR
                    p=doubleRotateLeftRight(p);
                }
            }
        }
        //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        else if(p.right!=null&&p.left!=null){

            //寻找替换结点
            p.data=findMin(p.right).data;

            //移除用于替换的结点
            p.right = remove( p.data, p.right );
        }
        else {
            //只有一个孩子结点或者只是叶子结点的情况
            p=(p.left!=null)? p.left:p.right;
        }

        //更新高度值
        if(p!=null)
            p.height = Math.max( height( p.left ), height( p.right ) ) + 1;
        return p;
    }
	
	/**
	 * 右旋操作（针对LL型的情况）
	 * @param unbalance
	 * @return
	 */
	public AVLNode<T> singleRotateRight(AVLNode<T> unbalance) {
		//失衡点的左孩子
		AVLNode<T> leftNode = unbalance.left;
		
		//将失衡点的左孩子更新为leftNode的右子树
		unbalance.left = leftNode.right;
		//失衡点右旋，变成leftNode的右孩子
		leftNode.right = unbalance;
		
		//更新leftNode和失衡点的高度
		unbalance.height = Math.max(height(unbalance.left),height(unbalance.right)) + 1;
		leftNode.height = Math.max(height(leftNode.left),unbalance.height) + 1;
		
		return leftNode;
	}
	
	/**
	 * 左旋操作（针对RR型的情况）
	 * @param unbalance
	 * @return
	 */
	public AVLNode<T> singleRotateLeft(AVLNode<T> unbalance) {
		//失衡点的右孩子
		AVLNode<T> rightNode = unbalance.right;
		
		//将失衡点的右孩子更新为rightNode的左子树
		unbalance.right = rightNode.left;
		//失衡点左旋，变成rightNode的左孩子
		rightNode.left = unbalance;
		
		//更新rightNode和失衡点的高度
		unbalance.height = Math.max(height(unbalance.left),height(unbalance.right)) + 1;
		rightNode.height = Math.max(height(rightNode.right), unbalance.height) + 1;
		
		return rightNode;
	}
	
	/**
	 * 先左旋再右旋操作（针对LR型的情况）
	 * @param unbalance
	 * @return
	 */
	public AVLNode<T> doubleRotateLeftRight(AVLNode<T> unbalance) {
		unbalance.left = singleRotateLeft(unbalance.left);
		return singleRotateRight(unbalance);
	}
	
	/**
	 * 先右旋再左旋操作（针对RL型的情况）
	 * @param unbalance
	 * @return
	 */
	public AVLNode<T> doubleRotateRightLeft(AVLNode<T> unbalance) {
		unbalance.right = singleRotateRight(unbalance.right);
		return singleRotateLeft(unbalance);
	}
	
	public String preOrder() {
        String sb=preOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * 先根遍历
     * @param subtree
     * @return
     */
    public String preOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null) {
            //先访问根结点
            sb.append(subtree.data).append(",");
            //访问左子树
            sb.append(preOrder(subtree.left));
            //访问右子树
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();
    }

    public String inOrder() {
        String sb=inOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * 中根遍历
     * @param subtree
     * @return
     */
    private String inOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null) {
            //访问左子树
            sb.append(inOrder(subtree.left));
            //访问根结点
            sb.append(subtree.data).append(",");
            //访问右子树
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }

    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * 后根遍历
     * @param subtree
     * @return
     */
    private String postOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null){
            //访问左子树
            sb.append(postOrder(subtree.left));
            //访问右子树
            sb.append(postOrder(subtree.right));
            //访问根结点
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }
	
    private void printTree( AVLNode<T> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.data );
            printTree( t.right );
        }
    }

	@Override
	public String levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMin() {
		return findMin(root).data;
	}
	
	/**
     * 查找最小值结点
     * @param p
     * @return
     */
    private AVLNode<T> findMin(AVLNode<T> p){
        if (p==null)//结束条件
            return null;
        else if (p.left==null)//如果没有左结点,那么t就是最小的
            return p;
        return findMin(p.left);
    }

	@Override
	public T findMax() {
		return findMax(root).data;
	}
	
	/**
     * 查找最大值结点
     * @param p
     * @return
     */
    private AVLNode<T> findMax(AVLNode<T> p){
        if (p==null)
            return null;
        else if (p.right==null)//如果没有右结点,那么t就是最大的
            return p;
        return findMax(p.right);
    }

	@Override
	public TreeNode findNode(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T data) throws Exception {
		return data != null && contain(data, root);
	}
	
	public boolean contain(T data , AVLNode<T> subtree){

        if (subtree==null)
            return false;

        int result =data.compareTo(subtree.data);

        if (result<0){
            return contain(data,subtree.left);
        }else if(result>0){
            return contain(data,subtree.right);
        }else {
            return true;
        }
    }

	@Override
	public void clear() {
		this.root=null;
	}
    
    public  static void main(String arg[]){

        AVLTree<Integer> avlTree=new AVLTree<>();

        for (int i = 1; i <10 ; i++) {
            avlTree.insert(i);
        }

        System.out.println("先根遍历:"+avlTree.preOrder());

        System.out.println("中根遍历:"+avlTree.inOrder());

        System.out.println("后根遍历:"+avlTree.postOrder());
        
        System.out.println("================");
        
        avlTree.remove(9);
        avlTree.remove(5);

        System.out.println("先根遍历:"+avlTree.preOrder());

        System.out.println("中根遍历:"+avlTree.inOrder());

        System.out.println("后根遍历:"+avlTree.postOrder());

    }
}
