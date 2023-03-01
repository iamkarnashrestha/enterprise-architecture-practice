package customers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//defining profile as production environment
@Profile("production")
public class CustomerDAOImpl implements CustomerDAO {
	private Logger logger ;
    public CustomerDAOImpl(LoggerImpl logger) {
		this.logger=logger;

    }

	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

}
