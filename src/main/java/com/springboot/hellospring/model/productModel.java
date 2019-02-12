package com.springboot.hellospring.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.springboot.hellospring.dao.*;

public interface productModel extends CrudRepository<product, Long> {
    
    List<product> findByPnameContaining(String pname);
}