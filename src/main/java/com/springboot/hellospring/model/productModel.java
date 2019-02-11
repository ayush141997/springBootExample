package com.springboot.hellospring.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.springboot.hellospring.dao.*;

public interface productModel extends CrudRepository<product, Long> {
    
    @Query("Select * from product where pname Like %?1%")
    List<product> findByPname(String pname);
}