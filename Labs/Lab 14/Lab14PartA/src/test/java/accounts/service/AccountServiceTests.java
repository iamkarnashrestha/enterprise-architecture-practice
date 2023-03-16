package accounts.service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class AccountServiceTests {

    @TestConfiguration
    static class  AccountServiceImplContextConfiguration{
        @Bean
        public AccountService AccountService(){
            return  new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp(){
        String accountNumber="11111";
        Account karna=new Account(accountNumber,233.33,"Karna Shrestha");
        Optional<Account> karnaOptional= Optional.of(karna);
        Mockito.when(accountRepository.findById(accountNumber)).thenReturn(karnaOptional);

    }

    @Test
    public void whenValidAccountNumberThenAccountNumberShouldBeFound(){
        String accountNumber="11111";
        AccountDTO account=accountService.getAccount(accountNumber);
        assertThat(account.getAccountNumber()).isEqualTo(accountNumber);
    }

    @Test
    public void whenAccountCreatedAccountNumberShouldBeFound(){
        String accountNumber="11111";
        accountService.createAccount(accountNumber,233.33,"Karna Shrestha");
        assertThat(accountService.getAccount(accountNumber).getAccountNumber()).isEqualTo(accountNumber);
    }

}
