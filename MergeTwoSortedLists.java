package Алгоритмы;

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode resultList = new ListNode();
        ListNode iterator = resultList;


        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val <= list2.val)) {
                iterator.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if(list2 != null) {
                iterator.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            iterator = iterator.next;
        }
        return resultList.next;
    }
}

