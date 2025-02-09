package PredicateFunctionalInterface;

import Dtos.FilterDto;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public class BookPresentOrNotExample {

    public String isBookPresentOrNot(FilterDto filterDto) {
        Predicate<FilterDto> filterDtoPredicate =  filterDto1 -> {
            AtomicBoolean isPresent = new AtomicBoolean(false);
            return switch (filterDto1.getBookFilterType()) {
                case title -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(book.getTitle().equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
                case author -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(book.getAuthor().equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
                case publisher -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(book.getPublisher().equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
                case isbn -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(book.getIsbn().equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
                case year -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(String.valueOf(book.getYear()).equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
                case genre -> {
                    filterDto1.getBookList().forEach(book -> isPresent.set(book.getGenre().toString().equalsIgnoreCase(filterDto.getBookFilterValue().trim())));
                    yield isPresent.get();
                }
           };
        };
        return filterDtoPredicate.test(filterDto)?"Book is available in the inventory":"Book isn't available";
    }
}
