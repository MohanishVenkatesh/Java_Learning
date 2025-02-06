package ConsumerFunctionalInterface;

import Model.Book;
import Model.Donor;
import java.util.List;
import java.util.function.Consumer;

public class BookDonationExample {

    public void donateBooks(List<Book> donatedBooks, Donor donor) {


        // Implementation of Consumer Interface to log books
        Consumer<List<Book>> logInInventory = books -> books.forEach
                (book -> {
                            book.setDonor(donor);
                            System.out.printf("Book with the title : %s is donated by %s%n", book.getTitle(), book.getDonor().getName());
                            System.out.println("Successfully Logged into the System");
                        }
                );

        // Involving the abstract method of Consumer Interface to log a book
        logInInventory.accept(donatedBooks);
    }
}
