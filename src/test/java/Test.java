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
 class Circle2D {
    double x;
    double y;
    double radius;

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;

    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return radius*radius*3.14;
    }
    public double getPerimeter(){
        return 6.28*radius;
    }
    public boolean contains(double x,double y){
        if ((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y)<=radius*radius){
            return true;
        }else return false;
    }
    public boolean contains(Circle2D circle){
        if (circle.radius+Math.sqrt((circle.x-x)*(circle.x-x)+(circle.y-y)*(circle.y-y))<radius){
            return true;
        }else return false;
    }

    public boolean overlaps(Circle2D circle){
        if (circle.x==this.x&&circle.y==this.y&&circle.radius==this.radius){
            return true;
        }else return false;
    }

}
 class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    public GeometricObject(){}
    public GeometricObject(String color,boolean filled){
        this.color=color;
        this.filled=filled;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
class Triangle extends GeometricObject{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle(){
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    public Triangle(double side1,double side2,double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ",color="+getColor()+
                ",filled="+isFilled()+
                '}';
    }
}

class Test114514 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1,1.5,1);
        triangle.setColor("yellow");
        triangle.setFilled(true);
        System.out.println(triangle.toString());
        Circle2D circle2D = new Circle2D(2,2,5.5);
        System.out.println("The area of the circle is：");
        System.out.println(circle2D.getArea());
        System.out.println("The circumference of the circle is：");
        System.out.println(circle2D.getPerimeter());
        System.out.println("Is the point inside the circle？");
        System.out.println(circle2D.contains(3,3));
        System.out.println("Is the circle inside the other？");
        System.out.println(circle2D.contains(new Circle2D(4,5,10.5)));
        System.out.println("Can these two circle overlaps？");

        System.out.println(circle2D.overlaps(new Circle2D(3,5,2.3)));
    }
}