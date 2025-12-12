**Spring Boot + MyBatis**

In MyBatis, I skip XML entirely and use annotations on mapper interfaces. This makes the project cleaner and easier to maintain for small-to-medium applications. Here’s a full Spring Boot + MyBatis annotation-based web app.

Used Features of this Annotation-Based Setup:  
1.	No XML files needed — all SQL is in mapper interface annotations.  
2.	Spring Boot auto-detects mappers via **@Mapper**.    
3.	Transactions handled via **@Transactional** in the service layer.  
4.	Auto-generated keys work with **@Options**.  
5.	Works with any database (H2, MySQL, PostgreSQL) by changing the datasource config.  
