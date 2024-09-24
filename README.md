# Информация о проекте

**Зависимости**

| Технология | Версия |
|------|--------|
| Java  | 11     | 
| JUnit  | 4.13.2 |
| Mockito  | 3.12.4 | 
| Jacoco   | 0.8.8  | 

# Задание 1: юнит-тесты

Представь: нужно протестировать программу, которая помогает заказать бургер в Stellar Burgers. Тебе предстоит покрыть её юнит-тестами.

Здесь пригодятся моки, стабы и параметризация: где именно их использовать, реши самостоятельно.

# Что нужно сделать

Склонируй репозиторий с заготовкой кода.

Подключи библиотеки: Jacoco, Mockito, JUnit 4.

Покрой тестами классы Bun, Burger, Ingredient, IngredientType. Используй моки, стабы и параметризацию там, где нужно.

Процент покрытия должен быть не ниже 70%.

# Как выполнить и сдать работу
Склонируй репозиторий с заготовкой кода, допиши программу в IDEA и запушь код на GitHub. Как это сделать — в инструкции.

# Как будут оценивать твою работу
1. Названия тестов и переменных корректные: соответствуют правилам, которые удалось изучить в курсе. 
2. Тесты запускаются и не падают. 
3. В тестах есть моки и параметризация. 
4. Сделан отчёт в Jacoco. Тестовое покрытие не ниже 70%. Отчёт добавлен в пул-реквест. 
5. Тесты не избыточны. 
6. Тесты лежат в test/java. 
7. В файле pom.xml нет ничего лишнего.