class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        v = [float('inf')] * (amount + 1)
        k = [-1] * (amount + 1)

        v[0] = 0  

        for i in range(1, amount + 1):
            for coin in coins:
                if i >= coin and v[i - coin] + 1 < v[i]:
                    v[i] = v[i - coin] + 1
                    k[i] = coin

        if v[amount] == float('inf'):
            return -1  

        coins_used = []
        while amount > 0:
            coins_used.append(k[amount])
            amount -= k[amount]
        
        return len(coins_used)
