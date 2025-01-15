ARG JAVA_VERSION=21.0.5


################################### BASE JAVA ##################################

FROM amazoncorretto:${JAVA_VERSION}-alpine3.20 AS base-java

WORKDIR /app


##################################### BUILD ####################################

FROM base-java AS build

COPY ./gradlew ./gradlew
COPY ./gradle ./gradle
COPY ./settings.gradle.kts ./settings.gradle.kts
COPY ./build.gradle.kts ./build.gradle.kts

RUN ./gradlew dependencies

COPY ./src ./src

RUN ./gradlew build \
    --warning-mode all \
    --exclude-task test


################################## DEVELOPMENT #################################

FROM build AS development

CMD ["./gradlew", "run"]


#################################### TESTING ###################################

FROM build AS testing

CMD ["./gradlew", "test"]


################################## PRODUCTION ##################################

FROM base-java AS production

COPY --from=build /app/build ./build

ENTRYPOINT ["java", "-jar", "./build/libs/application.jar"]
