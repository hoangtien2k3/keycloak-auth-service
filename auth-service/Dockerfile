FROM amazoncorretto:21.0.3 as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM  amazoncorretto:21.0.4
LABEL com.hoangtien2k3.ecom.auth.version="1.0.0"
LABEL version="1.0.0"
LABEL description="auth service"
LABEL author="hoangtien2k3 Flatform"
WORKDIR application

#timezone +7
ENV TZ=Asia/Ho_Chi_Minh

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
EXPOSE 8089
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
