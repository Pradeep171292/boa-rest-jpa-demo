package com.boa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Customer;

/**
 * @author Admin
 * 
 *         By inheriting the Crud repo we can call many methods without the need
 *         to implement them ourselve Some of these methods are save, findOne,
 *         exists(), find(), findall()..
 * 
 *         for writing the custom query we use JPQL(JAva Persistent Query LAng.)
 *         mechanism in which we use @Query annotation with respective value as
 *         a qurey and another parameter NativeQuery which wil bind to the JPQL
 *         query engine
 */
public interface CustomerReposetory<C> extends CrudRepository<Customer, Long> {
    List<Customer> findByFirstName(String firstName);
    
    @Query(value = "select * from customer where age =?", nativeQuery = true)
	List<Customer> findByAge(int age);
    	

}
