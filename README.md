# BookLibrary

![image](https://user-images.githubusercontent.com/73474619/213203247-1914b845-1b2c-49fa-bf07-13987548bc0d.png)

Console app made with Java and Jackson library for reading and writing CSV and JSON files. User passwords are being hashed before saving data. Has login/ register menu. Existing user can login and borrow/return books. Users with admin permissions have an extended menu with options to promote and demote users, run reports showing currently loaned books and the amount of times particular books have been loaned and save reports to CSV files.

## Features
1. On start, check if files books_data.json and users_data.json exist. If they exist go 2, if not go 3
2. Read books_data.csv and users_data.csv and create books_data.json and users_data.json
3. Shows login/register menu. Login go 4 and register go 5
4. If login succsessful menu with options appears go 6, if not writes an error message and returns to login register menu go 3
5. Register new user and write a new users_data.json
6. Main menu with extended options for librarians

* Mapper class helper functions for reading and converting CSV to JSON and vice versa
* Book and User classes
* Store - base abstract class for reading and writing files
* BookStore and UserStore extend Store class to expose special functionality
* LoanedBook and TimesLoaned make objects for writing reports
* InputReader and StringUtilities helper classes for reading user input and formatting output strings
* Consumer and Runnable customized interfaces
