@echo off
chcp 65001 > nul
title Лаба по Spring - Таблица товаров

echo Сборка и запуск через Wrapper...

call gradlew.bat :app:run

echo.
pause
