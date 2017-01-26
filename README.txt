-----------------
REQUIREMENTS:
----------------
-> java 1.8


---------------------
HOW TO RUN:
---------------------

setting up database:

->run db.sql in mysql command line to create the database with required tables as follows:
   $ source <path of db.sql>	

->after creating the database,you can insert the employee details into employee table or 
  you can also use the default entries in the table. The default entries can be found in the
  db.sql.
	
->you must change the username and password of mysql database in config.yml and also 
  give the url of your mysql server in config.yml.


running server:

->run test.jar file in command prompt with arguments as follows:
 $ java -jar test.jar server config.yml

->open browser and enter localhost:8080 to view the application. 

---------------------
SOURCE FILES:
---------------------

->you can see the source files in backend and frontend folders.



