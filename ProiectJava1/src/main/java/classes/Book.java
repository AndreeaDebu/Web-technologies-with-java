package classes;

public class Book {
    private String name;
    private String author;
    private boolean rented;

    public Book(){

    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.rented = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public void display(){
        System.out.print(" The book  " + name + " has the author  " + author + " and is");
        if (rented == true){
            System.out.println(" rented.");
        }else {
            System.out.println(" not rented.");
        }
    }

}
