package Dtos;

import Constants.BookFilterType;
import Model.Book;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterDto {
    private BookFilterType bookFilterType;
    private String bookFilterValue ;
    private List<Book> bookList;
}
