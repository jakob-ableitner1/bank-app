package com.solvd.bankapp.menu;

import java.util.Scanner;

public class TransferMoneyMenu implements IMenu{

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
