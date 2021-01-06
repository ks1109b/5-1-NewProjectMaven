import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndAmountZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    // Проверка отрицательного значения amount (отмена/возврат покупки), пересчет бонусов.
    void shouldCalculateRegisteredAndAmountNegativeOverLimit() {
        BonusService service = new BonusService();

        long amount = -100_000_60;
        boolean registered = true;
        long expected = -500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
        // Проверка отрицательного значения amount (отмена/возврат покупки), пересчет бонусов.
    void shouldCalculateRegisteredAndAmountNegativeUnderLimit() {
        BonusService service = new BonusService();

        long amount = -1000_60;
        boolean registered = true;
        long expected = -30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNonRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNonRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNonRegisteredAndAmountZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
        // Проверка отрицательного значения amount (отмена/возврат покупки), пересчет бонусов.
    void shouldCalculateNonRegisteredAndAmountNegativeOverLimit() {
        BonusService service = new BonusService();

        long amount = -100_000_60;
        boolean registered = false;
        long expected = -500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
        // Проверка отрицательного значения amount (отмена/возврат покупки), пересчет бонусов.
    void shouldCalculateNonRegisteredAndAmountNegativeUnderLimit() {
        BonusService service = new BonusService();

        long amount = -1000_60;
        boolean registered = false;
        long expected = -10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}