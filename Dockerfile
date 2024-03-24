FROM bellsoft/liberica-openjdk-alpine:17-cds

#Work directory
WORKDIR  /home/workdirectory

# adding files
ADD target/docker-resources ./