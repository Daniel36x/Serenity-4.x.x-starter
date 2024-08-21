# Configuración y ejecución Serenity Screenplay Build Pattern

| Framework: | Serenity - Cucumber - Screenplay |
| --- | --- |
| Página:|https://demoqa.com|
Creador: |Dennis Armando Castrillón Sepúlveda |
| Versión: | 1 |

## Introducción

La presente tiene como objetivo indicar al usuario en que consiste el repositorio y el objetivo de su desarrollo, donde se indicarán los comandos para su uso y sus casos de prueba de testing.

## Objetivo general

Realizar la ejecución del programa desarrollado para testing de la pagina `https://demoqa.com/`, donde se identificará que pruebas se realizarán y que resultados se esperan.

Se busca testear la función de ingresar información a Web Tables de la pestaña de elementos, la información se extraerá desde un archivo CSV.

## Objetivos Especificos

1. Indicar que frameworks se usaron para el desarrollo del proyecto con sus respectivas dependencias
2. Exponer los casos de prueba que se realizaron y cual es el flujo de trabajo que presenta la plataforma que se pone a prueba.
3. Uso de Build Pattern Design para el manejo de información desde archivos CSV.
4. Hacer uso de los comandos para correr el programa desde la terminal y mostrar su debido uso.

## Background para la ejecución de pruebas

Para el desarrollo de los test, se uso la aplicación de `Intellij` que nos permite crear los proyectos desde 0, en este caso se desarrollo con `Java 11` y `Gradle`.

Posterior a la creación del proyecto base se agregaron las dependencias que nos permitirían trabajar con Cucumber y la interacción con las páginas web.

`implementation "net.serenity-bdd:serenity-cucumber:$**{**serenityCoreVersion**}**"`

`implementation "org.junit.vintage:junit-vintage-engine:$**{**junitVersion**}**"`

`implementation 'com.googlecode.json-simple:json-simple:1.1.1'`

`implementation 'net.serenity-bdd:serenity-single-page-report:3.6.9'`

`testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:$**{**junitVersion**}**"`

`implementation "net.serenity-bdd:serenity-screenplay:$**{**serenityCoreVersion**}**"`

El caso de prueba a trabajar en esta ocasión consiste en un feature que nos permite leer la información desde un archivo CSV, la cual debe ser procesada con la metodología de build pattern design, que nos permitirá trabajar de una manera mas limpia y adecuada para manejo de grandes volúmenes de información.

Posteriormente se procede a ingresar a la pagina web indicada previamente, exactamente en la sección de Web Tables y en ese lugar ingresamos la información que se extrajo del archivo CSV.

Por último se realiza la verificación de que haya quedada registrada la información y que el campo nuevo quede creado.

Para la ejecución del programa se utilizan el archivo que se encuentra en la ubicación:

`src/test/resources/com/demoqa/data/data_WebTable.csv`

Dentro de este archivo hay un campo que hace referencia a un ID de Scenario que le asignamos, de este forma desde el feature podemos indicar que Scenarios queremos probar.

Uno de los conceptos mas importantes a considerar, es el uso del modelo de diseño builder (build pattern design), el cual nos permitirá manejar grandes volúmenes de datos y trabajarlos de una forma mas sencilla.

Se crean dos clases para el desarrollo de este modelo, la primera se encuentra en la ruta:

`src/main/java/com/demoqa/utils/CsvModel.java`

Esta consiste en crear el modelo de información, la cual contendrá todos los getter de información y será inmutable.

La otra clase a usarse es la que hace referencia al builder.

`src/main/java/com/demoqa/utils/builders/BuilderCsv.java`

En esta clase es donde mandamos nuestros paquetes de datos que en este caso son listas de “Maps”, y en esta clase es donde extraemos esta información y la procesamos, se agrega un método build que es el encargado de integrar la información con el modelo y que de esta forma quede la información asignada al modelo.

Para crear un modelo de información de un archivo CSV con estas clases anteriormente descritas solo se requiere la siguiente linea de comando:

`CsvModel dataBuilder = new BuilderCsv({Información de listas de Maps}).build();`

Ya de esta forma podemos acceder a la información desde el objeto creado tipo CsvModel:

`dataBuilder.getNombre();`

Como se puede observar el objeto es inmutable y queda con toda su información asignada.

## Ejecución de pruebas

Para la ejecución de la prueba se ejecuta el comando

`./gradlew clean test`

Con este comando corre todos los Scenarios indicados en el Feature.

Al final de las pruebas se puede ver el reporte completo en formato HTML en la ruta:

`./target/site/serenity/index.html`