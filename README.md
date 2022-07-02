# Java Compiler Tutorial

## How to compile

Compile multiple source files into byte code
`javac src/com/yilmaznaslan/MainApplication.java src/com/yilmaznaslan/Bus.java -d build/classes`

Using source files list
`javac -d build/classes @sourceFiles`

## Using a source file

Create an empty file that has the class names

```
src/com/yilmaznaslan/MainApplication.java
src/com/yilmaznaslan/Bus.java
```

## Install libraries

https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/
https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/

`https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.32/slf4j-simple-1.7.32.jar --output asd.jar`

## Examples

### Example2

In this example we will add more packages to application
`git checkout example2`



### Example3

`javac -cp "libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar" -d build/classes @sourceFiles`

`java -cp "build/classes:libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar" com/yilmaznaslan/MainApplication`


#### How to remove error marks in intellij

libs(right click) -> add as library -> click OK

You can also check the library files used in intelliJ
File -> Project Structure -> Libraries 