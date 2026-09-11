# Contains Duplicate II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums` and an integer `k`, return `true`  *if there are two  **distinct indices*** `i` *and* `j` *in the array such that* `nums[i] == nums[j]` *and* `abs(i - j) <= k`.

 

 **Example 1:** 

```
Input: nums = [1,2,3,1], k = 3
Output: true

```

 **Example 2:** 

```
Input: nums = [1,0,1,1], k = 1
Output: true

```

 **Example 3:** 

```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109
- 0 <= k <= 105

## Solution

**Language:** Python  
**Runtime:** 61 ms (beats 16.41%)  
**Memory:** 36.1 MB (beats 75.89%)  
**Submitted:** 2026-09-11T06:00:45.154Z  

```py
from typing import List
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        window_set = set()
        for i in range(len(nums)):
            if i > k:
                window_set.remove(nums[i - k - 1])
            if nums[i] in window_set:
                return True          
            window_set.add(nums[i])
        return False
```

---

[View on LeetCode](https://leetcode.com/problems/contains-duplicate-ii/)