# FastPages

How to run:

1. Find and run WebappApplication.java in /src/main/java/edu.sjsu.project/

---------------------

homepage of site is index.html

-----------------------

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

ADD target/<maven jar file> <name of image>.jar
  
EXPOSE 8080
  
ENTRYPOINT ["java", "-jar", "<name of image>.jar"]

4. open terminal 
5. cd to code directory
6. build:
  
"docker build -f Dockerfile -t <name of image> . "
  
7. if build success -> run:
  
"docker run -p 8085:8085 <name of image>"
