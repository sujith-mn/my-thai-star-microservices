# maven:3.6-jdk-11-onbuild

FROM maven:3.6-jdk-11 AS build
RUN mkdir -p /app/mtsj-booking
WORKDIR /app/mtsj-booking
COPY mtsj-booking/ /app/mtsj-booking
RUN mvn clean install

run mkdir -p /app/mtsj-dish
WORKDIR /app/mtsj-dish
COPY mtsj-dish/ /app/mtsj-dish
RUN mvn clean install

run mkdir -p /app/mtsj-gateway
WORKDIR /app/mtsj-gateway
COPY mtsj-gateway/ /app/mtsj-gateway
RUN mvn clean install

run mkdir -p /app/mtsj-image
WORKDIR /app/mtsj-image
COPY mtsj-image/ /app/mtsj-image
RUN mvn clean install

run mkdir -p /app/mtsj-order
WORKDIR /app/mtsj-order
COPY mtsj-order/ /app/mtsj-order
RUN mvn clean install

run mkdir -p /app/mtsj-user
WORKDIR /app/mtsj-user
COPY mtsj-user/ /app/mtsj-user
RUN mvn clean install
