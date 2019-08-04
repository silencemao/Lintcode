package main.java;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断两个二叉树是否为相同的二叉树
 * */
public class Leetcode_100_sameTree {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tNode = new TreeNode();
        TreeNode p1 = tNode.createTree(nums);
        tNode.levelOrderTree(p1);
        tNode.preOrderTree(p1);
        tNode.inOrderTree(p1);
        tNode.lateOrderTree(p1);
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){ };

    TreeNode(int x){
        this.val = x;
    }

    public TreeNode createTree(int[] nums){
        TreeNode pHead = new TreeNode(nums[0]);
        TreeNode tmp = pHead;
        TreeNode t2 = new TreeNode(nums[1]);
        TreeNode t3 = new TreeNode(nums[2]);
        TreeNode t4 = new TreeNode(nums[3]);
        TreeNode t5 = new TreeNode(nums[4]);
        TreeNode t6 = new TreeNode(nums[5]);
        TreeNode t7 = new TreeNode(nums[6]);

        tmp.left = t2;
        tmp.right = t3;

        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        return pHead;
    }

    public void levelOrderTree(TreeNode p){
        System.out.println("\n层序遍历");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);

        while (!queue.isEmpty()){
            TreeNode head =  queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null){
                queue.offer(head.left);
            }
            if (head.right != null){
                queue.offer(head.right);
            }
        }
    }

    public void preOrderTree(TreeNode p){
        System.out.println("\n前序遍历");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        while (!stack.isEmpty()){
            TreeNode head = stack.pop();
            System.out.print(head.val + " ");

            if (head.left != null){
                stack.add(head.left);
            }

            if (head.right != null){
                stack.push(head.right);
            }
        }
    }

    public void inOrderTree(TreeNode p){
        System.out.println("\n中序遍历");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.add(p);
                p = p.left;
            }
            else {
                TreeNode head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null){
                    p = head.right;
                }
            }
        }
    }

    public void lateOrderTree(TreeNode p){
        System.out.println("\n后序遍历");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if ((top.left==null && top.right==null) || top.left==p || top.right==p){
                System.out.print(top.val + " ");
                stack.pop();
                p = top;
            }
            else {
                if (top.right != null){
                    stack.add(top.right);
                }
                if (top.left != null){
                    stack.add(top.left);
                }
            }
        }
    }

}
