# ramatest-Jul-26-2018

Part 1
Programming Challenge 1:
You are to create two small applications for this programming task; one is called Randomizer, the other Prime Randomizer‘s job is to generate a series of positive random integers and send those to Prime via a distributed queue of integers.
Primes job is to receive the integers and calculate whether the integer is a prime or not and return the answer to Randomizer via a distributed queue ( just a java Queue implementation , no need to implement JMS etc ) that contains the original number and a Boolean; which Randomizer will print to system out.


Points
1. Use only the standard java library
2. Both Applications will run on the same server
3. The system should be as fast as possible
4. The results do not have to be returned in the same order as received
5. You don’t have to go overboard tweaking the prime check
Deliverable
• A project with code – eclipse or any IDE that you are using. However, eclipse is preferable
• A Readme.txt should contain the following 
1. What is your design and implementation?
2. Sample Output
3. Further work – if you have all the time in the world how would you implement

Programming Challenge 2:
• Reverse of a string without reverse method.
• Find a palindrome
2) Please create a class for the below and send it,
We have a table which has 4 columns as id, name, phone and address.
You need to have a method which will return me the data.
Create a method where you can hard code the data and print the details.
The main aim of above example is how you use data structure.
