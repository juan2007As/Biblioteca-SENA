@echo off
chcp 65001 >nul
echo ========================================
echo Iniciando Aplicación - Biblioteca SENA
echo ========================================
echo.

REM Verificar si está en la carpeta correcta
if not exist "pom.xml" (
    echo ERROR: No se encontró pom.xml
    echo Asegúrate de ejecutar este archivo desde la carpeta del proyecto
    pause
    exit /b 1
)

REM Verificar Java
echo Verificando Java...
java -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java no está instalado
    echo Descárgalo desde: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)
echo ✓ Java encontrado

REM Verificar Maven
echo Verificando Maven...
mvn -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Maven no está instalado
    echo.
    echo Descarga Maven desde: https://maven.apache.org/download.cgi
    echo Descomprime el archivo descargado (ej: apache-maven-3.9.6-bin.zip)
    echo Agrega esta ruta a la variable de entorno PATH:
    echo   C:\ruta\a\apache-maven-3.9.6\bin
    echo.
    echo Luego ejecuta este archivo nuevamente
    pause
    exit /b 1
)
echo ✓ Maven encontrado

REM Compilar y ejecutar
echo.
echo Compilando proyecto...
mvn clean compile -q
if errorlevel 1 (
    echo ERROR: No se pudo compilar el proyecto
    pause
    exit /b 1
)
echo ✓ Compilación exitosa

echo.
echo ========================================
echo INICIANDO APLICACIÓN...
echo ========================================
echo.
echo La aplicación estará disponible en:
echo   http://localhost:8080/libros
echo.
echo Presiona Ctrl+C para detener la aplicación
echo.

mvn spring-boot:run

pause
