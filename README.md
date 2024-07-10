# Los chistes De Chuck

## Descripción del Proyecto

La razón por la que hice este proyecto es principalmente porque quería experimentar el uso de una API, en este caso "chuckNorris.io". Para ya tener noción de la dificultad y de cómo es que funciona. Estos chistes, una vez que están puntuados por el usuario, se almacenan en una base de datos MySQL. Luego de esto y una charla con mis compañeros, me dieron la idea de que se puedan traducir los chistes. Es por esto que surgió la idea de utilizar LibreTranslate, que es una API que permite traducir textos a diferentes idiomas. En este caso, los idiomas posibles son inglés, español, italiano y portugués. Y no solo cambia el idioma del chiste, sino de toda la página.

## Instalación

1. Hacer un fork del proyecto.
2. Crear una tabla MySQL con los siguientes datos: `id_chiste`, `value`, `puntuacion`, `pos_entrada`.
3. Correr una base de datos XAMPP.
4. Instalar el contenedor LibreTranslate en Docker y correrlo.

## Uso

1. Iniciar el programa y automáticamente aparecerá un chiste.
2. Seleccionar el idioma y puntuar el chiste.
3. Al presionar "Otro chiste" o sus variantes, aparecerán nuevos chistes.
4. Si se presiona el botón de abajo a la derecha que dice "Historial", se podrá acceder a todos los chistes que fueron puntuados y organizarlos por la puntuación que tuvieron.

## Requisitos Previos

- Java
- MySQL
- Docker

## Tecnologías Usadas

- Java
- Swing
- MySQL
- Docker

## Características

- Recibe chistes de una API.
- Traduce los chistes a múltiples idiomas.
- Almacena los chistes en una base de datos.
- Historial de chistes.
- Puntuación de chistes.

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu nueva característica (`git checkout -b feature/nueva-caracteristica`).
3. Haz commit de tus cambios (`git commit -m 'Agregar nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.
