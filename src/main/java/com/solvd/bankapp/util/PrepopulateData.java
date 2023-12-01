package com.solvd.bankapp.util;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.account.CheckingAccount;
import com.solvd.bankapp.account.SavingsAccount;
import com.solvd.bankapp.location.Address;
import com.solvd.bankapp.location.State;
import com.solvd.bankapp.profile.MemberProfile;
import com.solvd.bankapp.profile.Profile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrepopulateData {
    public static Set<Profile> prepopulateProfiles() {
        MemberProfile member1 = new MemberProfile("Jakob Ableitner", "jableitn", "pw");
        member1.setAge(25);
        member1.setAddress(new Address("1st Street", State.MINNESOTA, "St. paul", 1324, "USA"));

        Account checkingAccount = new CheckingAccount(BigDecimal.valueOf(500));
        Account savingsAccount = new SavingsAccount(BigDecimal.valueOf(1400));
        member1.setAccounts(new HashSet<>(Arrays.asList(checkingAccount, savingsAccount)));

        Set<Profile> profiles = new HashSet<>();
        profiles.add(member1);

        return profiles;
    }
}
