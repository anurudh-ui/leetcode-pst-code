class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        temp = head
        cnt = 0
        while cnt < k:
            if temp is None:
                return head
            temp = temp.next
            cnt += 1
        prevNode = self.reverseKGroup(temp, k)
        temp = head
        cnt = 0
        while cnt < k:
            nxt = temp.next
            temp.next = prevNode
            prevNode = temp
            temp = nxt
            cnt += 1
        return prevNode