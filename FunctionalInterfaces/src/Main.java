import Constants.BookFilterType;
import Constants.Genre;
import ConsumerFunctionalInterface.BookDonationExample;
import ConsumerFunctionalInterface.ConsumerFiExample;
import Dtos.FilterDto;
import FunctionFunctionalInterface.FormatedSummaryExample;
import Model.Book;
import Model.Donor;
import PredicateFunctionalInterface.BookPresentOrNotExample;
import SupplierFunctionalInterface.DonationReceiptGenerateExample;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
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

        Book book1 = new Book();
        book1.setTitle("The Alchemist");
        book1.setAuthor("Paulo Coelho");
        book1.setPublisher("HarperOne");
        book1.setIsbn("978-0061122415");
        book1.setPages(208);
        book1.setYear(1993);
        book1.setGenre(Genre.FICTION);
        book1.setDonor(new Donor("Alice"));

        // Second Book
        Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setAuthor("Robert C. Martin");
        book2.setPublisher("Prentice Hall");
        book2.setIsbn("978-0132350884");
        book2.setPages(464);
        book2.setYear(2008);
        book2.setGenre(Genre.FICTION);
        book2.setDonor(new Donor("Bob"));

        // Third Book
        Book book3 = new Book();
        book3.setTitle("Atomic Habits");
        book3.setAuthor("James Clear");
        book3.setPublisher("Avery");
        book3.setIsbn("978-0735211292");
        book3.setPages(320);
        book3.setYear(2018);
        book3.setGenre(Genre.BIOGRAPHY);
        book3.setDonor(new Donor("Charlie"));

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        bookDonationExample.donateBooks(books, donor);

        System.out.println("###################################### Example 2 ##############################################################");
        /* Example 2 using Supplier Functional Interface : Generating a unique Donation Receipt Number */

        DonationReceiptGenerateExample donationReceiptGenerateExample = new DonationReceiptGenerateExample();

        books.forEach(eachBook -> System.out.println(eachBook.getTitle() + " -> " + donationReceiptGenerateExample.generateDonationReceipt()));

        System.out.println("###################################### Example 3 ##############################################################");
        /* Example 3 using both Supplier and Consumer functional interface. Passing them as an argument to another method */
        SecureRandom secureRandom = new SecureRandom();
        long uniqueNumber = secureRandom.nextLong();

        System.out.println("Implementation 1 :"); // Supplier method using SecureRandom to get a unique number
        Main.processDonation(books, donor, eachBook -> {
            System.out.printf("Book with the title : %s is donated by %s %n", eachBook.getTitle(), eachBook.getDonor().getName());
        }, () -> "DON-" + LocalDateTime.now() + "-" + String.valueOf(uniqueNumber).replace("-", ""),
                eachbook -> String.format(" This is a detailed Summary of the Book %s.%n " + "This book is written by %s. %n This book Genre is %s . And this book is published by %s with a ISBN number %s ", eachbook.getTitle(), eachbook.getAuthor(), eachbook.getGenre(), eachbook.getPublisher(), eachbook.getIsbn()));

        System.out.println("Implementation 2 :"); // Supplier method using UUID to get a unique string.
        Main.processDonation(books, donor, eachBook -> {
            System.out.printf("Book with the title : %s is donated by %s %n", eachBook.getTitle(), eachBook.getDonor().getName());
        }, () -> "DON-" + LocalDateTime.now() + "-" + UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0,5),
                eachbook -> String.format(" This is a detailed Summary of the Book %s.%n " + "This book is written by %s. %n This book Genre is %s . And this book is published by %s with a ISBN number %s ", eachbook.getTitle(), eachbook.getAuthor(), eachbook.getGenre(), eachbook.getPublisher(), eachbook.getIsbn()));


        System.out.println("###################################### Example 4 ##############################################################");
        // Example 4 using Function Functional Interface.

        FormatedSummaryExample formatedSummaryExample = new FormatedSummaryExample();
        books.forEach(eachbook -> System.out.println(formatedSummaryExample.generateFormatedBookSummary(eachbook)));

        System.out.println("###################################### Example 5 ##############################################################");
        // Example 5 using Predicate Functional Interface
        BookPresentOrNotExample bookPresentOrNotExample = new BookPresentOrNotExample();
        FilterDto filterDto = new FilterDto();
        filterDto.setBookFilterType(BookFilterType.author);
        filterDto.setBookFilterValue("James clear");
        filterDto.setBookList(books);
        System.out.println(bookPresentOrNotExample.isBookPresentOrNot(filterDto));
    }

    private static void processDonation(List<Book> books, Donor donor, Consumer<Book> donateLogConsumer, Supplier<String> generateReceiptNoSupplier
    , Function<Book,String> generateFormatedBookSummary) {

        books.forEach(eachBook -> {
            eachBook.setDonor(donor);
            donateLogConsumer.accept(eachBook);
            System.out.printf("Unique Number for Book Title %s is %s %n", eachBook.getTitle(), generateReceiptNoSupplier.get());
            System.out.println(generateFormatedBookSummary.apply(eachBook));
        });

    }
}