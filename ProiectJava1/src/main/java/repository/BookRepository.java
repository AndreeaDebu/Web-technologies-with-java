package repository;

import classes.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

@Repository
public class BookRepository {

    public Map<Integer, Book> books = new HashMap<>();

    public void addBook(int i){

        int add_book = 1;
        while(add_book == 1){

            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the name of the book : ");
            String name = myObj.nextLine();

            System.out.println("Enter the author of the book : ");
            String author = myObj.nextLine();

            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);

            Random rand = new Random();
            int rand_id = rand.nextInt(1000);
            books.put(rand_id, book);

            System.out.println("Enter 1 if you want to enter more books. If not, enter 0. ");
            int nr = myObj.nextInt();
            add_book = nr;

        }

    }

    public void display(){
        books.forEach((k, v) -> {
            System.out.print("ID: " + k + " : ");
            v.display();
        });
    }

    public void displayRented(){
        books.forEach((k, v) -> {
            if(books.get(k).isRented() == false) {
                System.out.print("ID: " + k + " : ");
                v.display();
            }
        });
    }

    public void deletedBook(){

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter id:");
        int id = myObj.nextInt();

        if (books.containsKey(id)) {
            books.remove(id);
            System.out.println("The book is deleted!");
        } else
            System.out.println("The book is not found!");

    }

    public void rentedBook(){


        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the book id : ");
        int id = myObj.nextInt();

        if (books.containsKey(id)) {
            if(books.get(id).isRented() == true){
                System.out.println("The book is already reanted!");
            }else{
                books.get(id).setRented(true);
                System.out.println("The rented book!");
            }
        } else
            System.out.println("The book is not found !");
      }

    public void returnedBook(){


        Scanner myObj = new Scanner(System.in);
        System.out.println(" Enter the book id : ");
        int id = myObj.nextInt();

        if (books.containsKey(id)) {
            if(books.get(id).isRented() == true){
                books.get(id).setRented(false);
                System.out.println("The book returned!");
            }
        } else
            System.out.println("The book is not found !");

    }

}
