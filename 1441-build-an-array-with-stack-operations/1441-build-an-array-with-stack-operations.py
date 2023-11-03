class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        i = 0
        j = 1
        ls = []
        
        while(i < (len(target)) and j <= n):
            if target[i] == j:
                ls.append("Push")
                i+=1
                j+=1
            else:
                ls.append("Push")
                ls.append("Pop")
                j+=1
                
            
        return ls