package com.solvd.bankapp;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.NegativeAgeException;
import com.solvd.bankapp.exception.ProfileNotFoundException;
import com.solvd.bankapp.location.Address;
import com.solvd.bankapp.location.State;
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
import java.util.*;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private static final ProfileSearch profileSearch = new ProfileSearch();
    static IMenu startMenu = new StartMenu();
    static IMenu memberMenu = new MemberMenu();

    public static void main(String[] args) {
        Set<Profile> profiles = PrepopulateData.prepopulateProfiles();
        Scanner scanner = new Scanner(System.in);

        IMenu startMenuLambda = (lambdaScanner) -> {
            LOGGER.info("Log In - option 0\nMember Sign Up - option 1\nQuit - option 2");
            String input = lambdaScanner.nextLine();
            return new String[]{input};
        };

        IMenu signInMenuLambda = (lambdaScanner) -> {
            LOGGER.info("enter username");
            String username = lambdaScanner.nextLine();
            LOGGER.info("enter password");
            String password = lambdaScanner.nextLine();
            return new String[]{username, password};
        };

        startMenu(profiles, scanner, startMenuLambda, signInMenuLambda);
        scanner.close();
    }

    public static void startMenu(Set<Profile> profiles, Scanner scanner, IMenu startMenu, IMenu signInMenu) {

        boolean hasTerminatedMenu = false;

        while (!hasTerminatedMenu) {
            int input = Integer.parseInt(startMenu.getInput(scanner)[0]);
            switch (input) {
                case 0:
                    String[] credentials = signInMenu.getInput(scanner);
                    String username = credentials[0];
                    String password = credentials[1];
                    Profile profile = null;

                    try{
                        profile = profileSearch.search(profiles, username, "validation");
                        if (password.equals(profile.getPassword())) {
                            LOGGER.info("Hello " + profile.getName());
                            if (profile instanceof MemberProfile){
                                memberMenu((MemberProfile) profile, scanner);
                            }
                        } else {
                            LOGGER.info("Password is incorrect");
                        }
                    } catch (ProfileNotFoundException e){
                        LOGGER.info("Profile not found with username " + username);
                    }
                    continue;
                case 1:
                    createMemberProfile(profiles, scanner);
                    continue;
                case 2:
                    hasTerminatedMenu = true;
                    LOGGER.info("Closing application");
                    continue;
                default:
                    LOGGER.info("Input not valid. Please try again");
            }
        }
    }

    public static void memberMenu(MemberProfile member, Scanner scanner) {

        boolean loggedIn = true;

        while (loggedIn) {
            int input = Integer.parseInt(memberMenu.getInput(scanner)[0]);

            switch (input) {
                case 0:
                    changeAddress(member, scanner);
                    continue;
                case 1:
                    LOGGER.info(member.toString());
                    continue;
                case 2:
                    LOGGER.info(member.getAccounts());
                    continue;
                case 3:
                    transferMoney(member, scanner);
                    continue;
                case 4:
                    loggedIn = false;
                    continue;
                default:
                    LOGGER.info("Invalid input. Try again.");
            }
        }
    }

    public static void changeAddress(Profile profile, Scanner scanner) {
        IMenu changeAddressMenu = new ChangeAddressMenu();
        String[] addressInput = changeAddressMenu.getInput(scanner);

        State inputState = State.valueOf(addressInput[1].toUpperCase());

        if (inputState != null){
            profile.setAddress(new Address(addressInput[0], inputState, addressInput[2], Integer.parseInt(addressInput[3]), addressInput[4]));
        } else {
            LOGGER.info("State is not valid");
        }
    }

    public static void transferMoney(MemberProfile member, Scanner scanner) {
        Set<Account> accounts = member.getAccounts();

        accounts.stream()
                .filter(Objects::nonNull)
                .forEach(account -> LOGGER.info("Account: " + account + ", Balance: " + account.getBalance()));

        IMenu transferMoneyMenu = new TransferMoneyMenu();
        String[] moneyTransferValues = transferMoneyMenu.getInput(scanner);

        AccountSearch accountSearch = new AccountSearch();
        Account fromAccount = accountSearch.search(accounts, moneyTransferValues[0], "id");
        Account toAccount = accountSearch.search(accounts, moneyTransferValues[1], "id");

        Transaction accountMoneyTransfer = new AccountMoneyTransfer(fromAccount, toAccount, BigDecimal.valueOf(Double.parseDouble(moneyTransferValues[2])));
        accountMoneyTransfer.performTransaction();
    }

    public static void createMemberProfile(Set<Profile> profiles, Scanner scanner) {
        IMenu createMemberProfileMenu = new CreateMemberProfileMenu();

        String[] input = createMemberProfileMenu.getInput(scanner);

        try {
            Profile memberProfile = new MemberProfile(input[0], input[1], input[2]);
            memberProfile.setAge(Integer.parseInt(input[3]));
            changeAddress(memberProfile, scanner);

            if (memberProfile != null){
                profiles.add(memberProfile);
            }
            LOGGER.debug("member profile added with details " + memberProfile);
        } catch (NegativeAgeException e) {
            LOGGER.info("Age can't be negative. Profile was not created.");
        }
    }
}



