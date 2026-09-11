# Middle of the Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `head` of a singly linked list, return  *the middle node of the linked list*.

If there are two middle nodes, return  **the second middle**  node.

 

 **Example 1:** 

```
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

```

 **Example 2:** 

```
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 100].
- 1 <= Node.val <= 100

## Solution

**Language:** Python  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 19.4 MB (beats 20.15%)  
**Submitted:** 2026-09-11T06:12:44.820Z  

```py
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
```

---

[View on LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/)