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
            self._s._last.next = None


    def pop(self) -> int:
        self._s._len -= 1
        if self._s._first != None:
            if self._s._first != self._s._last:
                val = self._s._first.val
                self._s._first = self._s._first.next
                return val
            else:
                val = self._s._first.val
                self._s._first = self._s._last = None
                return val
        else:
            return 0

    def peek(self) -> int:
        return self._s._first.val if self._s._first else 0

    def empty(self) -> bool:
        return self._s._len == 0