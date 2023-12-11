############################################################
#  global function
###########################################################
def check(start, a, ans):
    if len(ans):
        assert len(ans) == 2
        red = set()  # Note set
        blue = set()
        n = len(a)
        for e in ans[0]:
            red.add(e)
        for e in ans[1]:
            blue.add(e)
        sn = len(red) + len(blue)
        assert n == sn
        RED = 1
        BLUE = 2
        i = start
        for alist in a:
            color = RED
            if i in blue:
                color = BLUE
            i = i + 1
            for e in alist:
                ecolor = RED
                if e in blue:
                    ecolor = BLUE
                assert color != ecolor


############################################################
#  Leetcode
# 785. Is Graph Bipartite?
# https://leetcode.com/problems/is-graph-bipartite/
###########################################################
class Solution:
    def isBipartite(self, graph) -> bool:
        n = 0
        directed = False
        start = 0
        ans = []  # list of list
        work = [0]
        show = False
        e = Exam(n, directed, start, graph, ans, work, show)
        check(start, graph, ans)
        if len(ans) == 0:
            return False
        return True

############################################################
#  PASTE TOUR CODE BELOW
#  https://leetcode.com/problems/is-graph-bipartite/
#  RUN
# ALL MUST PASS FOR 100
###########################################################
############################################################
############################################################
# Exam.py 
# 
###########################################################
from collections import deque

############################################################
#  All imports here
###########################################################
class Exam:
    def __init__(
        self,
        num: "int",
        d: "bool",
        start: "int",
        a: "list of list",
        ans: "list of list",
        work: "list of size 1",
        show: "bool",
    ):
        self._num = num
        self._dir = d
        self._start = start
        self._a = a
        self._ans = ans
        self._work = work
        self._show = show
        ## You can have your data structure here
        

        ## Nothing can be changed below
        if self._show:
            # CHANGE THIS. MUST post all pdf in Canavs as a ZIP file
            # DO NOT UPLOAD DOT FILES
            outputDir = "C:\\Users\\saatv\\OneDrive\\Documents\\Courses\Program Structures and Algo\\EndTerm\\s\\s\\"
            f = outputDir + str(self._num) + "in.dot"
            e = WriteDot(self._dir, self._start, self._a, f)
        self._alg()  # Everything happens in _alg
        if self._show:
            f = outputDir + str(self._num) + "out.dot"
            e = Write2Dot(self._dir, self._start, self._a, self._ans, f)

    ############################################################
    #  Write your code below
    ###########################################################

    
    def _alg(self) -> "None":
        print(self._a)
        n = len(self._a)
        ## boy = 1, girl = 0
        gender = {}  

        for self._start in range(n):
            self._work[0] += 1
            if self._start not in gender:
                gender[self._start] = 1
                queue = deque([self._start])

                while queue:
                    self._work[0] += 1

                    current_node = queue.popleft()

                    for neighbor in self._a[current_node]:
                        if neighbor not in gender:
                            gender[neighbor] = 1 - gender[current_node]
                            queue.append(neighbor)
                        elif gender[neighbor] == gender[current_node]:
                            return

        set_a = [node for node, c in gender.items() if c == 1]
        set_b = [node for node, c in gender.items() if c == 0]

        self._ans.append(set_a)
        self._ans.append(set_b)
        