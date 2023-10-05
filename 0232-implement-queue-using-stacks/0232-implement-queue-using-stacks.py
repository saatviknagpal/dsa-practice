
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


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()



############################################################
#  class  MyQueue
#232. Implement Queue using Stacks

# https://leetcode.com/problems/implement-queue-using-stacks/
########################################################### 
class MyQueue:
    def __init__(self):
        #NOTHING CAN BE CHANGED HERE
        self._s = Slist()

    def push(self, x: int) -> None:
        newNode = ListNode(x)
        self._s._len += 1
        if self._s._first != None:
            self._s._last.next = newNode 
            self._s._last = newNode
        else:
            self._s._first = self._s._last = newNode


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

    def peek(self) -> int:
        return self._s._first.val if self._s._first else 0

    def empty(self) -> bool:
        return self._s._len == 0

############################################################
#  MyCircularQueue
# 622. Design Circular Queue
# https://leetcode.com/problems/design-circular-queue/
########################################################### 

class MyCircularQueue:
    def __init__(self, k: int):
        self._K = k
        self._s = Slist()

    def enQueue(self, value: int) -> bool:
        if self._s._len < self._K:
            newNode = ListNode(value)
            if self._s._first is None:
                self._s._first = self._s._last = newNode
            else:
                self._s._last.next = newNode
                self._s._last = newNode
            self._s._last.next = self._s._first
            self._s._len += 1
            return True
        else:
            return False

    def deQueue(self) -> bool:
        if self._s._first is not None:
            self._s._len -= 1
            if self._s._first == self._s._last:
                self._s._first = self._s._last = None
            else:
                self._s._last.next = self._s._first.next
                self._s._first = self._s._first.next
            return True
        else:
            return False

    def Front(self) -> int:
        return self._s._first.val if not self.isEmpty() else -1

    def Rear(self) -> int:
        return self._s._last.val if not self.isEmpty() else -1

    def isEmpty(self) -> bool:
        return self._s._len == 0

    def isFull(self) -> bool:
        return self._s._len == self._K

############################################################
#  MyCircularDeque
#641. Design Circular Deque
#https://leetcode.com/problems/design-circular-deque

###########################################################  
class MyCircularDeque:
    def __init__(self, k: int):
        #NOTHING CAN BE CHANGED HERE
        self._K = k 
        self._s = Slist()

    def insertFront(self, value: int) -> bool:
        if self._s._len < self._K:
            newNode = ListNode(value)
            if self._s._first != None:
                newNode.next = self._s._first
                self._s._first = newNode
                self._s._last.next = self._s._first
            else:
                self._s._first = self._s._last = newNode
            
            self._s._len += 1
            return True
        else:
            return False

    def insertLast(self, value: int) -> bool:
        if self._s._len < self._K:
            newNode = ListNode(value)
            if self._s._last != None:
                self._s._last.next = newNode
                self._s._last = newNode
                self._s._last.next = self._s._first
            else:
                self._s._first = self._s._last = newNode
            
            self._s._len += 1
            return True
        else:
            return False

    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False
        else:
            if self._s._first == self._s._last:
                self._s._first = self._s._last = None
            else:
                self._s._first = self._s._first.next
                self._s._last.next = self._s._first
        self._s._len -= 1
        return True

    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False
        elif self._s._first == self._s._last:
            self._s._first = self._s._last = None
        else:
            current = self._s._first
            while current.next != self._s._last:
                current = current.next
            current.next = self._s._first
            self._s._last = current
        self._s._len -= 1
        return True

    def getFront(self) -> int:
        return self._s._first.val if not self.isEmpty() else -1

    def getRear(self) -> int:
        return self._s._last.val if not self.isEmpty() else -1

    def isEmpty(self) -> bool:
        return self._s._len == 0

    def isFull(self) -> bool:
        return self._s._len == self._K