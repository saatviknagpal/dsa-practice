#  Write code in this file
# Post this file in Canvas
# Cut and paste the whole file in Leetcode and run. All tests must pass
# Note that you should do 4 times in 225, 235,622 and 641
# TA will run this file 4 times in 225, 235,622 and 641
# All tests must pass for 100
########################################################### 

class ListNode:
    #NOTHING CAN BE CHANGED HERE
    def __init__(self, val = 0, next= None):
        self.val = val
        self.next = next
         
            
############################################################
#  class  Slist
###########################################################   
class Slist():
    def __init__(self):
        #NOTHING CAN BE CHANGED HERE
        self._first = None
        self._last = None
        self._len = 0 
    
        
        
    #############################
    # WRITE All public functions BELOW
    # YOU CAN HAVE ANY NUMBER OF PRIVATE FUNCTIONS YOU WANT
    #############################
############################################################
#  class  MyStack
#225. Implement Stack using Queues

#https://leetcode.com/problems/implement-stack-using-queues
########################################################### 
class MyStack:
    def __init__(self):
        #NOTHING CAN BE CHANGED HERE
        self._s = Slist()

    def push(self, x: int) -> None:
        newNode = ListNode(x)
        if self._s._last != None:
            newNode.next = self._s._first
            self._s._first = newNode
        else:
            self._s._first = self._s._last = newNode
            self._s._last.next = None
            
    def pop(self) -> int:
        if self._s._first:
            if self._s._first != self._s._last:
                val = self._s._first.val
                self._s._first = self._s._first.next
                return val
            else:
                val = self._s._first.val
                self._s._first = self._s._last = None
                return val
        else:
            return None

    def top(self) -> int:
        if self._s._first:
            val = self._s._first.val
            return val
        else:
            return None
        
    def empty(self) -> bool:
        return not self._s._last


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()