import org.mapstruct.Mapper;

import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.entity.Customer;

@Mapper (componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CreateCustomerRequest dto);
}