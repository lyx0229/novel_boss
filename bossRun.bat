@echo off
title novel-boss

echo "%~dp0target"
cd "%~dp0"

call mvn clean install -Dmaven.test.skip=true

cd "%~dp0target"
choice /t 1 /d y /n >nul

java -jar novel-boss-1.0.0-SNAPSHOT.jar

pause
