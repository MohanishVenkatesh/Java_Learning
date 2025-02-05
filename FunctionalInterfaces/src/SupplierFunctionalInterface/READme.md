Scenario: Generating a Unique Donation Receipt Number
In the library management system, every time a donor donates a book, 
the system needs to generate a unique donation receipt number for tracking purposes.

You need to use the Supplier<T> functional interface to generate a random receipt number whenever a book is donated.

Task:
Modify the processDonation method to generate a unique receipt number for each donation.
Use the Supplier<String> interface to generate a random receipt ID in the format:
DON-<current_timestamp>-<random_number>
Display the receipt number along with the book and donor details.