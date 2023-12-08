package com.solvd.bankapp.search;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.ProfileNotFoundException;
import com.solvd.bankapp.profile.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfileSearch implements ISearch<Profile> {

    @Override
    public Profile search(Set<Profile> profiles, String searchValue, String searchType) {

        Profile profile = profiles.stream()
                .filter(p -> {
                    if ("validation".equals(searchType) && searchValue.equals(p.getUsername())){
                        return true;
                    } else if (("id".equals(searchType) && searchValue.equals(p.getId()))) {
                        return true;
                    }
                    return false;
                }).findFirst().orElseThrow(() -> new ProfileNotFoundException("Profile not found"));

        return profile;
    }
}
