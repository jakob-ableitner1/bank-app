package com.solvd.bankapp;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.account.CheckingAccount;
import com.solvd.bankapp.account.SavingsAccount;
import com.solvd.bankapp.exception.NegativeAgeException;
import com.solvd.bankapp.location.Address;
import com.solvd.bankapp.menu.*;
import com.solvd.bankapp.profile.MemberProfile;
import com.solvd.bankapp.profile.Profile;
import com.solvd.bankapp.search.AccountSearch;
import com.solvd.bankapp.search.ProfileSearch;
import com.solvd.bankapp.transaction.AccountMoneyTransfer;
import com.solvd.bankapp.transaction.Transaction;
import com.solvd.bankapp.util.PrepopulateData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private static final ProfileSearch profileSearch = new ProfileSearch();
    static IMenu startMenu = new StartMenu();
    static IMenu startMemberMenu = new StartMemberMenu();
    static IMenu signInMenu = new SignInMenu();
    static IMenu memberMenu = new MemberMenu();

    public static void main(String[] args) {

        Set<Profile> profiles = PrepopulateData.prepopulateProfiles();

        boolean exitMenu = false;
        while (!exitMenu) {
            int input = Integer.parseInt(startMenu.getInput()[0]);
            switch (input) {
                case 0:
                    memberSignInMenu(profiles);
                    continue;
                case 1:
                    exitMenu = true;
                    continue;
                default:
                    LOGGER.info("Invalid input");
            }
        }
    }

    public static void memberSignInMenu(Set<Profile> profiles) {

        boolean hasTerminatedMenu = false;

        while (!hasTerminatedMenu) {
            int input = Integer.parseInt(startMemberMenu.getInput()[0]);
            switch (input) {
                case 0:
                    String[] credentials = signInMenu.getInput();
                    String username = credentials[0];
                    String password = credentials[1];
                    Profile profile = profileSearch.search(profiles, new String[]{username, password}, "validation")[0];

                    if (profile != null) {
                        LOGGER.info("Hello " + profile.getName());
//                        memberMenu(profile);
                    } else {
                        LOGGER.info("username or password is incorrect");
                    }
                    continue;
                case 1:
                    createMemberProfile(profiles);
                    continue;
                case 2:
                    hasTerminatedMenu = true;
                default:
                    LOGGER.info("Input not valid. Please try again");
            }
        }
    }

    public static MemberProfile findMember(MemberProfile[] members, String username, String password) {
        for (MemberProfile member : members) {
            if (username.equals(member.getId()) && password.equals(member.getPassword())) {
                return member;
            }
        }
        return null;
    }

    public static void memberMenu(MemberProfile member) {

        boolean loggedIn = true;

        while (loggedIn) {
            int input = Integer.parseInt(memberMenu.getInput()[0]);

            switch (input) {
                case 0:
                    changeAddress(member);
                    continue;
                case 1:
                    LOGGER.info(member.toString());
                    continue;
                case 2:
                    LOGGER.info(member.getAccounts());
                    continue;
                case 3:
                    transferMoney(member);
                    continue;
                case 4:
                    loggedIn = false;
                    continue;
                default:
                    LOGGER.info("Invalid input. Try again.");
            }
        }
    }

    public static void changeAddress(Profile profile) {
        IMenu changeAddressMenu = new ChangeAddressMenu();
        String[] addressValues = changeAddressMenu.getInput();
        profile.setAddress(new Address(addressValues[0], addressValues[1], addressValues[2], Integer.parseInt(addressValues[3]), addressValues[4]));
    }

    public static void transferMoney(MemberProfile member) {
        Set<Account> accounts = member.getAccounts();
        int optionCount = 0;
        for (Account account : accounts) {
            if (account != null) {
                LOGGER.info("Account: " + account + ", Balance: " + account.getBalance() + " - option " + optionCount);
                optionCount++;
            }
        }

        IMenu transferMoneyMenu = new TransferMoneyMenu();
        String[] moneyTransferValues = transferMoneyMenu.getInput();

        AccountSearch accountSearch = new AccountSearch();
        Account[] fromAccount = accountSearch.search(accounts, new String[]{moneyTransferValues[0]}, "id");
        Account[] toAccount = accountSearch.search(accounts, new String[]{moneyTransferValues[1]}, "id");

        Transaction accountMoneyTransfer = new AccountMoneyTransfer(fromAccount[0], toAccount[0], BigDecimal.valueOf(Double.parseDouble(moneyTransferValues[2])));
        accountMoneyTransfer.performTransaction();
    }

    public static void createMemberProfile(Set<Profile> profiles) {
        IMenu createMemberProfileMenu = new CreateMemberProfileMenu();
        IMenu changeAddressMenu = new ChangeAddressMenu();

        String[] input = createMemberProfileMenu.getInput();
        String[] addressInput = changeAddressMenu.getInput();

        Address address = new Address(addressInput[0], addressInput[1], addressInput[2], Integer.parseInt(addressInput[3]), addressInput[4]);

        try {
            profiles.add(new MemberProfile(input[0], input[1], input[2], Integer.parseInt(input[3]), address));
        } catch (NegativeAgeException e) {
            LOGGER.info("Age can't be negative");
        }
    }
}



