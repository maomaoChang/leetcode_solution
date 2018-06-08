/*
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {

	//结点定义
    public class ListNode {
     	int val;
     	ListNode next;
      	ListNode(int x) { val = x; }
 	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		ListNode p = new ListNode(0);		
		p.next = null; 	//定义p为空链表，并用于循环迭代	
		ListNode k = p;	//k指向最终返回的链表

		
		ListNode p1=l1, p2=l2;
		int temp = 0, increment=0; //increment,当前进位,为0或者1
		
		//只要p1和p2有一个未至末尾,则一直求和
		while(p1 != null || p2 != null){
			
			if(p1 == null && p2 != null){
				temp = p2.val + increment;
				p2 = p2.next;
			}
			else if (p1 != null && p2 == null){
				temp = p1.val + increment;
				p1 = p1.next;
			}
			else{
				temp = p1.val + p2.val + increment;	
				p1 = p1.next;
			    p2 = p2.next;	
			}
			p.val = temp % 10;
			increment = temp / 10;
			
			p.next = new ListNode(increment); //定义高一位求和时的存放结点
			
			if(p1 != null || p2 != null || increment != 0){ //未加完，p向后移位
				p = p.next;	//仍有更高一位，注意次高位出现相加为10的情况			
			}
			
		}
		p.next = null; //结束循环,指定p为尾结点
		return k;	
		
    }
}