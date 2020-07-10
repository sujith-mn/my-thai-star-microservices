# Deploy Java war
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine
WORKDIR /app/mtsj-gateway
COPY --from=build /app/mtsj-gateway/server/target/mtsjgateway-bootified.war /app/mtsj-gateway/
#HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 CMD curl --fail http://localhost:8081/mythaistar/services/rest/dishmanagement/v1/category/0/ || exit 1 
ENTRYPOINT ["java","-jar","/app/mtsj-gateway/mtsjgateway-bootified.war"]
EXPOSE 8081
