FROM centos

RUN yum install -y java

VOLUME /tmp

ADD /target/recipes-0.0.1-SNAPSHOT.jar recipesapp.jar

RUN sh -c 'touch recipesapp.jar'

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/recipesapp.jar"]