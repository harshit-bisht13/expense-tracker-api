package com.example.expenseTracker.Service;

import com.example.expenseTracker.DTO.CreateExpenseRequest;
import com.example.expenseTracker.DTO.UpdateExpenseRequest;
import com.example.expenseTracker.exception.ExpenseNotFoundException;
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
    public ExpenseEntity createExpense(CreateExpenseRequest expenseRequest){
        ExpenseEntity expense = new ExpenseEntity();
        expense.setTitle(expenseRequest.getTitle());
        expense.setAmount(expenseRequest.getAmount());
        expense.setCategory(expenseRequest.getCategory());
        expense.setDate(expenseRequest.getDate());
        expense.setDescription(expenseRequest.getDescription());

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
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
    }
    public ExpenseEntity updateExpense(Long id, UpdateExpenseRequest expenseRequest){
        ExpenseEntity existingExpense= expenseRepository.findById(id)
                .orElseThrow(()->new ExpenseNotFoundException("Expense not found"));
        existingExpense.setTitle(expenseRequest.getTitle());
        existingExpense.setAmount(expenseRequest.getAmount());
        existingExpense.setCategory(expenseRequest.getCategory());
        existingExpense.setDate(expenseRequest.getDate());
        existingExpense.setDescription(expenseRequest.getDescription());

        existingExpense.setUpdated_At(LocalDateTime.now());
        return expenseRepository.save(existingExpense);
    }
    public void deleteExpense(Long id){
         expenseRepository.deleteById(id);
    }
}
