package com.solvd.bankapp.search;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.SearchTypeException;
import com.solvd.bankapp.profile.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfileSearch implements ISearch<Profile> {

    @Override
    public List<Profile> search(Set<Profile> profiles, String[] searchValues, String searchType) {
        if ("validation".equals(searchType)) {
            String username = searchValues[0];
            String password = searchValues[1];

            List<Profile> profileList = profiles.stream()
                    .filter(profile -> username.equals(profile.getUsername()) && password.equals(profile.getPassword()))
                    .collect(Collectors.toList());
            return profileList;

        } else if ("id".equals(searchType)) {
            String id = searchValues[0];

            List<Profile> profileList = profiles.stream()
                    .filter(profile -> id.equals(profile.getId().toString()))
                    .collect(Collectors.toList());
            return profileList;
        } else {
            throw new SearchTypeException("This search type is not valid");
        }
    }
}
