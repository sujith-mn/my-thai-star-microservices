# Deploy Java war
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine
WORKDIR /app/mtsj-order
COPY --from=build /app/mtsj-order/server/target/mtsjorder-bootified.war /app/mtsj-order/
#HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 CMD curl --fail http://localhost:8085/mythaistar/services/rest/dishmanagement/v1/category/0/ || exit 1 
ENTRYPOINT ["java","-jar","/app/mtsj-order/mtsjorder-bootified.war"]
EXPOSE 8085
