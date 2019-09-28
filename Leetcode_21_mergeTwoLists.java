package main.java;

public class Leetcode_21_mergeTwoLists {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5};
        int[] nums2 = {1, 3, 4, 6, 7};
        ListNode l1 = generateList(nums1);
        ListNode l2 = generateList(nums2);
        ListNode mergeHead = mergeTwoLists(l1, l2);
        printList(mergeHead);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }

        return head.next;
    }

    public static ListNode generateList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        for (int i = 1; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static void printList(ListNode l1) {
        ListNode tmp = l1;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}
