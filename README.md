# Crooked

[![Build Status](https://travis-ci.org/greatjapa/crooked.svg?branch=master)](https://travis-ci.org/greatjapa/crooked)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](https://github.com/greatjapa/crooked/blob/master/LICENSE)

The word 'crooked' is a skate trick name. I'm a huge fan of skateboarding and when I started to develop open source projects, I decided to use skate tricks as project names.

## How to build

```sh
git clone https://github.com/greatjapa/crooked.git
cd crooked
mvn package
```

## How to run

The `mvn package` command produces a fat-jar that contains the entire code needed to run. So, to run our endpoint you just need to run the following command:

```sh
java -jar target/crooked-0.0.1-SNAPSHOT.jar server crooked.yml
```

The `crooked.yml` contains our endpoint configuration. The default configuration is:

```yml
storage: inMemory
algorithm: levenshtein
```

The `storage` property defines how the endpoint will store the given words. We have two options: `inMemory` or `redis`. If you want to define an redis server as storage, you need to define the property `redisHost`. For instance:

```yml
storage: redis
redisHost: localhost
algorithm: levenshtein
```
The `algorithm` property defines which algorithm will be used to find similar words. For now, we only have the option `levenshtein`.

## How to test

Crooked has 3 endpoints:
- POST /crooked/store/{word}
- GET  /crooked/show
- GET  /crooked/find?word={word}&threshold={number}	

As an example, you can store words using `curl` command:
```sh
curl -X POST http://localhost:8080/crooked/store/abacaxi
curl -X POST http://localhost:8080/crooked/store/banana
curl -X POST http://localhost:8080/crooked/store/maracuja
```

To see all words stored:
```sh
curl http://localhost:8080/crooked/show
```

To test find endpoint, try this:
```sh
curl http://localhost:8080/crooked/find?word=banan
curl http://localhost:8080/crooked/find?word=banan\&threshold=5
```
