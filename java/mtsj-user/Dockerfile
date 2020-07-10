# Deploy Java war
FROM adoptopenjdk/openjdk11:jre-11.0.4_11-alpine
WORKDIR /app/mtsj-user
COPY --from=build /app/mtsj-user/server/target/mtsjuser-bootified.war /app/mtsj-user/
#HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 CMD curl --fail http://localhost:8086/mythaistar/services/rest/dishmanagement/v1/category/0/ || exit 1 
ENTRYPOINT ["java","-jar","/app/mtsj-user/mtsjuser-bootified.war"]
EXPOSE 8086
