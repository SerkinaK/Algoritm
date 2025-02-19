package Алгоритмы;

class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iterator = head;
        if (iterator == null){
            return iterator;
        }
        while (iterator.next!= null){
            if (iterator.val == iterator.next.val){
                iterator.next = iterator.next.next;
            }else{
                iterator = iterator.next;
            }
        }
        return head;
    }
}


