FROM openjdk:11

RUN apt-get update && \
    apt-get install -y git maven

#RUN mkdir /app
WORKDIR /app

# ENV GITHUB_REPO_URL=""
# ENV BRANCH_NAME=""

RUN git clone ${GITHUB_REPO_URL} /app
RUN git checkout ${BRANCH_NAME}

RUN mvn -N io.takari:maven:wrapper

CMD ["./mvnw", "test"]