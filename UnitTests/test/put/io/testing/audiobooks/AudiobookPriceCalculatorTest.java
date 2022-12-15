package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    private AudiobookPriceCalculator audiobookPriceCalculator;
    private Customer customerSubscriber;
    private Customer customerSilver;
    private Customer customerGold;
    private Customer customerStandard;

    private Audiobook audiobook;

    @BeforeEach
    void setUp() {
        audiobookPriceCalculator = new AudiobookPriceCalculator();
        customerSubscriber = new Customer("cus1", Customer.LoyaltyLevel.GOLD, true);
        customerSilver = new Customer("cus2", Customer.LoyaltyLevel.SILVER, false);
        customerGold = new Customer("cus3", Customer.LoyaltyLevel.GOLD, false);
        customerStandard = new Customer("cus4", Customer.LoyaltyLevel.STANDARD, false);
        audiobook = new Audiobook("title", 151.2);
    }

    @Nested
    class CalculateTest {

        @Test
        void shouldReturn0IfCustomerIsSubscriber() {
            //given
            double expectedValue = 0.0;

            //when
            double result = audiobookPriceCalculator.calculate(customerSubscriber, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void shouldReturn90perCenDiscount() {
            //given
            double expectedValue = audiobook.getStartingPrice() * 0.9;

            //when
            double result = audiobookPriceCalculator.calculate(customerSilver, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void shouldReturn80perCenDiscount() {
            //given
            double expectedValue = audiobook.getStartingPrice() * 0.8;

            //when
            double result = audiobookPriceCalculator.calculate(customerGold, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void shouldReturnFullPriceIfNonLoyal() {
            //given
            double expectedValue = audiobook.getStartingPrice();

            //when
            double result = audiobookPriceCalculator.calculate(customerStandard, audiobook);

            //then
            assertEquals(expectedValue, result);
        }
    }
}