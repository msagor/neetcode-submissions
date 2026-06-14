class Solution:
    def findMin(self, nums: List[int]) -> int:

        def binarySearch(left,right):
            
            nonlocal nums

            while left < right:
                middle = left + (right - left) // 2
                
                if nums[middle] > nums[right]:
                    left = middle + 1
                else:

                    right = middle
            
            return nums[left]
                

        val = binarySearch(0,len(nums)-1)
        return val

        