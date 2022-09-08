package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 二叉树
public class Test7 {
    public static void main(String[] args) {
/*        TreeNode left1_3 = new TreeNode(4);
        TreeNode right1_3 = new TreeNode(5);
        TreeNode left1_2 = new TreeNode(2);
        TreeNode right1_2 = new TreeNode(3, left1_3, right1_3);
        TreeNode root = new TreeNode(1, left1_2, right1_2);
        Codec codec = new Codec();
        String ans = codec.serialize(root);
        System.out.println(ans);
        TreeNode treeNode = codec.deserialize(ans);
        System.out.println(11111);*/

        TreeNode left1_4 = new TreeNode(4);
        TreeNode left1_3 = new TreeNode(4);
        TreeNode left2_3 = new TreeNode(2, left1_4,null);
        TreeNode right1_3 = new TreeNode(4);
        TreeNode left1_2 = new TreeNode(2, left1_3, null);
        TreeNode right1_2 = new TreeNode(3, left2_3, right1_3);
        TreeNode root = new TreeNode(1, left1_2, right1_2);
        System.out.println(count(root));
        System.out.println(traverse(root));
    }

    // 根据前序遍历和中序遍历还原二叉树
    private static TreeNode preBuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0) {
            return null;
        }
        TreeNode ans = preBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return ans;
    }
    private static TreeNode preBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        int treeNodeVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == treeNodeVal) {
                index = i;
                break;
            }
        }

        int leftLength = index - inStart;
        int rightLength = inEnd - index;

        int preLeftStart = preStart + 1;
        int preLeftEnd = preStart + leftLength;
        int preRightStart = preLeftEnd + 1;
        int preRightEnd = preEnd;

        int inLeftStart = inStart;
        int inLeftEnd = index - 1;
        int inRightStart = index + 1;
        int inRightEnd = inEnd;

        TreeNode treeNode = new TreeNode(treeNodeVal);
        if (preLeftStart <= preLeftEnd && inLeftStart <= inLeftEnd) {
            treeNode.left = preBuild(preorder, preLeftStart, preLeftEnd, inorder, inLeftStart, inLeftEnd);
        }
        if (preRightStart <= preRightEnd && inRightStart <= inRightEnd) {
            treeNode.right = preBuild(preorder, preRightStart, preRightEnd, inorder, inRightStart, inRightEnd);
        }
        return treeNode;
    }

    // 根据后序遍历和中序遍历还原二叉树
    private static TreeNode postBuildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length <= 0 || postorder == null || postorder.length <= 0) {
            return null;
        }
        TreeNode ans = postBuild(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return ans;
    }
    private static TreeNode postBuild(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        int treeeNodeVal = postorder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == treeeNodeVal) {
                index = i;
                break;
            }
        }
        int leftLength = index - inStart;
        int rightLength = inEnd - index;

        int inLeftStart = inStart;
        int inLeftEnd = index - 1;
        int inRightStart = index + 1;
        int inRightEnd = inEnd;

        int postRightStart = postEnd - rightLength;
        int postRightEnd = postEnd - 1;
        int postLeftStart = postStart;
        int postLeftEnd = postRightStart - 1;

        TreeNode treeNode = new TreeNode(treeeNodeVal);
        if(inLeftStart <= inLeftEnd && postLeftStart <= postLeftEnd && inLeftStart >= 0 && postLeftStart >= 0){
            treeNode.left = postBuild(inorder, inLeftStart, inLeftEnd, postorder, postLeftStart, postLeftEnd);
        }
        if (inRightStart <= inRightEnd && postRightStart <= postRightEnd && inRightStart >= 0 && postRightStart >= 0) {
            treeNode.right = postBuild(inorder, inRightStart, inRightEnd, postorder, postRightStart, postRightEnd);
        }
        return treeNode;
    }

    // 寻找重复的子树, 利用后序遍历序列化
    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        findSubtrees(root, ans, hashMap);
        return ans;
    }
    private static String findSubtrees(TreeNode treeNode, List<TreeNode> ans, HashMap<String, Integer> hashMap){
        if (treeNode == null) {
            return "#";
        }
        String left = findSubtrees(treeNode.left, ans, hashMap);
        String right = findSubtrees(treeNode.right, ans, hashMap);
        String subTree = left + "," + right + "," + treeNode.val;

        int value = hashMap.getOrDefault(subTree, 0);
        if (value == 1) {
            ans.add(treeNode);
        }
        hashMap.put(subTree, value+1);

        return subTree;
    }

    // 二叉树的节点数
    private static int count(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        }
        int left = count(treeNode.left);
        int right = count(treeNode.right);
        return left + right + 1;
    }

    // 后序遍历，序列化
    private static String traverse(TreeNode root){
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        return subTree;
    }

    // 二叉搜索树 ： BST 的每一个节点node，左子树节点的值都比node的值要小，右子树节点的值都比node的值大
    // 中序遍历的结果是升序的

    // 二叉搜索树中第K小的元素
    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        inOrderTraverse(root, list);
        return list.get(k-1);
    }
    private static void inOrderTraverse(TreeNode treeNode, List<Integer> list){
        if (treeNode == null) {
            return;
        }
        inOrderTraverse(treeNode.left, list);
        list.add(treeNode.val);
        inOrderTraverse(treeNode.right, list);
    }


    // 把二叉搜索树转换为累加树
    private static int addNum = 0;
    private static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        inOrderSerialize(root, list);

        for (int i = list.size() - 1; i >= 0; i--) {
            addNum = addNum + list.get(i);
            list.set(i, addNum);
        }

        execConvertBST(root, list);
        return root;
    }
    private static void inOrderSerialize(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inOrderSerialize(treeNode.left, list);
        list.add(treeNode.val);
        inOrderSerialize(treeNode.right, list);
    }
    private static void execConvertBST(TreeNode treeNode, List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        if (treeNode == null) {
            return;
        }
        execConvertBST(treeNode.left, list);
        treeNode.val = list.get(0);
        list.remove(0);
        execConvertBST(treeNode.right, list);
    }

    // 把二叉搜索树转换为累加树2
    private static TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        calcConvertBST2(root);
        return root;
    }
    private static void calcConvertBST2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        calcConvertBST2(treeNode.right);
        addNum = addNum + treeNode.val;
        treeNode.val = addNum;
        calcConvertBST2(treeNode.left);
    }

    // 96. 不同的二叉搜索树
    private static int numTrees(int n) {
        return countNumTrees(1, n);
    }
    private static int countNumTrees(int lo, int hi){

        if (lo > hi) {
            return 1;
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = countNumTrees(lo, i-1);
            int right = countNumTrees(i+1, hi);
            res += left * right;
        }
        return res;
    }

    //236. 二叉树的最近公共祖先
    private static boolean flag = false;
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        TreeNode treeNode = getLowestCommonAncestor(root, p, q);
        return treeNode;
    }
    private static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            getAnoherTreeNode(root, q);
        }
        if (root == q) {
            getAnoherTreeNode(root, p);
        }
        if (flag) {
            return root;
        }
        return  null;

    }
    private static void getAnoherTreeNode(TreeNode root, TreeNode node){
        if (flag) {
            return;
        }
        if (root == node) {
            flag = true;
            return;
        }
        getAnoherTreeNode(root.left, node);
        getAnoherTreeNode(root.right, node);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        String ans = sb.toString();
        return ans.substring(0, ans.length()-1);
    }
    private void preSerialize(TreeNode treeNode, StringBuilder sb) {
        if (treeNode == null) {
            sb.append("null,");
            return;
        }
        sb.append(treeNode.val + ",");
        preSerialize(treeNode.left, sb);
        preSerialize(treeNode.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 0) {
            return null;
        }
        String[] treeNodeVals = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(treeNodeVals));
        TreeNode treeNode = preDeserialize(list);
        return treeNode;
    }
    private TreeNode preDeserialize(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String element = list.remove(0);
        if (element.equals("null")) {
            return null;
        }
        int treeNodeVal = Integer.parseInt(element);
        TreeNode treeNode = new TreeNode(treeNodeVal);
        treeNode.left = preDeserialize(list);
        treeNode.right = preDeserialize(list);
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
