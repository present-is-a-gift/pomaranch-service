FROM amazoncorretto:17
WORKDIR /app
COPY /build/libs/pomaranch-service-1.0.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pomaranch-service-1.0.jar"]