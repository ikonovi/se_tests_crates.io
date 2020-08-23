package ik.se.crates.model;

import java.util.Objects;
import java.util.StringJoiner;

public class User {

    private String searchPhrase;

    public User(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(searchPhrase, user.searchPhrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchPhrase);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("searchPhrase='" + searchPhrase + "'")
                .toString();
    }
}
