package com.solvd.search;

import com.solvd.exception.SearchTypeException;
import com.solvd.profile.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfileSearch implements ISearch<Profile> {

    private static final Logger LOGGER = LogManager.getLogger(ISearch.class);

    @Override
    public Profile[] search(Profile[] profiles, String[] searchValues, String searchType) throws SearchTypeException {
        if ("validation".equals(searchType)) {
            //exception to see if indexes exist
            String username = searchValues[0];
            String password = searchValues[1];

            for (Profile profile : profiles) {
                if (username.equals(profile.getUsername()) && password.equals(profile.getPassword())) {
                    return new Profile[]{profile};
                } else {
                    //profile doesn't exist exception
                }
                return null;
            }

        } else if ("id".equals(searchType)) {
            int id = Integer.parseInt(searchValues[0]);
            //not an int exception

            for (Profile profile : profiles) {
                if (id == profile.getId()) {
                    return new Profile[]{profile};
                }
                LOGGER.info("No profiles with id: " + id);
            }
        } else {
            throw new SearchTypeException("This search type is not valid");
        }
        return null;
    }
}
