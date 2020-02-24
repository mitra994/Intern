# Explanation
 
 
Market Store application consists of Data,PayDesk and Main as an Entry Point.

1.In the Data package there a DiscountCards, Customers and Purchase classes.

DiscountCard package consists of:

-DiscountCard abstract class with fields (CustomerName,
turnover and discountRate). DiscountCard as a parent class also has three abstract
methods getCardType, calculateDiscountRate and setTurnover.

The idea behind this was so that each child class can has its own calculateDiscountRate method based on the card type and so
that calculateDiscountRate() can be called each time turnover is set, so each times turnover changes, discountRate get recalculated.

-DiscountCard child classes which extend the abstract class and implement abstract methods.

2.PayDesk class has a static method checkOut() which takes a double (purchaseValue) and Customer object as arguments.
Using DeskCalculator class and calculatePurchase() method, calculates a discount and Total and makes a new instance of Purchase class.
printRecepit() method uses a Purchase instance and info from the card to print a receipt.

3. Main class as EntryPoint. 
I first made an instance of a Customer objects with id,name, next, and instances of DiscountCard objects and changed their turover value (cards have a default turover of 0 when instatiated).
Calling PayDesk.checkout() method double purchaseValue and Customer as arguments we get output on a console. If the Customer doesn't have DiscountCard assosiated with it, PayDesk will print Guest receipt
