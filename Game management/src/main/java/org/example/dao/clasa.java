package org.example.dao;

import java.util.Objects;

/// fn+alt+ins
public class clasa {
    public clasa(int x, String s) {
        this.x = x;
        this.s = s;
    }

    public String getS() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof clasa clasa)) return false;
        return x == clasa.x && Objects.equals(getS(), clasa.getS());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, getS());
    }

    int x;
    String s;

}
