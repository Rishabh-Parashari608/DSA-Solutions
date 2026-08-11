class Solution(object):
    def findDisappearedNumbers(self, nums):
        arr = []
        s = set(nums)
        for i in range(1,len(nums)+1):
            if i not in s:
                arr.append(i)
        return arr
                               