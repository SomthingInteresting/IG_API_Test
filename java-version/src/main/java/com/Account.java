package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    
    private String accountType;
    
    @JsonProperty("currentAccountId")
    private String accountId;
    
    private AccountInfo accountInfo;
    
    // Other fields ...

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    // Other getters and setters ...
}

class AccountInfo {
    
    private double balance;
    // Other fields...

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // Other getters and setters...
}
