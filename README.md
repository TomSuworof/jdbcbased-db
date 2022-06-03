# ```jdbcbased-bd```

UI and server for accessing PostgreSQL using JDBC

All operations performed with SQL functions. Some of them use
dblink from PostgreSQL Pro. All used functions and scripts
for them could be found in folder
[scripts](./backend/src/main/resources/scripts).

## Screenshots

### Operations with items

![img.png](screenshots/img.png)

Main page with filled data

![img_1.png](screenshots/img_1.png)
![img_2.png](screenshots/img_2.png)

Adding new item

![img_3.png](screenshots/img_3.png)
![img_4.png](screenshots/img_4.png)

Editing item

![img_5.png](screenshots/img_5.png)
![img_6.png](screenshots/img_6.png)

Removing item

![img_7.png](screenshots/img_7.png)
![img_8.png](screenshots/img_8.png)

Search and delete by query

### Operations with databases

![img_9.png](screenshots/img_9.png)
![img_10.png](screenshots/img_10.png)

List of databases (displays only databases with 'jdbc_' prefix)

![img_11.png](screenshots/img_11.png)
![img_12.png](screenshots/img_12.png)
![img_13.png](screenshots/img_13.png)

Adding new database

![img_14.png](screenshots/img_14.png)

New database have needed tables and columns

![img_15.png](screenshots/img_15.png)
![img_16.png](screenshots/img_16.png)
![img_17.png](screenshots/img_17.png)

Deleting database

### User management

![img_18.png](screenshots/img_18.png)
![img_19.png](screenshots/img_19.png)
![img_20.png](screenshots/img_20.png)
![img_21.png](screenshots/img_21.png)
![img_22.png](screenshots/img_22.png)

User 'Chad' does not have access to table 'public' in database 'jdbc_test'

![img_23.png](screenshots/img_23.png)

And Chad does not have access to database 'jdbc_test2'

![img_24.png](screenshots/img_24.png)

We can create new user - superuser or casual. Superuser will have full access
to current database, casual will have read-only access to current database

![img_25.png](screenshots/img_25.png)
![img_26.png](screenshots/img_26.png)

We created new superuser 'new_pro' and they cleaned table

### Backups

![img.png](screenshots/img_27.png)
![img_1.png](screenshots/img_28.png)
![img_2.png](screenshots/img_29.png)

Backups in CSV and XLSX

Uploading backups not working since there are problems with requests