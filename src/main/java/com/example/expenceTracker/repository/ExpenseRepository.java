package com.example.expenceTracker.repository;

import com.example.expenceTracker.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
