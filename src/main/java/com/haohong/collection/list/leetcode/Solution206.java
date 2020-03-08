package com.haohong.collection.list.leetcode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {
    public static void main(String[] args) {

        System.out.println("hello");
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = newHead;
            newHead = current;
        }

        return newHead;
    }
}
