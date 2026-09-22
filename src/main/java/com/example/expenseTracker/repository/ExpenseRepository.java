package com.example.expenseTracker.repository;

import com.example.expenseTracker.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
}
