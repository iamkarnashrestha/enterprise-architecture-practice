import bank.domain.Account;
import bank.domain.Customer;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;


public class AccountTest {
    @Test
    public void testDeposit(){
        Account account = new Account();
        account.deposit(100.0);
        assertThat( account.getBalance(), closeTo (100.0, 0.01));
    }

    @Test
    public void testWithdraw(){
        Account account = new Account();
        account.withdraw(100.0);
        assertThat( account.getBalance(), equalTo (-100.0));
    }

    @Test
    public void testTransferFunds(){
        Account fromAccount = new Account(11111);
        fromAccount.setCustomer(new Customer("Karna"));
        Account toAccount = new Account(22222);
        toAccount.setCustomer(new Customer("Arjun"));
        fromAccount.transferFunds(toAccount,100.0,"testing transfer fund");
        assertThat( fromAccount.getBalance(), equalTo (-100.0));
        assertThat( toAccount.getBalance(), equalTo (100.0));
    }

    @Test
    public void testCreateAccount(){
    Account account = new Account(12345);
    account.setCustomer(new Customer("Karna"));
    assertThat( account.getCustomer().getName(), equalTo("Karna"));
    }

}
