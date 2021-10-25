FROM fabric8/java-alpine-openjdk11-jdk

COPY *.jar /server.jar

ADD run.sh /app/run.sh
RUN chmod +x /app/run.sh

ENTRYPOINT ["/app/run.sh"]