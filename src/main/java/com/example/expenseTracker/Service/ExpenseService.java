package com.example.expenseTracker.Service;

import com.example.expenseTracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.example.expenseTracker.Entity.ExpenseEntity;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }
    public ExpenseEntity createExpense(ExpenseEntity expense){
        expense.setCreated_At(LocalDateTime.now());
        expense.setUpdated_At(LocalDateTime.now());
        expense.setDeleted(false);
        return expenseRepository.save(expense);
    }
    public List<ExpenseEntity> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public ExpenseEntity getExpenseById(Long id){
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }
    public ExpenseEntity updateExpense(Long id, ExpenseEntity updatedExpense){
        ExpenseEntity existingExpense= expenseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Expense not found"));
        existingExpense.setTitle(updatedExpense.getTitle());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setCategory(updatedExpense.getCategory());
        return expenseRepository.save(existingExpense);
    }
}
