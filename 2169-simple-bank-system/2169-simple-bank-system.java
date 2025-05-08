class Bank {
    long[] arr;

    public Bank(long[] balance) {
        arr = new long[balance.length];
        for (int i = 0; i < balance.length; i++) {
            arr[i] = balance[i];
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > arr.length || account2 > arr.length)
            return false;

        if (money <= arr[account1 - 1]) {
            arr[account1 - 1] -= money;
            arr[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account > arr.length)
            return false;

        arr[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > arr.length)
            return false;
        if (arr[account - 1] < money)
            return false;

        arr[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */