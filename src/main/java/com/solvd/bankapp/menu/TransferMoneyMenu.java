package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TransferMoneyMenu implements IMenu{
    private final static Logger LOGGER = LogManager.getLogger(TransferMoneyMenu.class);

    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Which account would you like to transfer from?");
        String fromAccountIndex = scanner.nextLine();
        LOGGER.info("Which account would you like to transfer to?");
        String toAccountIndex = scanner.nextLine();
        LOGGER.info("How much money would you like to transfer?");
        String amount = scanner.nextLine();
        return new String[]{fromAccountIndex, toAccountIndex, amount};
    }
}
