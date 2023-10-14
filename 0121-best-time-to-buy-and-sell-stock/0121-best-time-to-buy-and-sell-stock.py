############################################################
# Solution.py
# Author: Jagadeesh Vasudevamurthy
# Copyright: Jagadeesh Vasudevamurthy 2022
###########################################################
############################################################
# All imports
###########################################################
from typing import List


class Solution:
    def __init__(self):
        pass
        ## YoU can have what ever you want here
        

    ##LEETCODE INTERFACE.  DO NOT CHANGE
    ## YOU CANNOT CHANGE ANYTHING
    def maxProfit(self, prices: List[int]) -> int:
        if False:
            [sellday, buyday, work] = self.nsquare_time_constant_space(prices)
        if True:
            [sellday, buyday, work] = self.nlogn_time_logn_space(prices)
        if False:
            [sellday, buyday, work] = self.ntime_constant_space(prices)
        p = self._compute_profit(prices, sellday, buyday)
        return p

    #############################################
    # All public function here. 
    #############################################

    ########################################
    # TIME:THETA(N^2)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nsquare_time_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nsquare_time_constant_space(a) 


    ########################################
    # TIME:THETA(NlogN)
    # Space:THETA(logn)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nlogn_time_logn_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nlogn_time_logn_space(a)

    ########################################
    # TIME:THETA(N)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def ntime_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._ntime_constant_space(a)
        

    #############################################
    # All private function here. 
    # WRIYE CODE BELOW

    def _nsquare_time_constant_space(self, a: List[int]) -> List[int]:
        max_diff = 0;
        work = 0
        ans = [0, 0, 0]
        for i in range(0, len(a)):
            for j in range(i+1, len(a)):
                work +=1
                if (a[j] - a[i]) > max_diff:
                    max_diff = max(max_diff, a[j] - a[i]);
                    ans = j,i,work

        return ans

    def _nlogn_time_logn_space(self, a: List[int]) -> List[int]:
        def find_max(start, end, work):
            if start == end:
                work+= 1
                return [start, end, work, 0]
    
            mid = (start + end) // 2
    
            left_profit = find_max(start, mid, work)
            right_profit = find_max(mid + 1, end, work)    
            min_left = min(a[start:mid + 1])
            max_right = max(a[mid + 1:end + 1])
            cross_profit = max_right - min_left
            max_profit = max(left_profit[3], right_profit[3], cross_profit)
            
            if max_profit == left_profit[3]:
                return left_profit
            elif max_profit == right_profit[3]:
                return right_profit
            else:
                work += left_profit[2] + right_profit[2] + 1
                return [mid + 1 + a[mid + 1:end + 1].index(max_right), start + a[start:mid + 1].index(min_left), work, cross_profit]
        
        work = 0
        result = find_max(0, len(a) - 1, work)
        return result[:-1]
        
        
    def _ntime_constant_space(self, a: List[int]) -> List[int]:
        prof = 0
        min_val = a[0]
        work = 0
        ans = [0,0,0]
        for i in range(1, len(a)):
            work+=1
            min_val = min(min_val, a[i])
            if a[i] > min_val:
                if a[i]- min_val > prof:
                    prof = a[i] - min_val
                    ans = i,a.index(min_val), work 

        return ans
        

    # You can have any number of private functions and variables
    # NOTHING CAN BE CHABGED BELOW
    #############################################
    def _compute_profit(self, a: List[int], s: "int", b: "int") -> "int":
        n = len(a)
        if n == 0:
            return 0
        assert s >= 0 and s < n
        assert b >= 0 and b < n
        assert s >= b
        p = a[s] - a[b]
        return p
