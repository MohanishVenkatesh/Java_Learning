Scenario:
You are working on a library management system. 
You need to implement a book donation feature where each book donated needs to be processed by a system to add it to
the library's inventory. Once a book is added, the system needs to log the donation with details about the donor and the donated book.



Task:

Create a Book class with properties like title, author, and ISBN.
Create a Donor class with properties like name and contact.
Write a method donateBook that accepts a Book and a Donor and logs the donation.
Use the Consumer functional interface to implement a function that will:
Add a book to the inventory.
Log the donor details.
The system should process multiple donations at once.
Requirements:
Book class with the fields: title, author, and isbn.
Donor class with the fields: name and contact.
Create a method processDonation that takes a list of books and donors and uses a Consumer to log each donation.
Use the Consumer interface to create a logging mechanism for each donation.