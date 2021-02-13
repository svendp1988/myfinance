package com.example.myfinance.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseRepositoryTest {
    private Expense expense1;
    private Expense expense2;
    private Expense expense3;
    private ExpenseRepository repository;

    @Before
    public void setUp() {
        expense1 = new Expense(LocalDate.of(2021, 2, 13), 124.25, ExpenseType.RELAXATION);
        expense1.setId("test1");
        expense2 = new Expense(LocalDate.of(2021, 1, 31), 25.50, ExpenseType.SHOPPING);
        expense2.setId("test2");
        expense3 = new Expense(LocalDate.of(2021, 1, 5), 66, ExpenseType.HOUSEHOLD);
        expense3.setId("test3");
        repository = new ExpenseRepository();
    }

    @Test
    public void add() {
        repository.addExpense(expense1);
        repository.addExpense(expense2);
        repository.addExpense(expense3);
        assertEquals(3, repository.findAll().size());
    }
}