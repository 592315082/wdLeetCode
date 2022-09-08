package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class wdTest {
    public static void main (String[] args) {
        for (int i = 0; i < 5; ++i) {
            System.out.println(i);
        }



        Deque<String> stack = new LinkedList<String>();
        stack.push("11"); // offerFirst
        stack.push("22");
        stack.push("33");
        // 向队尾插入元素
        stack.offerLast("00");//offer
        // 向队头插入元素
        stack.offerFirst("44");
        // 查看队尾元素
        System.out.println(stack.peekLast());
        // 查看队头元素
        System.out.println(stack.peekFirst());  //peek
        // 移除队尾元素
        stack.pollLast();
        // 移除队头元素
        stack.pollFirst(); //poll

        System.out.println(stack.peek());
    }
}

