package com.example.expenseTracker.repository;

import com.example.expenseTracker.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    List<ExpenseEntity> findByCategory(String category);
    List<ExpenseEntity>
    findByAmountGreaterThanEqualAndAmountLessThanEqual(double minAmount,
            double maxAmount);
}
