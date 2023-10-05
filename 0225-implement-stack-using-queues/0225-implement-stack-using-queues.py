
############################################################
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
        self._s._len += 1
        if self._s._last != None:
            newNode.next = self._s._first
            self._s._first = newNode
        else:
            self._s._first = self._s._last = newNode
            self._s._last.next = None
            
    def pop(self) -> int:
        self._s._len -= 1
        if self._s._first != None:
            val = self._s._first.val
            if self._s._first != self._s._last:
                self._s._first = self._s._first.next
            else:
                self._s._first = self._s._last = None
            return val
        else:
            return 0

    def top(self) -> int:
        return self._s._first.val if self._s._first else 0

    def empty(self) -> bool:
        return self._s._len == 0