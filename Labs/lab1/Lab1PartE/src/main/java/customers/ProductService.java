package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IEmailSender emailSender;
    @Autowired
    ProductDAO productDAO;

    @Override
    public void createNewProduct(String id, String name, Integer price) {
        Product product=new Product(id,name,price);
        productDAO.save(product);
        emailSender.sendEmail("abc@gmail.com","Product "+name+" successfully added");

    }
}
