@echo off
set JAVA_HOME=C:\Users\4pnav\.jdks\corretto-11.0.17

cd /d "target"

"%JAVA_HOME%\bin\java" -jar user_result-0.0.1-SNAPSHOT.jar
