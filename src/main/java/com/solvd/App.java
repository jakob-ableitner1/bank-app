package com.solvd;

import com.solvd.account.Account;
import com.solvd.account.CheckingAccount;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;
import com.solvd.menu.*;
import com.solvd.profile.MemberProfile;
import com.solvd.profile.Profile;
import com.solvd.transaction.AccountMoneyTransfer;
import com.solvd.transaction.Transaction;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    static IMenu startMenu = new StartMenu();
    static IMenu startMemberMenu = new StartMemberMenu();
    static IMenu signInMenu = new SignInMenu();
    static IMenu memberMenu = new MemberMenu();

    public static void main(String[] args){

        //Prepopulate data
        MemberProfile member1 = new MemberProfile("Jakob Ableitner", "jableitn", "pw");
        Account checkingAccount = new CheckingAccount(123, BigDecimal.valueOf(500));
        Account savingsAccount =  new SavingsAccount(111, BigDecimal.valueOf(1400));
        member1.setAccounts(new Account[]{checkingAccount, savingsAccount});
        member1.setAddress(new Address("Jakob's street", "CA", "San Diego", 33032, "USA"));

        MemberProfile member2 = new MemberProfile("Tim Smith", "tsmith", "timspw");
        MemberProfile member3 = new MemberProfile("Bob Cook", "bcook", "bobspw");
        MemberProfile[] members = {member1, member2, member3};

        boolean exitMenu = false;
        while (!exitMenu){
            int input = Integer.parseInt(startMenu.getInput()[0]);
            switch (input){
                case 0:
                    memberSignInMenu(members);
                    continue;
                case 1:
                    memberSignInMenu(members);
                case 2:
                    exitMenu = true;
                    continue;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void memberSignInMenu(MemberProfile[] members){

        boolean hasTerminatedMenu = false;

        while (!hasTerminatedMenu){
            int input = Integer.parseInt(startMemberMenu.getInput()[0]);
            switch (input){
                case 0:
                    String username = signInMenu.getInput()[0];
                    String password = signInMenu.getInput()[1];
                    MemberProfile member = findMember(members, username, password);

                    if(member != null){
                        System.out.println("Hello " + member.getName());
                        memberMenu(member);
                    } else{
                        System.out.println("username or password is incorrect");
                    }
                    continue;
                case 1:
                    hasTerminatedMenu = true;
                    continue;
                default:
                    System.out.println("Input not valid. Please try again");
            }
        }
    }

    public static MemberProfile findMember(MemberProfile[] members, String username, String password) {
        for (MemberProfile member : members) {
            if (username.equals(member.getId()) && password.equals(member.getPassword())){
                return member;
            }
        }
        return null;
    }

    public static void memberMenu(MemberProfile member){

        boolean loggedIn = true;

        while (loggedIn){
            int input = Integer.parseInt(memberMenu.getInput()[0]);

            switch(input){
                case 0:
                    changeAddress(member);
                    continue;
                case 1:
                    System.out.println(member.toString());
                    continue;
                case 2:
                    System.out.println(Arrays.toString(member.getAccounts()));
                    continue;
                case 3:
                    transferMoney(member);
                    continue;
                case 4:
                    loggedIn = false;
                    continue;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    public static void changeAddress(Profile profile){
        IMenu changeAddressMenu = new ChangeAddressMenu();
        String[] addressValues = changeAddressMenu.getInput();
        profile.setAddress(new Address(addressValues[0], addressValues[1], addressValues[2], Integer.parseInt(addressValues[3]),addressValues[4]));
    }

    public static void transferMoney(MemberProfile member){
        Account[] accounts = member.getAccounts();
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i] != null){
                System.out.println("Account: " + accounts[i].toString() + ", Balance: " + accounts[i].getBalance() + " - option " + i);
            }
        }

        IMenu transferMoneyMenu = new TransferMoneyMenu();
        String[] moneyTransferValues = transferMoneyMenu.getInput();

        Transaction accountMoneyTransfer = new AccountMoneyTransfer(accounts[Integer.parseInt(moneyTransferValues[0])], accounts[Integer.parseInt(moneyTransferValues[1])], BigDecimal.valueOf(Double.parseDouble(moneyTransferValues[2])));
        accountMoneyTransfer.performTransaction();
    }
}