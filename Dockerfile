FROM openjdk:8
EXPOSE 8080
ADD target/e-commerce.war e-commerce.war
ENTRYPOINT ["java","-war","/e-commerce.war"]
