package com.solvd.menu;

public class SignInMenu implements IMenu {
    @Override
    public String[] getInput() {
        System.out.println("enter username");
        String username = scanner.nextLine();
        System.out.println("enter password");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }
}
