# Computer Shop System

A system for a computer shop. Allows customers to purchase items and an admin to change products in stock.

## Table of contents
* [Technologies](#technologies)
* [Software](#software)
* [Possible errors](#possible-errors)
* [User manual](#user-manual)
  * [User Accounts](#user-accounts)
    * [Admin](#admin)
      * [Adding new products to a stock](#adding-new-products)
    * [Customers](#customers)
      * [Filters](#filters)
      * [Adding to basket](#adding-products-to-a-basket)
      * [Saving and cancelling](#saving-and-cancelling)
* [Class diagram](#class-diagram)

## Technologies:
* Java

## Software used:
* Eclipse

## Possible errors
* Make sure that text files are in the same folder as computer_shop.jar file.

## User manual

### User accounts:
#### Admin: 
* user1

##### Adding new products:
Make sure that Barcode is 6 digits long and is not already stored in a database!

#### Cusotmers:
* user2
* user3
* user4

##### Filters:
  You can filter products to see the ones:
  * by Logitech
  * keyboards with UK layout
  * both of the above at the same time

##### Adding products to a basket:
  1) Click on desired product
  2) Change the amount
  3) Press "Add to basket"

##### Saving and cancelling
Suitable record in LogFile.txt is created, however
**items will not be restored the next time you log in, even if you use "save"**

## Class diagram
![class diagram](https://github.com/abetlej/computer-shop/blob/master/ClassDiagram.jpg)
