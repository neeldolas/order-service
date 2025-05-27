# Use official OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven build artifact (adjust if needed)
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar

# Expose service port
EXPOSE 8083
# Debug port
EXPOSE 5006

# Run app
#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006", "-jar", "app.jar"]
