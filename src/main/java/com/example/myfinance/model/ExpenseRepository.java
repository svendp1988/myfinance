package com.example.myfinance.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExpenseRepository {
    private final Map<String, Expense> expenses;

    public ExpenseRepository() {
        this.expenses = new HashMap<>();
    }

    public Expense addExpense(Expense expense) {
        return expenses.put(expense.getId(), expense);
    }

    public Expense findById(String id) {
        return expenses.get(id);
    }

    public List<Expense> findAll() {
        return (List<Expense>) expenses.values();
    }

    public Expense removeExpense(String id) {
        return expenses.remove(id);
    }

    public Expense updateExpense(String id, Expense expense) {
        removeExpense(id);
        return addExpense(expense);
    }
}
