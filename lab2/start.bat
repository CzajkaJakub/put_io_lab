@echo off
REM Adjust paths to Ant, Maven and JDK
set ANT_HOME=C:\Software\apache-ant-1.10.11
set MAVEN_HOME=C:\Software\apache-maven-3.8.2
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_201
REM Don't change the lines below
set PATH=%ANT_HOME%\bin;%PATH%
set PATH=%MAVEN_HOME%\bin;%PATH%
@echo on
@echo "You are ready to use Ant and Maven :)."
@echo off
cmd /k
