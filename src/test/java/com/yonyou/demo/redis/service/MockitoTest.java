package com.yonyou.demo.redis.service;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;
import com.yonyou.demo.redis.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
}
