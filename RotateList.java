package Алгоритмы;

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if (head == null || head.next == null || k==0 || k % length==0){
            return head;
        }
        k = k%length;

        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}



