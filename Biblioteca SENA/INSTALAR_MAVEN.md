 # Instalación de Maven - Guía Rápida

## Paso 1: Descargar Maven
1. Abre este enlace en tu navegador: https://maven.apache.org/download.cgi
2. Descarga la versión **apache-maven-3.9.6-bin.zip** (o la más reciente)

## Paso 2: Descomprimir
1. Descomprime el archivo ZIP descargado
2. Copia la carpeta `apache-maven-3.9.6` a `C:\` (o donde prefieras)
3. La ruta debe quedar así: `C:\apache-maven-3.9.6`

## Paso 3: Agregar a variables de entorno
1. Presiona `Win + X` y selecciona "Configuración del sistema" o busca "Variables de entorno"
2. Haz clic en "Variables de entorno"
3. En "Variables de usuario", busca `Path` y haz clic en "Editar"
4. Haz clic en "Nuevo" y agrega: `C:\apache-maven-3.9.6\bin`
5. Haz clic en "Aceptar" en todos los cuadros de diálogo
6. **Reinicia la terminal PowerShell o CMD**

## Paso 4: Verificar instalación
Abre PowerShell o CMD y ejecuta:
```
mvn -version
```
Deberías ver la versión de Maven instalada.

## Paso 5: Ejecutar la aplicación
Una vez Maven esté instalado, haz doble clic en `iniciar.bat` desde la carpeta del proyecto.

## Si aún tienes problemas:
Ejecuta en PowerShell (como administrador):
```powershell
cd "c:\Users\Juancho\Desktop\Biblioteca SENA"
mvn spring-boot:run
```

Luego abre en tu navegador: http://localhost:8080/libros
