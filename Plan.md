# **Перечень автоматизируемых сценариев:**

# ***Позитивные сценарии:***
1. Покупка тура с APPROVED карты;
2. Покупка тура с Declined карты;

# ***Негативные сценарии:***
1. Отправка формы с незаполеннными полями;
2. Отправка формы с отсуствующими в базе данных данными (В поле "Владелец" - имя и фамилия на английском);
3. Отправка формы с отсуствующими в базе данных данными (В поле "Владелец" - имя и фамилия на русском);

# **Инструменты:**
1. IntelliJ IDEA Community Edition 2023.1 - Интегрированная среда разработки программного обеспечения для многих языков программирования, в частности Java, JavaScript, Python;
2. Java 11 - Язык программирования, который имеет набор готового ПО для разработки и запуска приложений;
3. Gradle - По сравнению с Maven проще подключать зависимости, меньше кода, гибкость системы;
4. JUnit – Фреймворк, который предоставляет множество улучшений и новых функций для написания тестов;
5. Lombok - Основанная на аннотациях библиотека Java, позволяющая сократить шаблонный код;
6. JavaFaker - Библиотека, которую можно использовать для генерации широкого спектра разлиных тестовых данных;
7. Selenide – Фреймворк для написания удобных для чтения и обслуживания автоматизированных тестов на Java;
8. Docker – Это платформа для разработки и запуска контейнеров. Докер позволяет создавать контейнеры, автоматизирует их запуск и управляет жизненным циклом;
9. Allure – Фреймворк для сбора данных и построения отчетов о тестировании кода;
10. MySQL - Реляционная система управления базами данных.

# **Перечень и описание возможных рисков при автоматизации:**
1. Тесты могут не покрыть все возможные негативные сценарии (пользователь может повести себя так, как мы не можем предвидеть);
2. Падение автотестов UI даже при незначительном изменении кода (изменения: структуры сайта, локаторов элементов);
3. Некорректность тестовых данных при работе с Faker;
4. При изменении полей, текста, заголовков и т.д. тесты необходимо будет редактировать.

# **Интервальная оценка с учётом рисков в часах:**
1. Прохождение тестового сценария вручную - 30 минут;
2. Настройка тестового окружения - 1 час;
3. Написание дата-классов - 1,5 часа;
4. Написание Page Objects - 10 часов;
5. Написание тестов - 10 часов;
6. Написание отчетов о тестировании - 1 час;
7. Написание отчетов об автоматизации - 1 час.

Итого: 25 часов.

# **План сдачи работ:**
1. 24 июля 2023 - сдача плана тестирования;
2. 24-28 июля - написание автотестов и подготовка тестового окружения;
3. 29-30 июля - написание отчетов о тестировании и автоматизации.
