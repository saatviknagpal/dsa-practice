class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        c = 1
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] + c == 10:
                digits[i] = 0
                c = 1
            else:
                digits[i] += 1
                c = 0
                break

        if c == 1:
            digits.insert(0, 1)

        return digits