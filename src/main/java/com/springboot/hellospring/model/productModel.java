package com.springboot.hellospring.model;

import org.springframework.data.repository.CrudRepository;
import com.springboot.hellospring.dao.*;

public interface productModel extends CrudRepository<product, Long> {
    
}