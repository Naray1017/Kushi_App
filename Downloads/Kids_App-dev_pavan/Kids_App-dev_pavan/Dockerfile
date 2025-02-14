# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application port (change if needed)
EXPOSE 1235

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
