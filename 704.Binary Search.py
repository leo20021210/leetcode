class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        start=0
        end=len(nums)-1
        while end-start>=0:
            mid=(start+end)/2
            if nums[mid]==target:
                return mid
            if nums[mid]<target:
                start=mid+1
            else:
                end=mid-1
        return -1
