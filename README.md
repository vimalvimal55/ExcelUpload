# ExcelUpload
this simple tool read the excel and sends an email


pre-requirements 
JAVA 1.8
Maven 3.2.5


check out this in folder and run a following commands 

mvn clean install
java -jar target/gs-spring-boot-0.1.0.jar > log.txt


once the log file is created after a minute 

hit the following url 

http://localhost:8080/sendEmail?fileName=Book1

