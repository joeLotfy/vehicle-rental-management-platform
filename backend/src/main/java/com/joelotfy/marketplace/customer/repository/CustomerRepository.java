package com.joelotfy.marketplace.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joelotfy.marketplace.customer.entity.Customer;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> { //entity Customer managed by CustomerRepository, long is Customer PK (id)

    List<Customer> findAll();

    List<Customer> findByFirstName(String firstName);
    List<Customer> findByMiddleName(String middleName);
    List<Customer> findByLastName(String lastName);

    List<Customer> findByNationalID(String nationalID);
    List<Customer> findByNationality(String nationality);

    List<Customer> findBySex(boolean sex);

    //and many others

}
