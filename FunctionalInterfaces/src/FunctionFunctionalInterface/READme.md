Scenario: Formatting Book Details for Display
In the library management system, after a donor donates a book,
the system needs to generate a formatted summary of the book details before logging them into the system.

You need to use the Function<T, R> functional interface to convert a Book object into a formatted string description.

Task:
Modify the processDonation method to generate a formatted book summary before logging it.
Use the Function<Book, String> interface to convert a Book object into a formatted string.
Display the formatted summary along with the donor details and donation receipt number.