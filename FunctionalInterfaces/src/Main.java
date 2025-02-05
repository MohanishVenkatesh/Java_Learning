import ConsumerFunctionalInterface.BookDonationExample;
import ConsumerFunctionalInterface.ConsumerFiExample;
import Model.Book;
import Model.Donor;
import SupplierFunctionalInterface.DonationReceiptGenerateExample;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("###################################### Example 1 ##############################################################");
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

        bookDonationExample.donateBooks(books, donor);

        System.out.println("###################################### Example 2 ##############################################################");
        /* Example 2 using Supplier Functional Interface : Generating a unique Donation Receipt Number */

        DonationReceiptGenerateExample donationReceiptGenerateExample = new DonationReceiptGenerateExample();

        books.forEach(eachBook -> System.out.println(eachBook.getTitle() + " -> " + donationReceiptGenerateExample.generateDonationReceipt()));

        System.out.println("###################################### Example 3 ##############################################################");
        /* Example 3 using both Supplier and Consumer functional interface. Passing them as a argument to another method */
        SecureRandom secureRandom = new SecureRandom();
        long uniqueNumber = secureRandom.nextLong();

        Main.processDonation(books, donor, eachBook -> {
            System.out.printf("Book with the title : %s is donated by %s %n", eachBook.getTitle(), eachBook.getDonor().getName());
        }, () -> "DON-" + LocalDateTime.now() + "-" + String.valueOf(uniqueNumber).replace("-", ""));
    }


    private static void processDonation(List<Book> books, Donor donor, Consumer<Book> donateLogConsumer, Supplier<String> generateReceiptNoSupplier) {

        books.forEach(eachBook -> {
            eachBook.setDonor(donor);
            donateLogConsumer.accept(eachBook);
            System.out.printf("Unique Number for Book Title %s is %s %n", eachBook.getTitle(), generateReceiptNoSupplier.get());
        });

    }
}