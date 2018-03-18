FROM  openjdk:8
#copy file from our machine to the docker container
COPY discovery-service.jar discovery-service.jar

#Port this is just specifying what ports should e
EXPOSE 8761

CMD [ "java", "-jar","discovery-service.jar" ]