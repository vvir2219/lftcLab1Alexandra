package com.company;

import java.util.Optional;

public class Match {
    private String value;
    private Optional<Integer> token;
    private boolean valid;

    public Match(String value, Optional<Integer> token) {
        this.value = value;
        this.token = token;
        this.valid = true;
    }

    public Match() {
        this.valid = false;
    }

    public String getValue() {
        return value;
    }

    public Optional<Integer> getToken() {
        return token;
    }

    public boolean isValid() {
        return valid;
    }
}
