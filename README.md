# Sharing files between services via Docker Compose

This Docker Compose project contains two services: one implemented in Java and the other in Python. The Java service retrieves text data from a specified URL and saves it to a file, while the Python service reads the content of the file and prints it.

## Prerequisites
Before running this project, ensure you have Maven, Docker and Docker Compose installed on your system.

## Usage
1. Clone this repository to your local machine:

2. Navigate to the project directory:

3. Build and start the Docker containers using Docker Compose:
`docker-compose up --build`
This command will build the Docker images for the Java and Python services and start both containers.

We build the Java's image from the accompanying `dockerfile`. There we will:
a) Create the `JAR` file for our maven project from the corresponding `pom.xml` and `src` directories.
b) With separate `RUN` command download the dependecies. This will help us to reuse this cached layer if we would like to rebuild the image. In that case `docker` will restart from COPY src . layer (therefore not re-downloading all dependencies).

The Python servie will wait till the Java completes successfully before being launched. This is achieved via a combination of `depends_on` and `condition: service_completed_successfully` in `docker-compose.yml`.

Once the Java's service has completed successfully it produces a `.txt` file. To share the file between otherwise isolated containers we use mount a volume from "maven" service into the "python service.
Pros:
- This makes the data produced by "maven" accessible from "python".
Cons:
- The files will note be persistently stored i.e. will be stored only within Docker session. But, we don't want them to be persistent here for our purposes.

4. Once both services have completed their tasks, you will see the output of the Python service, which will display the text retrieved by the Java service.

## License
This project is licensed under the MIT License.