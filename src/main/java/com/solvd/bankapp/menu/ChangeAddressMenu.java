package com.solvd.bankapp.menu;

import java.util.Scanner;

public class ChangeAddressMenu implements IMenu{
    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Enter the values for the following fields and press the enter button after each value: Street Line, State, City, Zip Code, Country");
        String streetLine = scanner.nextLine();
        String state = scanner.nextLine();
        String city = scanner.nextLine();
        String zipCode = scanner.nextLine();
        String country = scanner.nextLine();

        return new String[]{streetLine, state, city, zipCode,country};
    }
}
