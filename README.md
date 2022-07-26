# Java Compiler Tutorial

# Java Compiler Tutorial

## How to compile

### Example 1 - Compile multiple source files into byte code

`javac src/com/yilmaznaslan/MainApplication.java src/com/yilmaznaslan/Bus.java src/de/bvg/Train.java -d build/classes`

Run

`java -cp build/classes com/yilmaznaslan/MainApplication`
### Example 2 - Compile multiple files using a source file

Delete the build directory if it was already created

`rm -r build/`

Create an empty file `sourceFiles` that has the class names

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

`javac -d build/classes @sourceFiles -cp ":libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar"`

or you can also create an environmental variable called `CLASSPATH` and
```
export CLASSPATH=":build/classes:libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar"
javac @sourceFiles -d build/classes
```

Run

`java -cp ":build/classes:libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar" com/yilmaznaslan/MainApplication`

#### How to remove error marks in intellij

libs(right click) -> add as library -> click OK

You can also check the library files used in intelliJ
File -> Project Structure -> Libraries

## 2. Packaging the application
The basic format of the command for creating a JAR file is:

`jar cf jar-file input-file(s)`

### Example 1 - Creating executable JAR

Delete the build directory if it was already created

`rm -r build/`

0. Compile the source files into class files/byte code

`javac -d build/classes @sourceFiles`
``
1. Create the `MANIFEST.MF` file in resource folder
   `touch src/main/resources/META-INF/MANIFEST.MF`

2. Add Main Class information
   `echo "Main-Class: com.yilmaznaslan.MainApplication" >> src/main/resources/META-INF/MANIFEST.MF`

3. Build the jar
   `mkdir -p build/libs`
   `jar cmvf ./src/main/resources/META-INF/MANIFEST.MF build/libs/MainApplication.jar -C ./build/classes .`

4. Run the application
   `java -jar build/libs/MainApplication.jar`

### Example 2 - Creating a non-executable JAR with dependencies
Delete the build directory if it was already created

`rm -r build/`

0. Compile the source files into class files/byte code

`javac -d build/classes @src/main/resources/sourceFiles -cp ":libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar"`
``

1. Create the `MANIFEST.MF` file in resource folder
   `touch src/main/resources/META-INF/MANIFEST.MF`

2. Add Main Class information
   `echo "Main-Class: com.yilmaznaslan.MainApplication" >> src/main/resources/META-INF/MANIFEST.MF`

3. Build the jar
   `mkdir -p build/libs`
   `jar cf build/libs/Application.jar -C ./build/classes/ .`

4. Run the application
   `java -cp ":libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar:build/libs/Application.jar:build/classes" com.yilmaznaslan.MainApplication`

### Example 3 - Creating FatJAt with dependencies

Delete the build directory if it was already created

`rm -r build/`

0. Compile the source files into class files/byte code

`javac -d build/classes @src/main/resources/sourceFiles -cp ":libs/slf4j-api-1.7.32.jar:libs/slf4j-simple-1.7.32.jar"`
``

1. Create the `MANIFEST.MF` file in resource folder
   `touch src/main/resources/META-INF/MANIFEST.MF`

2. Add Main Class information
   `echo "Main-Class: com.yilmaznaslan.MainApplication" >> src/main/resources/META-INF/MANIFEST.MF`

3. Unpack the dependency Jar files into build/classes and remove after using
   `cd build/classes && jar xf ../../libs/slf4j-api-1.7.32.jar org && cd ../../`
   `cd build/classes && jar xf ../../libs/slf4j-simple-1.7.32.jar org && cd ../../`

4. Build the jar
   `mkdir -p build/libs`
   `jar cmvf ./src/main/resources/META-INF/MANIFEST.MF build/libs/MainApplication.jar -C ./build/classes .`

5. Run the application
   `java -jar build/libs/MainApplication.jar`


