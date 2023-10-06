# easyrestapi
Easy test restapi

Данный API используяется для нахождения числа повторений символа в заданной строке, с выводом в виде Map.

Имеется всего один запрос GET:
http://localhost:8080/numbers
Запрос имеет один параметр - input типа String

Пример запроса
http://localhost:8080/numbers?input=Hello World
Вывод:
{
    "input": "Hello World",
    "output": {
        " ": 1,
        "r": 1,
        "d": 1,
        "e": 1,
        "W": 1,
        "H": 1,
        "l": 3,
        "o": 2
    }
}
