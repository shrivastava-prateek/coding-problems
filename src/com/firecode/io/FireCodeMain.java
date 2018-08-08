package com.firecode.io;


public class FireCodeMain {

	public static void main(String[] args) {
	
		ListNode<Integer> n1 = new ListNode<>(1);
		ListNode<Integer> n2 = new ListNode<>(2);
		ListNode<Integer> n3 = new ListNode<>(3);
		ListNode<Integer> n4 = new ListNode<>(4);
		ListNode<Integer> n5 = new ListNode<>(5);
		ListNode<Integer> n6 = new ListNode<>(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		ListNode<Integer> temp = n1;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
		
		System.out.println(" Reversing List" );
		FireCodeMain obj = new FireCodeMain();
        temp =  obj.reverseLinkedList(n1);
       
		 while(temp != null) {
				System.out.println(temp);
				temp = temp.next;
			}
	}
	
	
	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}
		T value;
		ListNode<T> next;
		@Override
		public String toString() {
			return "ListNode [value=" + value + ", nextValue=" + (next!=null?next.value:"null") + "]";
		}
		
	}
	
	
	ListNode<Integer> reverseLinkedList(ListNode<Integer> head) {
		
		ListNode<Integer> current = head;
		ListNode<Integer> previous = null;
		ListNode<Integer> temp = null;
		
		while(current != null) {
			if(previous != null) {
				temp = current.next;
				current.next = previous;
				previous = current;
				current = temp;
				if(temp != null) head = temp;
			}
			else {
				previous = current;
				current = current.next;
				previous.next = null;
			}
		}
		
		return head;
		
	}

}
