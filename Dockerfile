FROM tomcat:9.0-alpine
EXPOSE 8080
COPY target/e-commerce.war /usr/local/tomcat/webapps/
