//二分搜索树，是一棵空树，或者具有下列性质：
//
//       1.若它的左子树不为空，则左子树上所有结点的值均小于根结点的值；
//
//       2.若它的右子树不为空，则右子树上所有结点的值均大于根结点的值；
//
//       3.它的左右子树均为二分查找树。

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class BST<E extends Comparable<E>> {//二分搜索树存储的节点必须满足可比较性，所以使用extends对模板E进行限制
    private class Node{
        public E e;
        public Node left , right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){

        root = add(root,e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root , e);
    }
    //看以root为根的二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node , E e){
        if(node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left , e);
        } else { //e.compareTo(node.e) > 0
            return contains(node.right , e);
        }
    }

    //二分搜索树的前序遍历,父节点在前
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序遍历,使用stack
    public void preOrderNR(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的中序遍历，父节点在中间，中序遍历的结果就是元素排序的结果！！
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的中序遍历，非递归实现,使用stack
    public void inOrderNR(){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root; //当前访问的结点

        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.empty())
        {
            cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
        }

    }


    // 二分搜索树的后序遍历,应用：为二分搜索树 释放内存
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的后序遍历，非递归实现,使用stack
    public void postOrderNR(){
        if(root ==null)
            return;
        Stack<Node> stack = new Stack<>();

        Node cur = root; //当前访问的结点
        Node lastVisitNode = null; //上次访问的结点

        //把currentNode移到左子树的最下边
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.empty()){
            cur = stack.pop();  //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if(cur.right != null && cur.right != lastVisitNode){
                //根节点再次入栈
                stack.push(cur);
                //进入右子树，且可肯定右子树一定不为空
                cur = cur.right;
                while(cur != null){
                    //再走到右子树的最左边
                    stack.push(cur);
                    cur = cur.left;
                }
            }else{
                //访问
                System.out.println(cur.e);
                //修改最近被访问的节点
                lastVisitNode = cur;
            }
        } //while
    }

    // 二分搜索树的层序遍历,广度优先遍历，主要应用于搜索策略，最短路径。
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }


    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root , e);
    }
    //删除掉以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node , E e){
        if (node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left , e);
            return node;
        }
        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right , e);
            return node;
        }
        else{ //e == node.e

            //待删除节点左子树为空
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size -- ;
                return leftNode;
            }

            //待删除的节点左右子树都不为空
            //找到比待删除节点大的最小节点，即待删除节点的右子树的最小节点
            //用这个几点代替删除节点的位置
            Node successor = minimum(node.right);//successor 为被删除节点的后继节点，此处也可以找被删除节点的前驱节点。
            successor.right = removeMin(node.right);//removeMin中会进行size--，但实际上size并没有减少，该节点被给了successor
            successor.left = node.left;

            node.left = node.right = null;
            //此处不需要size--，因为在removeMin中已经多做了一次size--
            return successor;
        }
    }




    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root , 0 , res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
