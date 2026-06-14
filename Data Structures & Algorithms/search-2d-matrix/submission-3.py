class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        def search(array,target):

            left = 0
            right = len(array)-1

            while left <= right:

                middle = left + (right-left) // 2

                if array[middle] == target:
                    return True

                elif array[middle] < target:
                    left = middle + 1
                elif array[middle] > target:
                    right = middle - 1

        for i in range(len(matrix)):
            val = search(matrix[i],target)
            if val == True:
                return True
        return False


        