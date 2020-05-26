package com.yonyou.demo.redis.service;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;
import com.yonyou.demo.redis.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.mockito.ArgumentMatchers.anyString;

/**
 * @author ：yuelin.yin@rootcloud.com
 * @date ：Created in 2020/5/25 21:28
 * @description：mockitotest
 * @modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class MockitoTest {

    @MockBean
    private OrderServiceI service;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    //mock 对象
    @Test
    public void testAction(){
        // 创建Mock对象，参数可以是类或者接口
        Product product = Mockito.mock(Product.class);

        //设置方法的预期返回值
        Mockito.when(product.getOrderCode()).thenReturn("code001");

        System.out.println(product.getOrderCode());

        //验证方法调用
        Mockito.verify(product).getOrderCode();

    }

    //mock service
    @Test
    public void testService(){
        Order order = new Order();
        order.setName("test mock");
        //Mock一个结果，当userService调用getById的时候，返回user
        Mockito.doReturn(order).when(service).getById(anyString());
        Order result = service.getById("123");
        System.out.println(result.getName());
    }

    @Test
    public void testRequest() throws Exception {
        // perform : 执行请求 ;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                //MockMvcRequestBuilders.post("/url") ： 构造一个post请求
                .post("/user/insert")
                .accept(MediaType.APPLICATION_JSON)
                //传参,因为后端是@RequestBody所以这里直接传json字符串
                //.content(jsonResult)
                // 请求type : json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();//返回结果

        int statusCode = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(statusCode,"200");
        System.out.println(result);
    }
}
