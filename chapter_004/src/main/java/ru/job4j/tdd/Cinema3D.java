package ru.job4j.tdd;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {


    @Override
    public List<Session> find(Predicate<Session> filter) {
        return Collections.unmodifiableList((List<Session>) new Session3D());
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
