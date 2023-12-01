package com.solvd.bankapp.location;

public enum State {

    IOWA("Iowa", 1),
    MINNESOTA("Minnesota", 2),
    NORTH_DAKOTA("North Dakota", 3),
    SOUTH_DAKOTA("South Dakota", 4),
    WISCONSIN("Wisconsin", 5);

    private String displayName;
    private int number;

    State(String displayName, int number){
        this.displayName = displayName;
        this.number = number;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getNumber() {
        return number;
    }
}
