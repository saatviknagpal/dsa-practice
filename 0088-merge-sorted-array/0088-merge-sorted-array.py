class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        
        res = nums1[:m]
        i = 0
        j = 0
        
        while i < m or j < n:
            if i == m:
                nums1[i + j] = nums2[j]
                j += 1
            elif j == n:
                nums1[i + j] = res[i]
                i += 1
            else:
                if res[i] < nums2[j]:
                    nums1[i + j] = res[i]
                    i += 1
                else:
                    nums1[i + j] = nums2[j]
                    j += 1       


            
        
        

