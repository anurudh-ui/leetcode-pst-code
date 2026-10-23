# Majority Element

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array `nums` of size `n`, return  *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

 

 **Example 1:** 

```
Input: nums = [3,2,3]
Output: 3

```

 **Example 2:** 

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2

```

 

 **Constraints:** 

- n == nums.length
- 1 <= n <= 5 * 104
- -109 <= nums[i] <= 109
- The input is generated such that a majority element will exist in the array.

 

 **Follow-up:**  Could you solve the problem in linear time and in `O(1)` space?

## Solution

**Language:** Python  
**Runtime:** 10 ms (beats 57.40%)  
**Memory:** 21.5 MB (beats 60.31%)  
**Submitted:** 2026-10-23T09:38:59.552Z  

```py
class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        element = None
        count = 0
        for num in nums:
            if count == 0:
                element = num  
            count += (1 if num == element else -1 )
        return element

        
```

---

[View on LeetCode](https://leetcode.com/problems/majority-element/)