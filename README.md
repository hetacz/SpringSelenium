# test

![example workflow](https://github.com/hetacz/SpringSelenium/actions/workflows/gradle.yml/badge.svg)

## selenium grid

http://localhost:4444

docker-compose -f docker-compose.yml up
docker-compose up
docker-compose down


## ISO-8859-1 .properties encoding

https://native2ascii.net/

.properties are expected to not be utf-8 but iso~
to encode polish signs use above site, and copy results to .properties

example

```
flight.app.labels= Podr\u00f3\u017ce,Eksploruj,Atrakcje,Loty,Hotele
```

## amazon

```
@Value("s3://my-bucket/s3-demo")
private Resource s3resource;
```

No additional code
AWS core dependency needed
(you should have a permission)

## Injection occurs after BeforeTest but Before BeforeClass!!
