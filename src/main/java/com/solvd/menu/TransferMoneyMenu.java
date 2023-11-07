package com.solvd.menu;

import java.math.BigDecimal;

public class TransferMoneyMenu implements IMenu{

    @Override
    public String[] getInput() {
        System.out.println("Which account would you like to transfer from?");
        String fromAccountIndex = scanner.nextLine();
        System.out.println("Which account would you like to transfer to?");
        String toAccountIndex = scanner.nextLine();
        System.out.println("How much money would you like to transfer?");
        String amount = scanner.nextLine();
        return new String[]{fromAccountIndex, toAccountIndex, amount};
    }
}
