FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
MAINTAINER chrys exaucet

ENV APP_ROOT /app
ARG JAR_FILE=target/*.jar
VOLUME /tmp

RUN addgroup -S hr && adduser -S hr-manager -G hr
RUN apk add --update curl \
    && rm -rf /var/lib/apt/lists/*
RUN mkdir ${APP_ROOT}

WORKDIR ${APP_ROOT}
COPY ${JAR_FILE} ${APP_ROOT}/app.jar

USER hr-manager:hr

ENTRYPOINT ["java"]
CMD ["java","-jar","app.jar"]