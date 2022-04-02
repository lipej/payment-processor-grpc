ARG BUILD_HOME=/paymentprocessor

FROM gradle:7.4.2-jdk11 AS BUILDER

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

COPY --chown=gradle:gradle . $APP_HOME/

RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:debianslim-slim AS RUNNER

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME  

COPY --from=BUILDER $APP_HOME/build/libs/payment-processor-*-all.jar paymentprocessor.jar

ENV CIELO_ID=teste
ENV CIELO_KEY=teste

EXPOSE 50051

CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "paymentprocessor.jar"]