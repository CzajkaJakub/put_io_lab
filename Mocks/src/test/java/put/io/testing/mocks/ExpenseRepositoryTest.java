package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    private IFancyDatabase fancyDatabase;
    private MyDatabase myDatabase;

    @BeforeEach
    void setUp() {
        this.fancyDatabase = new FancyDatabase();
        this.myDatabase = new MyDatabase();
    }

    //TODO -> zad1
//    @Test
//    void loadExpenses() {
//        //GIVEN
////        ExpenseRepository expenseRepository = new ExpenseRepository(fancyDatabase);
//        ExpenseRepository expenseRepository = new ExpenseRepository(myDatabase);
//
//        //WHEN
//        expenseRepository.loadExpenses();
//        List<Expense> expenses = expenseRepository.getExpenses();
//        //THEN
//        assertEquals(0, expenses.size());
//    }

    //TODO -> zad 2
//    @Test
//    void loadExpenses() {
//        //GIVEN
//        FancyDatabase fancyDatabase1 = mock(FancyDatabase.class);
//        ExpenseRepository expenseRepository = new ExpenseRepository(fancyDatabase1);
//        InOrder inOrder = inOrder(fancyDatabase1);
//
//
//        //WHEN
//        expenseRepository.loadExpenses();
//        List<Expense> expenses = expenseRepository.getExpenses();
////        verify(fancyDatabase1).close();
////        verify(fancyDatabase1).queryAll();
////        verify(fancyDatabase1).connect();
//        inOrder.verify(fancyDatabase1).connect();
//        inOrder.verify(fancyDatabase1).queryAll();
//        inOrder.verify(fancyDatabase1).close();
//
//        //THEN
//        assertEquals(0, expenses.size());
//    }

    //TODO -> zad 3
    @Test
    void loadExpenses() {
        //GIVEN
        Expense newExpense = new Expense();
        newExpense.setAmount(69L);
        newExpense.setCategory("Zabawki dla dzieci");
        newExpense.setTitle("Witam");

        Expense newExpense2 = new Expense();
        newExpense.setAmount(69L);
        newExpense.setCategory("Zabawki dla dzieci");
        newExpense.setTitle("Witam");

        FancyDatabase fancyDatabase1 = mock(FancyDatabase.class);
        ExpenseRepository expenseRepository = new ExpenseRepository(fancyDatabase1);

        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(newExpense);
        }

        expenseRepository.saveExpenses();

        //WHEN
        expenseRepository.loadExpenses();
        List<Expense> expenses = expenseRepository.getExpenses();

        verify(fancyDatabase1, times(5)).persist(newExpense);
        //verify(fancyDatabase1).persist(newExpense2); // nie powiedzie sie bo jest to inna instancja

        verify(fancyDatabase1, times(5)).persist(any(Expense.class)); // teraz sie powiedzie



        //THEN
        assertEquals(0, expenses.size());
    }
}
