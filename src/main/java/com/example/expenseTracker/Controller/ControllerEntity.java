package com.example.expenseTracker.Controller;

import com.example.expenseTracker.Entity.ExpenseEntity;
import com.example.expenseTracker.Service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ControllerEntity {
    private final ExpenseService expenseService;
    public ControllerEntity(ExpenseService expenseService){
        this.expenseService=expenseService;
    }
    @PostMapping
    public ExpenseEntity createExpense(@RequestBody ExpenseEntity expense){
        return expenseService.createExpense(expense);
    }
    @GetMapping
    public List<ExpenseEntity> getExpenses(){
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public ExpenseEntity getExpenseByID(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

}
