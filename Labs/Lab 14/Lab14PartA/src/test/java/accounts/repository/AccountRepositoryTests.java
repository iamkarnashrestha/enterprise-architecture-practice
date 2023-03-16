package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void whenFindByAccountHolderThenReturnAccount(){
        Account account=new Account("1111",2345.5,"Karna Shrestha");
        entityManager.persist(account);
        entityManager.flush();
        Account foundAccount=accountRepository.findByAccountHolder(account.getAccountHolder());
        assertThat(foundAccount.getAccountHolder()).isEqualTo(account.getAccountHolder());
    }
    @Test
    public void whenFindByAccountNumberThenReturnAccount(){
        Account account=new Account("1111",2345.5,"Karna Shrestha");
        entityManager.persist(account);
        entityManager.flush();
        Account foundAccount=accountRepository.findAccountByAccountNumber(account.getAccountNumber());
        assertThat(foundAccount.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    public void whenFindByBalanceGreaterThenReturnAccountList(){
        List<Account> accountList=new ArrayList<>();
        Account karna=new Account("1111",2345.5,"Karna Shrestha");
        Account arjun =new Account("1112",2345.5,"Arjun Subedi");
        accountList.add(karna);
        accountList.add(arjun);
        entityManager.persist(karna);
        entityManager.persist(arjun);
        entityManager.flush();
        List<Account> foundAccount=accountRepository.findAccountByBalanceGreaterThan(666.88);
        assertIterableEquals(foundAccount,accountList);
    }



}
