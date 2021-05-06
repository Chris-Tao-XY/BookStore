import com.bjpowernode.dao.BookDao;
import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.BookService;
import com.bjpowernode.service.UserService;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Test {
    @org.junit.Test
    public void regist(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserService userService=applicationContext.getBean(UserService.class);
        userService.registerUser(new User(null,"dufhse","edwewe","fwefwwefwefwe"));
    }

    @org.junit.Test
    public void addBook(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationConfig.xml");
        BookService bookService=applicationContext.getBean(BookService.class);
        bookService.addBook(new Book(null,"ewewerw","ewedwefwe",new BigDecimal("231.1"),12,12,"ERWFWEFWE"));
    }

    @org.junit.Test
    public void delete(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationConfig.xml");
        BookService bookService=applicationContext.getBean(BookService.class);
        bookService.deleteBook(114520);
    }

    @org.junit.Test
    public void query(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationConfig.xml");
        BookDao bookDao=applicationContext.getBean(BookDao.class);
        System.out.println(bookDao.queryForBookNumberByPrice(new BigDecimal(0), new BigDecimal(999999)));
    }
}
