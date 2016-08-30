Test to reproduce exception on multi-module maven project.

Running this project with current setup works. (Spring Boot v1.3.7)
`mvn clean package`

But changing to Spring Boot v1.4.0 on root pom.xml breaks on `maven-compiler-plugin:3.1:testCompile` 
or `maven-surefire-plugin:2.18.1:test` if executing `mvn clean package`. 
If you call directly the test phase it works.

Example steps with Spring Boot 1.4.0:
```
mvn clean test #OK
mvn package -DskipTests #OK


mvn clean package -DskipTests #Fails on testCompile


mvn clean test #OK
mvn package #Fails on test
```

----

My machine configs:
```
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T17:41:47+01:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_65, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.6", arch: "x86_64", family: "mac"
```