package com.solvd.bankapp.util;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.account.CheckingAccount;
import com.solvd.bankapp.account.SavingsAccount;
import com.solvd.bankapp.location.Address;
import com.solvd.bankapp.location.State;
import com.solvd.bankapp.profile.MemberProfile;
import com.solvd.bankapp.profile.Profile;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrepopulateData {
    public static Set<Profile> prepopulateProfiles() {

        MemberProfile member;
        String className = "com.solvd.bankapp.profile.MemberProfile";

        try {
            Class<MemberProfile> memberProfile = (Class<MemberProfile>) Class.forName(className);
            Constructor<MemberProfile> memberProfileConstructor = memberProfile.getDeclaredConstructor(String.class, String.class, String.class);
            member = memberProfileConstructor.newInstance("Bob Smith", "bsmith", "bobpw");
            Method setAgeMethod = memberProfile.getMethod("setAge", int.class);
            setAgeMethod.invoke(member, 25);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        MemberProfile member1 = new MemberProfile("Jakob Ableitner", "jableitn", "pw");
        member1.setAge(25);
        member1.setAddress(new Address("1st Street", State.MINNESOTA, "St. paul", 1324, "USA"));

        Account checkingAccount = new CheckingAccount(BigDecimal.valueOf(500));
        Account savingsAccount = new SavingsAccount(BigDecimal.valueOf(1400));
        member1.setAccounts(new HashSet<>(Arrays.asList(checkingAccount, savingsAccount)));

        Set<Profile> profiles = new HashSet<>();
        profiles.add(member);
        profiles.add(member1);

        return profiles;
    }
}
