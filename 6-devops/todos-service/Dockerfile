FROM openjdk:21-ea-17-slim-buster as stage1
WORKDIR extracted
ADD ./target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract


FROM openjdk:21-ea-17-slim-buster
WORKDIR application
COPY --from=stage1 extracted/dependencies/ ./
COPY --from=stage1 extracted/spring-boot-loader/ ./
COPY --from=stage1 extracted/snapshot-dependencies/ ./
COPY --from=stage1 extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]