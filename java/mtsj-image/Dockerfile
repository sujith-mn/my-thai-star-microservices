# Deploy Java war
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine
WORKDIR /app/mtsj-image
COPY --from=build /app/mtsj-image/server/target/mtsjimage-bootified.war /app/mtsj-image/
#HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 CMD curl --fail http://localhost:8084/mythaistar/services/rest/dishmanagement/v1/category/0/ || exit 1 
ENTRYPOINT ["java","-jar","/app/mtsj-image/mtsjimage-bootified.war"]
EXPOSE 8084
