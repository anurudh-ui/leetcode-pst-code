class Solution:
    def middleNode(self, head):
        if head is None:
            return None
        temp = head
        cnt = 0
        while temp is not None:
            cnt += 1
            temp = temp.next        
        cnt = (cnt // 2) + 1
        temp = head
        while cnt > 1:
            temp = temp.next
            cnt -= 1
        return temp