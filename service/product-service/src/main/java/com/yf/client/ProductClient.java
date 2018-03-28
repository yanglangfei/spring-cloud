package com.yf.client;

import com.yf.lib.vo.RespVO;
import com.yf.model.TbProduct;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.util.List;

//@FeignClient(name = "product-service",fallback = ProductHystrixFallback.class)
@FeignClient("product-service")
public interface ProductClient {

    @PostMapping("/product/add")
    RespVO addProduct(@RequestParam("id") Long id,
                      @RequestParam("name") String name,
                      @RequestParam("price") BigDecimal  price);


    @GetMapping("/product/value")
    String getValue();


    @GetMapping("/product/findAll")
    List<TbProduct> findAllProduct();

    @GetMapping("/product/findByName")
    List<TbProduct> findByName(@RequestParam("name") String name);
}
