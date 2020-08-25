Given an array nums of n integers, 
are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

Constraints:

```
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
```

#### idea

```
for(int i=0;i<nums.length;i++){    
}
target + nums[i]构成一个新的target，然后在剩下的nums array里面寻找，一直到nums.length == 0
[0,1,2,3,4] target
```
