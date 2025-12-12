**Spring Boot + MyBatis**

In MyBatis, I skip XML entirely and use annotations on mapper interfaces. This makes the project cleaner and easier to maintain for small-to-medium applications. Here’s a full Spring Boot + MyBatis annotation-based web app.

Used Features of this Annotation-Based Setup:  
1.	No XML files needed — all SQL is in mapper interface annotations.  
2.	Spring Boot auto-detects mappers via **@Mapper**.    
3.	Transactions handled via **@Transactional** in the service layer.  
4.	Auto-generated keys work with **@Options**.  
5.	Works with any database (H2, MySQL, PostgreSQL) by changing the datasource config.  

Spring Boot + MyBatis (Annotation-Based) Architecture Flow
>
      ┌──────────────────────────┐
      │      Web Browser /       │
      │      REST Client         │
      └───────────────┬──────────┘
                      │   HTTP Request (GET/POST/PUT/DELETE)
                      ▼
      ┌───────────────────────────────────────────┐
      │              Controller                   │
      │   (UserController @RestController)        │
      │ - Maps URL requests                       │
      │ - Calls service layer                     │
      └───────────────┬───────────────────────────┘
                      │   Calls service methods
                      ▼
      ┌───────────────────────────────────────────┐
      │                Service                    │
      │         (UserService @Service)            │
      │ - Contains business logic                 │
      │ - Applies @Transactional                  │
      │ - Calls MyBatis mapper                    │
      └───────────────┬───────────────────────────┘
                      │  Calls mapper interface
                      ▼
      ┌───────────────────────────────────────────┐
      │         MyBatis Mapper (Annotation)       │
      │        (UserMapper @Mapper)               │
      │ - Contains SQL using annotations          │
      │   @Select, @Insert, @Update, @Delete      │
      │ - Maps SQL results to Java objects        │
      └───────────────┬───────────────────────────┘
                      │  Executes SQL
                      ▼
      ┌───────────────────────────────────────────┐
      │                Database                   │
      │     (H2 / MySQL / PostgreSQL / etc.)      │
      │ - Runs SQL queries                        │
      │ - Returns rows/data                       │
      └───────────────┬───────────────────────────┘
                      │   ResultSet mapped to POJO
                      ▼
      ┌───────────────────────────────────────────┐
      │                Service                    │
      │ - Receives mapped User object             │
      │ - Additional logic (optional)             │
      └───────────────┬───────────────────────────┘
                      │   Returns object
                      ▼
      ┌───────────────────────────────────────────┐
      │              Controller                   │
      │ - Converts object to JSON using Jackson   │
      └───────────────┬───────────────────────────┘
                      │   HTTP Response (JSON)
                      ▼
      ┌──────────────────────────┐
      │     Client (REST API)    │
      └──────────────────────────┘

✔ **Summary of Flow**  
1.	Client sends request → /users/1  
2.	Controller receives it and calls Service.  
3.	Service runs business logic and calls the MyBatis Mapper.  
4.	Mapper executes SQL using annotations.    
5.	Database returns the result.  
6.	MyBatis maps the result to a Java object (User).  
7.	Service returns the object to the Controller.  
8.	Controller returns JSON to the client.  

H2 Console:
<img width="683" height="600" alt="image" src="https://github.com/user-attachments/assets/fa7e16e6-c850-4570-95eb-b966f9fec2d2" />

Data from H2 Database:
<img width="795" height="517" alt="image" src="https://github.com/user-attachments/assets/24986b9a-a657-4efc-94c4-695020392d58" />



