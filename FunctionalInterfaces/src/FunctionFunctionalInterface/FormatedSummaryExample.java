package FunctionFunctionalInterface;

import Model.Book;
import java.util.function.Function;

public class FormatedSummaryExample {

    public String generateFormatedBookSummary(Book book) {

        // Implementation of Function Functional Interface
        Function<Book, String> generateSummary = eachbook -> String.format(" This is a detailed Summary of the Book %s.%n "
                + "This book is written by %s. %n This book Genre is %s . And this book is published by %s with a ISBN number %s "
                , eachbook.getTitle(), eachbook.getAuthor(), eachbook.getGenre(), eachbook.getPublisher(), eachbook.getIsbn());

        // Calling the abstract method of this Functional interface.
        return generateSummary.apply(book);
    }
}
