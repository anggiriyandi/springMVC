/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.model.Person;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gelz
 */
public class PersonTest {
    private static AbstractApplicationContext ctx;
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    ctx = new ClassPathXmlApplicationContext(
				"classpath*:com/**/applicationContext.xml");
		ctx.registerShutdownHook();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ctx.stop();
    }
    
    @Test
    public void classTest(){
//        Person p = (Person) ctx.getBean("person");
    
    }
    
   
    

}
