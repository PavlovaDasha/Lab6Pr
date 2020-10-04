package Commands;

import java.io.IOException;

public class Help implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        return ("\nhelp : вывести справку по доступным командам") + "\n" +
                ("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)") + "\n" +
                ("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении") + "\n" +
                ("add {element} : добавить новый элемент в коллекцию") + "\n" +
                ("update id {element} : обновить значение элемента коллекции, id которого равен заданному") + "\n" +
                ("remove id : удалить элемент из коллекции по его id") + "\n" +
                ("clear : очистить коллекцию") + "\n" +
                ("save : сохранить коллекцию в файл") + "\n" +
                ("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.") + "\n" +
                ("exit : завершить программу (без сохранения в файл)") + "\n" +
                ("remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)") + "\n" +
                ("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции") + "\n" +
                ("sort : отсортировать коллекцию в естественном порядке") + "\n" +
                ("count_less_than_number_of_participants numberOfParticipants : вывести количество элементов, значение поля numberOfParticipants которых меньше заданного") + "\n" +
                ("count_greater_than_front_man frontMan : вывести количество элементов, значение поля frontMan которых больше заданного") + "\n" +
                ("filter_by_number_of_participants numberOfParticipants : вывести элементы, значение поля numberOfParticipants которых равно заданному");
    }

    @Override
    public String getName() {
        return "help";
    }
}
