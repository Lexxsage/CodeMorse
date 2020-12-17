# CodeMorse
Написать программу, которая будет шифровать и расшифровывать код Морзе. Работа происходит следующим образом: с консоли считывается команда (code или decode). В качестве аргумента команде указано имя исходного текстового файла. Программа обрабатывает полученный файл и выводит в консоль результирующий файл. В отдельный файл выводится статистика: как часто встречается та или иная буква.

Пример:

code init.txt

Методические указания:

· Использовать класс java.lang.StringBuilder для построения слов.

· Азбука Морзе должна считываться из файла в начале программы.

· На команды code и decode заводится класс-обработчик.

· Для чтения из файла удобно использовать: java.io.InputStreamReader.

· Для определения класса символа рекомендуется использовать методы класса Character. Для хранения азбуки в памяти можно использовать одну из реализаций интерфейса java.util.Map. Для хранения статистики используется java.util.Set, который должен будет хранить объекты специального класса. Данный класс должен содержать символ и счётчик. В случае использования java.util.HashSet класс также должен реализовать методы equals, hashCode.

Теоретические сведения:

Контейнеры стандартной библиотеки расположены в пакете java.util. IO классы (потоки ввода-вывода) располагаются в пакете java.io.

Основные интерфейсы:

1. Set – множество без дубликатов и без доступа по индексу.

2. Map – множество пар ключ-значение, где ключи не повторяются.

Их основные реализации:

1. HashMap, HashSet — реализации на основе функции hashCode.

2. TreeMap, TreeSet – реализация на основе бинарного дерева. Ключи (элементы) должны реализовывать интерфейс Comporable, иначе необходимо передавать в контейнер при его создании объект, реализующий интерфейс Comparator. Хранимые в данных контейнерах данные упорядочены. Лучшее время поиска, но большее накладные расходы на вставку, чем на основе функции hashCode
