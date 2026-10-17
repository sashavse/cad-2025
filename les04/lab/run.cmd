@echo off
chcp 65001 > nul
title Лаба по Spring - Таблица товаров

echo Сборка проекта...
call gradlew.bat clean build

echo Запуск приложения...
call gradlew.bat run

echo.
pause