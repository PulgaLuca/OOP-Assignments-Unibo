package main.java.it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

public abstract class AbstractBankAccount implements BankAccount{
    
    public static final double ATM_TRANS_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    private final AccountHolder holder;
    private double balance;
    private int transactions;

    public AbstractBankAccount(final AccountHolder accountHolder, final double balance, final int transactions){
        this.balance = balance;
        this.holder = accountHolder;
        this.transactions = transactions; 
    }

    protected abstract boolean isWithDrawAllowed(double amount);
    protected abstract double computeFees();

    protected boolean checkUser(final int accountHolder){
        return this.holder.getUserID() == accountHolder;
    }

    protected final void resetTransactions() {
        this.transactions = 0;
    }

    protected final void incrementTransactions() {
        this.transactions++;
    }

    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    public void chargeManagementFees(final int id){
        final double feeAmount = computeFees();
        if(checkUser(id) && isWithDrawAllowed(feeAmount)){
            balance = balance - feeAmount;
            resetTransactions();
        }
    }

    public void deposit(int id, double amount){
        this.transactionOp(usrID, amount);
    }

    public void depositFromATM(int id, double amount){
        this.deposit(usrID, amount - ATM_TRANSACTION_FEE);
    }
    
    @override
    public AccountHolder getAccountHolder(){
        return holder;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getTransactionsCount(){
        return this.transactions;
    }

    public void withdraw(int id, double amount){
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }

    public void withdrawFromATM(int id, double amount){
        this.withdraw(usrID, amount + ATM_TRANSACTION_FEE);
    }
}
