package leetcode;

public class Solution_2043 {

    public static class Bank {

        private long[] mBalance;

        public Bank(long[] balance) {
            mBalance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!accountValid(account1) || !accountValid(account2)) {
                return false;
            }
            int realAccount1 = account1 - 1;
            int realAccount2 = account2 - 1;
            if (mBalance[realAccount1] < money) {
                return false;
            }
            mBalance[realAccount1] -= money;
            mBalance[realAccount2] += money;
            return true;
        }

        private boolean accountValid(int account) {
            return account > 0 && account <= mBalance.length;
        }

        public boolean deposit(int account, long money) {
            if (!accountValid(account)) {
                return false;
            }
            int realAccount = account - 1;
            mBalance[realAccount] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {

            if (!accountValid(account)) {
                return false;
            }
            int realAccount = account - 1;
            if (mBalance[realAccount] < money) {
                return false;
            }
            mBalance[realAccount] -= money;
            return true;
        }
    }
}
