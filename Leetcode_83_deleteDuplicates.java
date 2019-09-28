package main.java;

/**
 * 删除链表中重复的数字
 * */
public class Leetcode_83_deleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode head = createList(nums);
        head = deleteDuplicates(head);
        printList(head);
    }

    /**
     * 双指针，分别是head和head.next 一起向后走，val相等时，前面指针位置不动，后面指针继续向后走。
     * val不相等时，更新前面指针的next，并且前面指针指向next，后面指针继续向后走。
     * 最后，后面指针为null时，前面指针位置为链表最后一个，把它的next更新为null即可。
     * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        ListNode preNode = head;
        ListNode tmp = head.next;

        while (tmp != null) {
            if (preNode.val != tmp.val) {
                preNode.next = tmp;
                preNode = preNode.next;
            }
            tmp = tmp.next;
        }
        preNode.next = null;
        return head;
    }
    /**
     * 单指针，tmp与tmp.next 二者值相等时，tmp.next=tmp.next.next，不相等时，tmp指向下一个
     * */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            }
            else {
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static ListNode createList(int[] nums){
        if (nums.length < 1){
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        for (int i=1; i<nums.length; i++){
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static void printList(ListNode l1){
        while (l1 != null){
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }
}
