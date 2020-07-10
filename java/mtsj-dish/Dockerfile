# Deploy Java war
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine
WORKDIR /app/mtsj-dish
COPY --from=build /app/mtsj-dish/server/target/mtsjdish-bootified.war /app/mtsj-dish/
#HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 CMD curl --fail http://localhost:8082/mythaistar/services/rest/dishmanagement/v1/category/0/ || exit 1 
ENTRYPOINT ["java","-jar","/app/mtsj-dish/mtsjdish-bootified.war"]
EXPOSE 8082
