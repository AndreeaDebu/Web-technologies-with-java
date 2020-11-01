package service;

import classes.Book;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.*;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(int i){

        bookRepository.addBook(i);
        System.out.println(" The book is added!");

    }

    public void display(){
       bookRepository.display();
    }

    public void delete (){

        bookRepository.deletedBook();
        System.out.println(" The book is deleted!");

    }

    public void rented (){

        bookRepository.rentedBook();
        System.out.println("The book is rented!");

    }

    public void returned (){

        bookRepository.returnedBook();
        System.out.println("The book is returned!");

    }

    public void displayRented(){

        bookRepository.displayRented();

    }


}
