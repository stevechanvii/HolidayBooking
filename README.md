# Holiday Booking System

The Holiday Booking System is available for both web and desktop application which can be used by workers and publics. 

This project uses JavaEE (EJB) as backend and HTML + JavaScript + CSS for frontend, MVC model and Restful web service are introduced in the project and Security and Authentication Services (JAAS) is used to improve security.

### Project Description
In the Holiday Booking System, user can register, log in and search for transactions. After log in, the system need to recognize the user type, if the user type is public, they can manage transactions and the profile of himself. If the user type is Worker, they can not only manage the transactions, but also manage users.

A public user can search transactions and register as a public user, some information need to be provided. If a user register as a worker, he/she will have administration access to modify and edit another user.

## Getting Started

### Prerequisites

JDK 1.8.0_141

IDE:  
Netbeans 8.2

## Versioning
[V1] Only booking page for searching is provided, so I created a session bean to manage all the functions.  
[V2] More function such as user management, transaction management need to be implemented. So, I choose a memory saving approach, the managed beans are changed to requested scope because once user request for a page, the web site is no longer active.  
[V3] JAAS is implemented in this version as well as GUI. Therefore, the application needs to be restructured, I firstly created a new version and connected the application to JAAS API, then moved the second version to third version, the file structure is changed so new hypertext need to be changed. 

## Example
Client booking
![Screenshot](/img/booking.png)

Client searching
![Screenshot](/img/searching.png)

Admin manage booking
![Screenshot](/img/manage_booking.png)

Admin manage transaction
![Screenshot](/img/manage_transaction.png)

Admin manage clients
![Screenshot](/img/user_management.png)

Desktop application for searching
![Screenshot](/img/app.png)

## Authors

* **Danyang Chen** - *Developer & System Architect* - [SteveChanVII](https://github.com/stevechanvii/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

