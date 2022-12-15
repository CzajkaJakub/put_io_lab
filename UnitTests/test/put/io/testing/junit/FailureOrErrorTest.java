package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    void test1() {
        throw new IllegalArgumentException();
    }

    @Test
    void test2() {
        assertTrue(1 == 2);
    }

    @Test
    void test3() {
        try {
            assertTrue(1 == 2);
        } catch (Throwable e) {
            System.out.println(e.getStackTrace());
        }
    }
}
