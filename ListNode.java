/*
Add two numbers(Linked List)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry= 0;
        while(l1!=null || l2!=null){
            int sum = carry;
            if(l1!=null){
                sum+= l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode new_node = new ListNode(sum%10);
            carry = sum/10;
            
            if(temp == null){
                temp = head = new_node;
            }
            else{
                temp.next = new_node;
                temp = temp.next;
            }     
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return head;
    }
}