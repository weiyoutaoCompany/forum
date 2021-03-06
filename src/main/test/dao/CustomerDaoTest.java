package dao;

import com.bjbls.forum.dao.CustomerDao;
import com.bjbls.forum.model.Customer;
import com.bjbls.forum.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class CustomerDaoTest extends SpringJunitTest{
    @Resource
    private CustomerDao customerDao;
    /*
   对login方法进行测试
    */
    @Test
    public void loginTest(){
        Customer customer=customerDao.login("user","123456");
        System.out.println(customer.getName());
    }
    /*
    对表内容进行删除
     */
    @Test
    public void deleteTest(){
        System.out.println(customerDao.delete(2));
    }
    /*
    查询第几条记录
     */
    @Test
    public void getTest(){
    Customer customer=customerDao.get(3);
    System.out.println(customer);
    customer=customerDao.get(1);
        System.out.println(customer);
    }
    @Test
    public void addTest(){
       Customer customer=new Customer();
       customer.setName("魏鹏");
       customer.setUsername("weipeng");
       customer.setPassword("123456");
       customerDao.add(customer);

    }
    @Test
    public void addCsTest(){
        String username="a";
        customerDao.addCs(username);
    }





}
