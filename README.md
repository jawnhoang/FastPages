# FastPages
University Name - SJSU 

Course: Enterprise Software - CMPE172/ Fall 2021
Team Members:

John Hoang  	014411072

Western Han  	012261964

Aryan Kumar 	012162371

Project Introduction:

This web application is intended to be an enterprise application aimed at school book stores/libraries so students can easily find and check out books they need in respected 
departments. Admins have the power to add/edit/remove books, departments, and authors and view a list of books that are checked out by what student.

Sample Demo Screenshots Found at Bottom
---------------------------------------




How to run:

1. Find and run WebappApplication.java in /src/main/java/edu.sjsu.project/

---------------------

Updating and Maintaining
1. any changes, always build as maven
2. run .jar

--------------------------

when importing, if src file not showing
1. file -> project strucutre -> modules
2. import module
3. locate FastPages folder and import entire folder.
this should fix.

------------

Please document all code done.

-------------------------
Creating Docker image:
1. Compile and then build as maven package
2. add file to main directory as "Dockerfile"

3. map: 
ex. 

FROM openjdk:15

ADD target/project-0.0.1-SNAPSHOT.jar fast-pages-image.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "fast-pages-image.jar"]

4. open terminal 
5. cd to code directory
6. build:
  
"docker build -f Dockerfile -t fast-pages-image . "
  
7. if build success -> run:
  
"docker run -p 8085:8085 fast-pages-image"
  
 -------------------------------------------
  To pull this application from docker:
  
  1. open powershell or terminal
  2. "docker pull johnhoang5/fast-page-final-ver"
  3. Open Docker Desktop
  4. Configure johnhoang5/fast-pages-image port to 8085
  ![image](https://user-images.githubusercontent.com/54566354/143793366-9c01ebbf-b81a-40d2-9cb1-83038c8ea0aa.png)
  5. run
  6. visit: http://localhost:8085/

---------------------------------------------------------------------------------------------------------------
Demo Screen Shots from Hosted Site
http://fastpages.us-west-1.elasticbeanstalk.com/

These screenshots captures main features of this application

Landing Page:
![image](https://user-images.githubusercontent.com/54566354/143793439-5e6582a0-350e-4c2f-af21-e67eb9ab529a.png)

Register:
![image](https://user-images.githubusercontent.com/54566354/143793458-2cf938e5-a27b-4a0d-94c7-ba378731b093.png)

Login:
![image](https://user-images.githubusercontent.com/54566354/143793467-1cf6aa8d-5e23-4b0c-954e-663f28ba1158.png)

User Home Page:
![image](https://user-images.githubusercontent.com/54566354/143793485-9917c099-251b-406d-80e4-880a3f8be746.png)

User Cataloge Page:
![image](https://user-images.githubusercontent.com/54566354/143793508-6ba13416-20da-4ff0-af33-ea74027aea16.png)

User checking out book Process:
![image](https://user-images.githubusercontent.com/54566354/143793526-db14b84c-7d3d-4562-b28a-b6b295d9ef94.png)

Checkout confirmation:
![image](https://user-images.githubusercontent.com/54566354/143793547-59c48e55-57c2-4b29-9314-2f8bd05d1c05.png)

All Books Current User Has Checked Out:
![image](https://user-images.githubusercontent.com/54566354/143793562-8ab32af3-1c91-4e28-a81e-4bbdd3126696.png)


Admin Home Page:
![image](https://user-images.githubusercontent.com/54566354/143793580-24635eae-349a-4de6-bbea-2a603090ce43.png)

Admin Panel (Shows all books checked out):
![image](https://user-images.githubusercontent.com/54566354/143793604-7c48bd5c-143c-4d8c-a606-af818e9f5826.png)

Admin Cataloge Page, Can edit/remove books:
![image](https://user-images.githubusercontent.com/54566354/143793623-163c843f-104a-436b-a575-97fd16a7dfbf.png)

Admin add new books/edit books Process:

Click Add Book:

![image](https://user-images.githubusercontent.com/54566354/143793645-9593bfc6-8738-48f2-a4eb-1d2b2e33a7dc.png)

Add Info:

![image](https://user-images.githubusercontent.com/54566354/143793658-2d16bb0a-7593-431a-8261-f0097faebd3d.png)



---------------------------------------------------
System Diagram:

![image](https://user-images.githubusercontent.com/54566354/143795412-ae245c22-6412-4199-af3d-9b6d7ac01367.png)

Class Diagram:

![image](https://user-images.githubusercontent.com/54566354/143795473-56d1c7d0-7572-4df0-bbf8-b6185d7d3520.png)

Sequence Diagram:

![image](https://user-images.githubusercontent.com/54566354/143795492-ed462fde-7533-4337-bba0-9cd959a50659.png)

Interaction Diagram:

![image](https://user-images.githubusercontent.com/54566354/143795499-c5622027-d01a-4bd5-83eb-3dd32d121843.png)

DB Schema Diagram:

![image](https://user-images.githubusercontent.com/54566354/143795505-e3fd9d7c-20a3-4d3c-bb56-143d43b9efc0.png)




