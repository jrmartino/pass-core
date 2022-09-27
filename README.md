# Introduction

This module is responsible for PASS backend services.

# Building

Java 11 and Maven 3.8 required.

```
mvn clean package
```

This will produce an executabler jar `pass-core-main/target/pass-core-main.jar`.

# Running local build

```
java -jar pass-core-main.jar
```

By default an in memory database is used.

Look at http://localhost:8080/ to see the auto-created documentation and a UI for testing out the api.

You can directly make request with the UI and see what happens. Note when doing a POST to create an object, be sure to edit the type field to have the correct object type and delete the id field to have the id auto-generated.

## Running with Docker

This uses Postgres.

In pass-core-main run:
```
docker-compose up -d
```

If you want to build an image, 

# Using JSON API

All of our data model is available, just divided into attributes and relationshiops. Note that ids are now integers, not URIs.

## Creating a RepositoryCopy

```
curl -v -X POST "http://localhost:8080/object/repositoryCopy" -H "accept: application/vnd.api+json" -H "Content-Type: application/vnd.api+json" -d @rc1.json
```

*rc1.json:*
```
{
  "data": {
    "type": "repositoryCopy",
    "attributes": {
      "accessUrl": "http://example.com/path",
      "copyStatus": "ACCEPTED"
    }
  }
}
```

## Patch a Journal

Add a publisher object to the publisher relationship in a journal. Note that both the journal and publisher objects must already exist.

```
curl -X PATCH "http://localhost:8080/object/journal/1" -H "accept: application/vnd.api+json" -H "Content-Type: application/vnd.api+json" -d @patch.json
```

*patch.json:*
 ```
 {
  "data": {
    "type": "journal",
    "id": "1",
    "relationships": {
      "publisher": {
        "data": {
          "id": "2",
          "type": "publisher"
        }
      }
    }
  }
}
```