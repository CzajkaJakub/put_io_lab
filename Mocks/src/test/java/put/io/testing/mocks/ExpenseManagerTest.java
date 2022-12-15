package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateTotal() {
        //GIVEN
        Expense newExpense = new Expense();
        newExpense.setAmount(54);
        newExpense.setCategory("Zabawki dla dzieci");
        newExpense.setTitle("Witam");

        Expense newExpense2 = new Expense();
        newExpense2.setAmount(22);
        newExpense2.setCategory("Zabawki vxcvdla dzieci");
        newExpense2.setTitle("Witamvxcvx");

        Expense newExpense3 = new Expense();
        newExpense3.setAmount(11);
        newExpense3.setCategory("Zabavxcvxcwki dla dzieci");
        newExpense3.setTitle("Witaxcvxcm");

        FancyDatabase fancyDatabase1 = mock(FancyDatabase.class);
        FancyService fancyService = mock(FancyService.class);
        ExpenseRepository expenseRepository = new ExpenseRepository(fancyDatabase1);

        //WHEN
        expenseRepository.addExpense(newExpense3);
        expenseRepository.addExpense(newExpense2);
        expenseRepository.addExpense(newExpense);

        ExpenseManager expenseManager = new ExpenseManager(expenseRepository, fancyService);

        long total = expenseManager.calculateTotal();
        assertEquals(87, total);
    }

    @Test
    void calculateTotalForCategory() {
    }

    @Test
    void calculateTotalInDollars() {
    }

    @Test
    void convertExpenseToDollars() {
    }
}
