import configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

import java.util.Scanner;


public class application {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        int choose=1;
        while (choose ==1) {

            Scanner myObj = new Scanner(System.in);
            System.out.println(" OPTIONS \n 1.Add book \n 2.Print all of books \n 3.Delete book \n 4. Rented book \n 5.Returned book \n 6.Books that are not rented.");
            System.out.println(" \n  Enter your option : ");
            int option = myObj.nextInt();

            BookService bookService = context.getBean(BookService.class);

            switch (option) {
                case 1: {
                    bookService.addBook(10); // am pus un argument superficial ca sa se poata observa ca se afiseaza
                }
                break;
                case 2: {
                    bookService.display();
                }
                break;
                case 3:{
                    bookService.delete();
                }
                    break;
                case 4:{
                    bookService.rented();
                }
                    break;
                case 5:{
                    bookService.returned();
                }
                    break;
                case 6:{
                    bookService.displayRented();
                }
                break;
                default: System.out.println("Your option is not valid !");
            }

            System.out.println(" Enter 1 if you want another option. If not, enter 0. ");

            int choose_v = myObj.nextInt();
            choose = choose_v;

        }
    }
}
