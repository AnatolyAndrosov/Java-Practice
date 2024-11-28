package expense;

import expense.dto.Expense;
import expense.dto.Income;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetManagerTest {
    private BudgetManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BudgetManager();
    }

    @Test
    @DisplayName("Test add expense")
    public void testAddExpense() {
        Expense expense = new Expense(new BigDecimal("200"), "Обед");
        manager.addExpense(expense);
        var totalExpense = manager.getTotalExpense();
        assertEquals(new BigDecimal("200"), totalExpense);
    }

    @Test
    @DisplayName("Test add income")
    public void testAddIncome() {
        Income income = new Income(new BigDecimal("1000"), "Salary", "main");
        manager.addIncome(income);
        var totalIncome = manager.getTotalIncome();
        assertEquals(new BigDecimal("1000"), totalIncome);
    }

    @Test
    @DisplayName("Test get balance")
    public void testGetBalance() {
        Income income = new Income(new BigDecimal("1000"), "Salary", "main");
        manager.addIncome(income);
        Expense expense = new Expense(new BigDecimal("200"), "Обед");
        manager.addExpense(expense);
        assertEquals(new BigDecimal("800"), manager.getBalance());
    }

    @Test
    @DisplayName("Test average income if no incomes")
    public void testAverageIncomeIfNoIncomes(){
        assertEquals(Optional.empty(), manager.averageIncome());
    }

    @Test
    @DisplayName("Test average income if a few incomes")
    public void testAverageIncomeIfFewIncomes(){
        manager.addIncome(new Income(new BigDecimal("20"), "source", "description"));
        manager.addIncome(new Income(new BigDecimal("40"), "source", "description"));
        BigDecimal actual = manager.averageIncome().get();
        assertEquals(new BigDecimal("30"), actual);
    }
}
