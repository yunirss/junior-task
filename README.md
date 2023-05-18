# junior-task
Тестовая задача на Junior java разработчика

`Запуск приложения`

> Необходима База Данных PostgreSQL. Для начала нужно клонировать репозиторий, запустить проект.
Затем нужно запустить сборку проекта через Maven. Выполнить такие команды как "clean" и "install". Также мною был разработан Dockerfile в корневой папке приложения. Разработал так же миграции баз данный через библиотеку Flyway, после запуска приложения автоматически подтягиваются данные для баз данных
Для запуска приложения на контейнерах Докера нужно в файле application.properties поменять строку "localhost" на "host.docker.internal", после этого использовать команды в Терминале "docker build ." -> "docker images" -> "docker run -p 8080:8080 (здесь подставить ID образа)" 
и следовать инструкциям. 

`Требования к SOFTWARE`
- MacOs
- Windows
- Linux

`Среда разработки`
- IntelliJ IDEA Ultimate

`Стек технологий`
- Java 11
- Apache Maven version 4.0.0
- Spring Boot 2.7.12-SNAPSHOT
- Spring Data JPA
- Lombok
- PostgreSQL
- Docker

`Разработчик`
- Суюндуков Юнир Ильфатович
- yunir14@yandex.ru
- t.me/yunirss
