package com.youchuang.project.service.impl;

import com.youchuang.project.entity.Customer;
import com.youchuang.project.dao.CustomerMapper;
import com.youchuang.project.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-14
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {


}
