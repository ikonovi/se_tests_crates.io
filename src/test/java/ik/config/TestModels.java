package ik.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ik.se.crates.model.User;

public class TestModels {

    public static User user;

    @Inject
    private static void setUser(@Named("searchPhrase") String searchPhrase) {
        user = new User(searchPhrase);
    }
}
