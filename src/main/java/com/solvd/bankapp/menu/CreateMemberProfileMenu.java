package com.solvd.bankapp.menu;

public class CreateMemberProfileMenu implements IMenu{

    @Override
    public String[] getInput() {
        LOGGER.info("Enter the values for the following fields and press the enter button after each value: Name, Username, Password, Age");
        String name = scanner.nextLine();
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String age = scanner.nextLine();

        return new String[]{name, username, password, age};
    }
}
