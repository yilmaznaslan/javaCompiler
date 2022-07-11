# Java Compiler Tutorial

## How to compile

### Example 1 - Compile multiple source files into byte code

`javac src/com/yilmaznaslan/MainApplication.java src/com/yilmaznaslan/Bus.java src/de/bvg/Train.java -d build/classes`

### Example 2 - Compile multiple files using a source file

Create an empty file that has the class names

```
src/com/yilmaznaslan/MainApplication.java
src/com/yilmaznaslan/Bus.java
src/de/bvg/Train.java
```

Using source files list
`javac -d build/classes @sourceFiles`

### Example 3 - Compile using external libraries

Delete the build directory if it was already created

`rm -r build/`

Install the following libraries

    https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/
    https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/

`curl https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.32/slf4j-simple-1.7.32.jar --output libs/slf4j-simple-1.7.32.jar`

`curl https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.32/slf4j-api-1.7.32.jar --output libs/slf4j-api-1.7.32.jar`


Compile

`javac -d build/classes @sourceFiles -cp ":libs/slf4j-api.17.32.jar:libs/slf4j-simple.1.7.32.jar"`