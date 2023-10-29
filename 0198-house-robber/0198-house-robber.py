############################################################
# Exam.py 
# 
###########################################################

############################################################
#  All imports here
###########################################################

############################################################
#  class  Alg
###########################################################    
class Alg():
    def __init__(self,a:'python list',ans:'python list',maxv:'list of size 1',work:'list of size 1',show:'bool'):
        self._a = a
        self._ans = ans
        self._maxv = maxv
        self._work = work
        self._show = show
        ## You can have your data structure here
        
        ## Nothing can be changed below
        self._exam() #Everything happens in _exam
        check_result(self._a,self._ans,self._maxv[0]) #your answer is checked here

    ############################################################
    #          Nothing can be changed in _exam
    ########################################################### 
    def _exam(self):
        self._alg()
        check_result(self._a,self._ans,self._maxv[0]) #your answer is checked here

    ############################################################
    #          WRITE CODE BELOW
    #  Populate self._maxv and self._work 
    #  if self._show is True, show steps of the algorithm
    ########################################################### 
    def _alg(self):
        if self._show:
            print("Input:", self._a)

        n = len(self._a)
        
        self._work[0] = 0

        dp = [0] * (n + 1)

        for i in range(1, n + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + self._a[i - 1])
            self._work[0] += 1
        
        self._maxv[0] = dp[n]

        i = n
        while i >= 1:
            if i == 1:
                self._ans.append(0)
                break
            if dp[i] == dp[i - 1]:
                i -= 1
            else:
                self._ans.append(i - 1)
                i -= 2

        self._ans = self._ans[::-1]  # Reverse the list to get the correct order


        if self._show:
            print("DP:", dp)
            print("Houses robbed:", self._ans)
            print("Max value:", self._maxv[0])
            print("Work:", self._work[0])
        
        

############################################################
#  NOTHING CAN BE CHANGED BELOW
###########################################################  

############################################################
#  class  Solution
# Nothing can be changed in Solution
###########################################################    
class Solution():
    def rob(self, nums:'Python list') -> 'int':
        #Nothing can be changedhere
        ans = []
        maxv = [0]
        work = [0]
        t = Alg(nums,ans,maxv,work,False)
        check_result(nums,ans,maxv[0])
        return maxv[0]

############################################################
# Nothing can be changed in check_result
# Note check_result is a global hanging function
###########################################################  
def check_result(a:'Python list',ans:'Python List',amax:'int'):
    x = sorted(ans)
    t = 0
    print(x)
    for e in x:
        t = t + a[e]
    assert(t == amax)
    # assert you did not break the rule
    lx = len(x)
    for i in range(0,lx-1,2):
        pos1 = x[i]
        pos2 = x[i +1]
        assert(pos2 >= (pos1+1))
 