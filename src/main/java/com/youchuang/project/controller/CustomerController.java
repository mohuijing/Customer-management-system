package com.youchuang.project.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youchuang.project.entity.Customer;
import com.youchuang.project.service.CustomerService;
import com.youchuang.project.util.MyQuery;
import com.youchuang.project.util.QueryUtil;
import com.youchuang.project.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-15
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 进入列表页
     *
     * @return
     */
    @GetMapping("toList")
    public String toList() {
        return "customer/customerList";
    }


    /**
     * 查询方法
     * @param param
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public R<Map<String, Object>> list(@RequestParam Map<String, String> param) {
        MyQuery<Customer> myQuery = QueryUtil.<Customer>buildMyQuery(param);

        Page<Customer> customerPage = customerService.page(myQuery.getPage(), myQuery.getWrapper().orderByDesc("customer_id"));

        return ResultUtil.buildPageR(customerPage);
    }


    /**
     * 进入新增页
     *
     * @return
     */
    @GetMapping("toAdd")
    public String toAdd() {
        return "customer/customerAdd";
    }

    /**
     * 新增客户
     * @param customer
     * @return
     */
   @PostMapping
   @ResponseBody
   public R<Object> add(@RequestBody Customer customer){
        return ResultUtil.buildR(customerService.save(customer));
   }

    /**
     * 进入修改页
     * @return
     */
    @GetMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable Long id, Model model) {

        System.out.println("id = " + id);
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customer/customerUpdate";
    }

    /**
     * 修改客户
     * @param customer
     * @return
     */
    @PutMapping
    @ResponseBody
    public R<Object> updateSubmit(@RequestBody Customer customer) {
        return ResultUtil.buildR(customerService.updateById(customer));
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Long id){
        return customerService.removeById(id);
    }


    /**
     * 进入详情页
     * @param id
     * @param model
     * @return
     */
    @GetMapping("toDetail/{id}")
    public String toDetail(@PathVariable Long id, Model model) {

        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customer/customerDetail";
    }
}
