package com.springboot.hellospring.controller;

import javax.servlet.http.HttpServletResponse;

import com.springboot.hellospring.dao.product;
import com.springboot.hellospring.model.productModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class productController{
    @Autowired
    private productModel productrepo;
    product prod;

    @RequestMapping(value="/product", method=RequestMethod.POST)
    public @ResponseBody String createProduct(@RequestBody product prods,HttpServletResponse res) {
        try {
            productrepo.save(prods);
            return "Created";
        } catch(TransactionSystemException t){
            System.err.println(t);
            res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return "Either of the inputs are null";
        } catch(DataIntegrityViolationException d){
            System.err.println(d);
            res.setStatus(HttpServletResponse.SC_CONFLICT);
            return "Constraint Violation";
        }
    }
    
    @RequestMapping(value="/allProduct", method=RequestMethod.GET)
    public Iterable<product> getProducts() {
        return productrepo.findAll();
    }

    @RequestMapping(value="/product", method=RequestMethod.GET)
    public Iterable<product> getProductsByName(@RequestParam("ch") String ch) {
        return productrepo.findByPname(ch);
    }
    
}

