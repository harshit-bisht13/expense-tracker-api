package com.example.expenseTracker.Controller;

import com.example.expenseTracker.DTO.CreateExpenseRequest;
import com.example.expenseTracker.DTO.UpdateExpenseRequest;
import com.example.expenseTracker.Entity.ExpenseEntity;
import com.example.expenseTracker.Service.ExpenseService;
import jakarta.validation.Valid;
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
    public ExpenseEntity createExpense(@Valid @RequestBody CreateExpenseRequest expenseRequest){
        return expenseService.createExpense(expenseRequest);
    }
    @GetMapping
    public List<ExpenseEntity> getExpenses(){
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public ExpenseEntity getExpenseByID(@PathVariable Long id){
        return expenseService.getExpenseById(id);

    }
    @PutMapping("/{id}")
    public ExpenseEntity updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody UpdateExpenseRequest expenseRequest) {

        return expenseService.updateExpense(id, expenseRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
}
