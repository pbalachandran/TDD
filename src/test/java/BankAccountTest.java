/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount subject;


    @Before
    public void setUp() {
        subject = new BankAccount();
    }

    // Step 1
    @Test
    public void createAccount_withFirstLastName_returnsAccountNumber() throws Exception {
        BankAccount.BankAccountInfo bai = subject.createAccount("Mickey", "Mouse");
        assertNotNull(bai);
        assertTrue(bai.getFirstName() == "Mickey");
        assertTrue(bai.getLastName() == "Mouse");
        assertTrue(bai.getAccountNumber() >= 0);
    }

    // Step 3
    @Test
    public void deposit_retunsNewBalance() throws Exception {
        Double balance = subject.deposit(100.00);
        assertTrue(balance == 100.00);
    }

    // Step 5
    @Test
    public void balance_returnsCurrentBalance() throws Exception {
        subject.deposit(100.00);
        subject.deposit(141.45);

        Double balance = subject.balance();
        assertEquals(balance, new Double(241.45));
    }

    // Step 7
    @Test
    public void withdraw_returnsCurrentBalance() throws Exception {
        subject.deposit(100.00);
        subject.deposit(141.45);

        Double balance = subject.withdraw(40.00);
        assertEquals(balance, new Double(201.45));
    }

    // Step 9
    @Test
    public void withdraw_overDraw_throwsException() throws Exception {
        subject.deposit(120.00);

        try {
            Double balance = subject.withdraw(130.00);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    new Exception("Insufficient funds").getMessage());
        }
    }
}
