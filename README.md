# easyrestapi
REST api for finding character occurrances in input string

Данный API используяется для нахождения числа повторений символа в заданной строке, с выводом в виде Map.

# Response structure

Responses have similar structure:
<br>&emsp;  data: ~ 
<br>&emsp;  message: ~ 
<br>&emsp;  status: ~ 

# Requests:

<b>Получить количество повторений символов без учета пробела</b><br>
GET:
http://localhost:8080/ns/{input}
Запрос имеет один параметр (PathVariable) - input типа String

<b>Получить количество повторений символов с учетом пробела</b><br>
GET:
http://localhost:8080/{input}
Запрос имеет один параметр (PathVariable) - input типа String

Пример запроса:
<br/>http://localhost:8080/ Hello
<br/>Вывод:
<br/>{
<br>&emsp;  "data": {
<br>&emsp;&emsp;  "l": 2,
<br>&emsp;&emsp;  " ": 1,
<br>&emsp;&emsp;  "H": 1,
<br>&emsp;&emsp;  "e": 1,
<br>&emsp;&emsp;  "o": 1
<br>&emsp;  }, 
<br>&emsp;  "message": "Частота появления символов в строке  Hello"
<br>&emsp;  "status": "OK"
<br/>}
