package Model;

import Constants.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int pages;
    private int year;
    private Genre genre;
    private Donor donor;
}
