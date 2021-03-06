package productInventoryservice.services.api;

import com.angel.models.DTO.ProductDTO;
import com.angel.models.states.PaymentState;

import java.util.Collection;

public interface ProductInventoryService {

    ProductDTO getProduct(String productId);
    boolean isAvailable(String productId, int quantity);
    void resetQuantity(String productId, int quantity, PaymentState state);
    ProductDTO createProduct(ProductDTO product);
    void extractQuantity(String productId, int quantity);


}
