from typing import List


# My solution
def twoSum(nums: List[int], target: int) -> List[int]:
    arrayLen = len(nums)
    for x in range(arrayLen):
        for y in range(x+1,arrayLen):
            if (nums[x] + nums[y]) == target:
                return x, y


# Solution 1
def twoSum1(nums: List[int], target: int) -> List[int]:
    flag = 0
    i = 0
    while flag == 0:
        item = target - nums[i]
        if (item in nums) and (nums.index(item) != i):
            j = nums.index(item)
            flag = 1
        else:
            i += 1
    return (i,j)

print(twoSum1([2, 4, 7, 9], 9))
