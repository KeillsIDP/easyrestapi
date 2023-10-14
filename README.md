# easyrestapi
Easy test restapi

Данный API используяется для нахождения числа повторений символа в заданной строке, с выводом в виде Map.

Имеется всего один запрос GET:
http://localhost:8080/numbers
Запрос имеет один параметр - input типа String

Пример запроса:
<br/>http://localhost:8080/numbers?input=Hello World
<br/>Вывод:
<br/>{
<br/> &emsp;   "input": "Hello World",
<br/> &emsp;   "output": {
<br/> &emsp;&emsp;       " ": 1,
<br/> &emsp;&emsp;       "r": 1,
<br/> &emsp;&emsp;       "d": 1,
<br/> &emsp;&emsp;       "e": 1,
<br/> &emsp;&emsp;       "W": 1,
<br/> &emsp;&emsp;       "H": 1,
<br/> &emsp;&emsp;       "l": 3,
<br/> &emsp;&emsp;       "o": 2
<br/> &emsp;   }
<br/>}
