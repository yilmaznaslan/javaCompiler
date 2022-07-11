# Java Compiler Tutorial

## How to compile

### Example 1 - Compile multiple source files into byte code
`javac src/com/yilmaznaslan/MainApplication.java src/com/yilmaznaslan/Bus.java src/de/bvg/Train.java -d build/classes`

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
In this example we will download and use java libraries in jar format.

#### Install libraries

####  Compile
`javac -cp "libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar" @sourceFiles -d build/classes`

or you can also create an environmental variable called `CLASSPATH` and 
```
export CLASSPATH=":build/classes:libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar"
javac @sourceFiles -d build/classes
```

#### Run
`java -cp ":build/classes:libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar" com/yilmaznaslan/MainApplication`
 


#### How to remove error marks in intellij

libs(right click) -> add as library -> click OK

You can also check the library files used in intelliJ
File -> Project Structure -> Libraries 


## 2. How to package the application - creating JAR Files
The basic format of the command for creating a JAR file is:

`jar cf jar-file input-file(s)`

### Creating executable JAR

1. Create the `MANIFEST.MF` file
   `cd mkdir META-INF && cd META-INF && touch MANIFEST.MF`

2. Add Main Class information
   `echo "Main-Class: com.yilmaznaslan.MainApplication" >> MANIFEST.MF`

3. Build the jar
   `cd build/classes && jar cmvf META-INF/MANIFEST.MF ../libs/MainApplication.jar com de`



`java -cp ":slf4j-api-1.7.32.jar:slf4j-simple-1.7.32.jar" -jar MainApplication.jar`

java -cp ":slf4j-api-1.7.32.jar:slf4j-simple-1.7.32.jar" -jar MainApplication.jar

### Creating a non-executable JAR
You can define the structure of the jar file in different ways

`jar cf build/libs/Application.jar build/classes/`

or

`cd build/classes && jar cf ../libs/ApplicationNew.jar com de`

If it's not an executable JAR, then you'll need to run the program with something like:
`java -cp ApplicationNew.jar com.yilmaznaslan.MainApplication.class`

