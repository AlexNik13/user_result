set JAVA_HOME=C:\Users\4pnav\.jdks\corretto-11.0.17
set APP_HOME=C:\java\testBidMind\user_result

cd %APP_HOME%

javac -d target/classes src/main/java/com/example/user_result/*.java

jar cvf target/user-result.jar -C target/classes/ .

java -jar target/user-result.jar
