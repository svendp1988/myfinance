package com.example.myfinance.model;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseRepositoryTest {
    private final Expense expense1 = new Expense(LocalDate.of(2021, 2, 13), 124.25, ExpenseType.RELAXATION);
    private final Expense expense2 = new Expense(LocalDate.of(2021, 1, 31), 25.50, ExpenseType.SHOPPING);
    private final Expense expense3 = new Expense(LocalDate.of(2021, 1, 5), 66, ExpenseType.HOUSEHOLD);
    ExpenseRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new ExpenseRepository();
        expense1.setId("test1");
        expense2.setId("test2");
        expense3.setId("test3");
        repository.addAll(List.of(expense1, expense2, expense3));
    }

    @Test
    void add() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void cannotAddDuplicateIds() {
        Expense expense4 = new Expense(LocalDate.of(2021, 1, 1), 150, ExpenseType.RELAXATION);
        expense4.setId(expense1.getId());
        repository.addExpense(expense4);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(expense3, repository.findById("test3"));
    }

    @Test
    void remove() {
        Expense removedExpense = repository.removeExpense("test2");
        assertEquals(expense2, removedExpense);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void update() {
        Expense updatedExpense = new Expense(LocalDate.of(2020, 1, 1), 100, ExpenseType.DUBIOUS);
        updatedExpense.setId("test1");
        repository.updateExpense("test1", updatedExpense);
        assertEquals(updatedExpense, repository.findById("test1"));
    }
}