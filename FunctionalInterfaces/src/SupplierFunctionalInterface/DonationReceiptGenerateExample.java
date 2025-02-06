package SupplierFunctionalInterface;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class DonationReceiptGenerateExample {
    public String generateDonationReceipt() {

        /* Generate Random Number */
        SecureRandom secureRandom = new SecureRandom();
        long uniqueNumber = secureRandom.nextLong();
        // Implementation for Supplier.
//        Supplier<String> uniqueReceipt = () -> "DON-" + LocalDateTime.now() + "-" + UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0,3);
        Supplier<String> uniqueReceipt = () -> "DON-" + LocalDateTime.now() + "-" + String.valueOf(uniqueNumber).replace("-","");
        // Calling the abstract method of the Supplier Functional Interface.
        return  uniqueReceipt.get();
    }



}
