package accounts.controller;

import accounts.service.AccountDTO;
import accounts.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)

public class AccountControllerTests {

    @Autowired
    MockMvc mock;

    @MockBean
    AccountService accountService;
@Test
    public void testGetAccount() throws  Exception{
        Mockito.when(accountService.getAccount("1222")).thenReturn(new AccountDTO("1222",345.5,"Karna Shrestha"));
        mock.perform(get("/account/1222"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(1222))
            .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(345.5))
            .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Karna Shrestha"));

    }

    @Test
    public void testCreateAccount() throws  Exception{
        String accountNumber = "12222";
        double amount = 345.5;
        String accountHolder = "Karna Shrestha";
        mock.perform(get("/createaccount/"+accountNumber+"/"+amount+"/"+accountHolder))
                .andExpect(status().isOk());
    }

}
