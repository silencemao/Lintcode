package main.java;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leetcode_2_addTwoNumbers {
    public static void main(String[] args){
        int[] num1 = {1, 8};
        int[] num2 = {0};
        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

//        addTwoNumbers(l1, l2);
        printList(l1);
        printList(l2);
        printList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carry = 0;
        while (l1 != null && l2 != null){
            int tmp = l1.val + l2.val + carry;
            dummy.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int tmp = l1.val + carry;
            dummy.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int tmp = l2.val + carry;
            dummy.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            dummy = dummy.next;
            l2 = l2.next;
        }

        if (carry != 0){
            dummy.next = new ListNode(carry);
        }
        return res.next;
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

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
