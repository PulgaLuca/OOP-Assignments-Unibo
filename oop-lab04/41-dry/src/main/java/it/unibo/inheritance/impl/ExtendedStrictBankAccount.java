package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
    
    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(final int usrID, final double balance){
        super(usrID, balance);
    }

    protected boolean isWithdrawAllowed(final double amount){
        return getBalance() >= amount;
    }

    public void withdraw(final int usrID, final double amount){
        if(isWithdrawAllowed(amount)){
            super.withdraw(usrID, amount);
        }
    }

    public void chargeManagementFees(final int usrID){
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if(checkUser(usrID) && isWithdrawAllowed(feeAmount)){
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }
}
