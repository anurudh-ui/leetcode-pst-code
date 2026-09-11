# Reverse String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with `O(1)` extra memory.

 

 **Example 1:** 

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

```

 **Example 2:** 

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is a printable ascii character.

## Solution

**Language:** Python  
**Runtime:** 3 ms (beats 44.95%)  
**Memory:** 23.3 MB (beats 80.76%)  
**Submitted:** 2026-09-11T06:14:17.828Z  

```py
class Solution:
    def reverseString(self, s):
        start = 0
        end = len(s) - 1
        while start <= end:
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-string/)