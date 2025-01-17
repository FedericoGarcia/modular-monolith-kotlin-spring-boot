ARG JAVA_VERSION=21.0.5


################################### BASE JAVA ##################################

FROM amazoncorretto:${JAVA_VERSION}-alpine3.20 AS base-java

WORKDIR /app


################################# DEPENDENCIES #################################

FROM base-java AS dependencies

COPY ./gradlew ./gradlew
COPY ./gradle ./gradle
COPY ./settings.gradle.kts ./settings.gradle.kts
COPY ./build.gradle.kts ./build.gradle.kts

RUN ./gradlew dependencies \
    --no-daemon

COPY ./src ./src


##################################### BUILD ####################################

FROM dependencies AS build

RUN ./gradlew build \
    --no-daemon \
    --warning-mode all \
    --exclude-task test


################################## DEVELOPMENT #################################

FROM dependencies AS development

ENTRYPOINT ["./gradlew", "bootRun"]


#################################### TESTING ###################################

FROM dependencies AS testing

ENTRYPOINT ["./gradlew", "test"]


################################## PRODUCTION ##################################

FROM base-java AS production

COPY --from=build /app/build ./build

ENTRYPOINT ["java", "-jar", "./build/libs/application.jar"]
