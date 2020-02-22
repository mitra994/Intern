# Explanation
 
 
The Application consists of a couple of Parts.

1. Data - which consists of DiscountCards Package, Customer and Purchase classes.
2. StorePayDesk - consists of a DeskCalculator and PayDesk class.
3. Main class as en Entry Point.

In the application Main class (Entry Point) i created an instances of a three different customers and three different DiscountCard classes 
Bronze, Silver and Gold. 

Each Customer has customerId, customerName and DiscountCard fields.

Each of the DiscountCard child classes extend DiscountCard abstract class. DiscountRate of a single card is calculated during making an instance of a class by running the code in its constructor. There is also a Guest class whichis used in case the discount card field of a customer is null.

Running a static method commitPurchase() of a PayDesk class, with "purchaseValue" and Customer object as arguments, we get console output as reguested.

PayDesk class has two helper methods, calculatePurchase() which uses DeskCalculator and makes an instance of a Purchase class and 
printReceipt() method which gets info from a DiscountCard and Purchase objects and prints them on a console.

