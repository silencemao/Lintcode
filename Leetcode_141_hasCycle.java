package main.java;

/**
 * 链表是否有环
 * */
public class Leetcode_141_hasCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker==runner) {
                return true;
            }
        }
        return false;

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
