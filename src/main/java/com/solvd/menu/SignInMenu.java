package com.solvd.menu;

public class SignInMenu implements IMenu {
    @Override
    public String[] getInput() {
        LOGGER.info("enter username");
        String username = scanner.nextLine();
        LOGGER.info("enter password");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }
}
