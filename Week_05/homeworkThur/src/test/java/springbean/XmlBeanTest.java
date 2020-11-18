package springbean;

import io.bruce.springbean.XmlBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlBean xmlBean = (XmlBean)context.getBean("xmlBean");
        xmlBean.sayHello();
    }
}
