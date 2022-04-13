# IPAddressMgmt

## Overview
This is a RESTful API utilizing Spring Booth that allows for tracking of CIDR
IP addresses. The user is able to view all IP Addresses in the database, change
the status from "available" to "acquired" or "acquired" to "available", and add
a block of new addresses.

### REST API
Need to have a local server environment (like MAMP) running to utilize the
program. This can be accessed from http://localhost/8080/

### REST API Reference
|Return type       | HTTP Method | URI                                                 | Request Body| Reason  |
|------------------|-------------|-----------------------------------------------------|-------------|---------|
| List \<Address\> | GET         | /addresses                                          |             | List    |
| String           | GET         | /status/{addressId}                                 |             | Retrieve|
| Address          | PUT         | /update/{addressId}                                 |             | Update  |
| List \<Address\> | POST        | /add/{cidrStart}/{cidrEnd}                          |             | Add     |


### Technologies Used
+ mySQL workbench, mySQL, Java, Spring MVC Boot, Github, Gradle, Postman, MAMP
