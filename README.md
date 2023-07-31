# **Процедура запуска автотестов:**
1. Клонировать репозиторий: git clone https://github.com/S-Alekseeva/CourseWorkQA;
2. Открыть проект в IntelliJ IDEA;
3. Запустить Docker Desktop;
4. Открыть терминал IntelliJ IDEA в файле docker-compose.yml и запустить докер контейнер командой: docker-compose up;
5. Открыть 2 вкладку в терминале IntelliJ IDEA и запустить jar файл командой: java -jar artifacts/aqa-shop.jar;
6. Открыть в браузере Chrome ссылку http://localhost:8080 - убедиться, что jar файл запущен;
7. Открыть 3 вкладку в терминале IntelliJ IDEA и запустить тесты командой: ./gradlew clean test --info;
8. Сформировать Allure отчет набрав команду в терминале: ./gradlew allureserve  после чего в браузере откроется станица с отчетом.

*Для окончания работы над тестированием:*
1. Закрыть Allure отчет в терминале: CTRL + С -> Y -> ENTER;
2. Остановить работу jar файла: CTRL + С;
3. Остановить докер контейнер: CTRL + С или docker-compose down.
