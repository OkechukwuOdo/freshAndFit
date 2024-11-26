package com.tripleOtech.freshAndFit.entity;



public class Wallet {
    private Long id;
    private Long balance;
    private AppUser customer;
    private List<AppUserTransaction> transactionList;
}
