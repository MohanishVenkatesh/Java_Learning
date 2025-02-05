import ConsumerFunctionalInterface.BookDonationExample;
import ConsumerFunctionalInterface.ConsumerFiExample;
import Model.Book;
import Model.Donor;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* Test Consumer Functional Interface*/
        ConsumerFiExample consumerFiExample = new ConsumerFiExample();
        consumerFiExample.ConsumerFiStringTest("It Works!!");

        /* Example 1 using Consumer Function Interface : Donating Books*/
        BookDonationExample bookDonationExample = new BookDonationExample();
        Donor donor = new Donor();
        donor.setName("Ameena");

        Book book = new Book();
        book.setTitle("Alchemist");
//        book.setDonor(donor);

        Book book1 = new Book();
        book1.setTitle("Naruto");
//        book1.setDonor(donor);

        Book book2 = new Book();
        book2.setTitle("One Piece");
//        book2.setDonor(donor);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        books.add(book2);

        bookDonationExample.donateBooks(books,donor);
    }
}