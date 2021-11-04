# FastPages

How to run:

1. Import project file as Maven Proj on IntelliJ
2. Build as MAven PAckage
3. Locate .jar file in target folder
4. run that bitch

---------------------

homepage of site is index.html

-----------------------

Updating and Maintaining
1. any changes, always build as maven
2. run .jar

--------------------------

for admin stuff run these sql commands (replace test with what your database name is)

SELECT * FROM test.roles;
SELECT * FROM test.users_roles;
SELECT * FROM test.user;

then in the result for roles, manually add id 1 as name USER and id 2 as name ADMIN

then go to the results for users_roles and find the id of the user you want to be admin in the results for user 
and put that number under user_id and put 2 in role_id of the same row and boom that user is now an admin

--------------------------
when importing, if src file not showing
1. file -> project strucutre -> modules
2. import module
3. locate FastPages folder and import entire folder.
this should fix.

------------
Not Connecting to RDS?
1. install a database plugin on intellij.
![image](https://user-images.githubusercontent.com/54566354/139971078-a4c2921f-b541-4765-9ca7-699357049549.png)
2. try again?



Please document all code done.
