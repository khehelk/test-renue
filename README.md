Оценка сложности: 
O(N * (n*m*s + z*log(z)+z)),
N - количество запросов
n - количество отчетов
m - количество слов в отчет
s - количество слов в запросе
z - количество подобранных отчетов для запроса

n*m*s - для каждого отчета (n) делаем .retainAll (m*S) с набором слов запроса
z*log(z)+z - сортировка по количеству совпадений для вывода наиболее релевантных отчетов в начале списка (z*log(z)), 
                +z перенос в новый список

Классификатор текста
Постановка задачи
Требуется написать консольное Java-приложение (JDK 17), реализующее простой текстовый
классификатор в чат-боте.
Приложение получает на вход при запуске CSV-файл со списком возможных отчетов, имеющих
такие свойства, как идентификатор формата GUID, кодовое имя, описание.

Приложение получает текстовый запрос от пользователя в свободной форме. Например,
«Предоставь мне отчет об уплаченных процентах по вкладу», по которому ищутся наиболее
подходящие строки из файла по описанию, GUID-ы которых выводятся пользователю в ответе.
Запрос может формулироваться в свободной форме. Например, «Мне нужен отчет по сумме
процентов вклада. Как его получить?». То есть пользователь просит бота в свободной форме
найти ему требуемые данные. 
