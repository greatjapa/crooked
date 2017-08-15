# Crooked

[![Build Status](https://travis-ci.org/greatjapa/crooked.svg?branch=master)](https://travis-ci.org/greatjapa/crooked)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](https://github.com/greatjapa/crooked/blob/master/LICENSE)

## How to build

```sh
git clone https://github.com/greatjapa/crooked.git
cd crooked
mvn package
```

## How to run

```sh
java -jar target/crooked-0.0.1-SNAPSHOT.jar server crooked.yml
```

## How to test

```sh
curl -X POST http://localhost:8080/crooked/store/abacaxi

```
### Examples

