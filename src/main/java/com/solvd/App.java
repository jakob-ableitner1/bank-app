package com.solvd;

import com.solvd.account.Account;
import com.solvd.account.CheckingAccount;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;
import com.solvd.profile.MemberProfile;
import com.solvd.transaction.AccountMoneyTransfer;
import com.solvd.transaction.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        //Prepopulate data
        MemberProfile member1 = new MemberProfile("Jakob Ableitner", "jableitn", "pw");
        Account checkingAccount = new CheckingAccount(123, member1, BigDecimal.valueOf(500));
        Account savingsAccount =  new SavingsAccount(111, member1, BigDecimal.valueOf(1400));
        member1.setAccounts(new Account[]{checkingAccount, savingsAccount});
        member1.setAddress(new Address("Jakob's street", "CA", "San Diego", 33032, "USA"));

        MemberProfile member2 = new MemberProfile("Tim Smith", "tsmith", "timspw");
        MemberProfile member3 = new MemberProfile("Bob Cook", "bcook", "bobspw");
        MemberProfile[] members = {member1, member2, member3};

        boolean hasTerminitedApp = false;

        while (!hasTerminitedApp)  {

            System.out.println("Bank Member - option 0\nEmployee. Not implemented yet. - option 1\nQuit - option 2");
//            System.out.println("Employee. Not implemented yet. - option 1");
//            System.out.println("Quit - option 2");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 0:
                    memberSignInMenu(members);
                    continue;
//                case 1:
//                    employeeMenu();
                case 2:
                    hasTerminitedApp = true;
                    System.out.println("Leaving application. Goodbye");
                    continue;
                default:
                    System.out.println("This input is unvalid");
            }
        }
    }

    public static void memberSignInMenu(com.solvd.profile.MemberProfile[] members){
        boolean hasTerminatedMenu = false;

        while (!hasTerminatedMenu){
            System.out.println("Current Member - option 0\nQuit - option 1");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 0:
                    System.out.println("enter username");
                    String username = scanner.nextLine();
                    System.out.println("enter password");
                    String password = scanner.nextLine();
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
            System.out.println("Change Address - option 0\nView Profile Details - option 1\nView Account Details - option 2\nTransfer Money - option 3\nLog Out - option 4");
            int input = scanner.nextInt();
            scanner.nextLine();

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

    public static void changeAddress(MemberProfile member){
        System.out.println("Enter the values for the following fields and press the enter button after each value: Street Line, State, City, Zip Code, Country");
        String streetLine = scanner.nextLine();
        String state = scanner.nextLine();
        String city = scanner.nextLine();
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        String country = scanner.nextLine();
        member.setAddress(new Address(streetLine, state, city, zipCode,country));
    }

    public static void transferMoney(MemberProfile member){
        Account[] accounts = member.getAccounts();
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i] != null){
                System.out.println("Account: " + accounts[i].toString() + ", Balance: " + accounts[i].getBalance() + " - option " + i);
            }
        }
        System.out.println("Which account would you like to transfer from?");
        int fromAccountIndex = scanner.nextInt();
        System.out.println("Which account would you like to transfer to?");
        int toAccountIndex = scanner.nextInt();
        System.out.println("How much money would you like to transfer?");
        BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());

        Transaction accountMoneyTransfer = new AccountMoneyTransfer(accounts[fromAccountIndex], accounts[toAccountIndex], amount);
        accountMoneyTransfer.performTransaction();
    }
}