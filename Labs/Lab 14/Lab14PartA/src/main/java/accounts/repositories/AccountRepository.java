package accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
   public Account findByAccountHolder(String accountHolder);
   public Account findAccountByAccountNumber(String accountNumber);

   public List<Account> findAccountByBalanceGreaterThan(double balance);
}
