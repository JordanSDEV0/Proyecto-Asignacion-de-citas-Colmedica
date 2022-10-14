/*Create the database with docker*/
FROM postgres
COPY ./create.sql /docker-entrypoint-initdb.d
COPY ./inserts.sql /docker-entrypoint-initdb.d
ENV POSTGRES_PASSWORD=1234
#ENV POSTGRES_DB=appointments
