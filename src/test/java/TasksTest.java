import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean expected = true;
        boolean actual = task.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean expected = false;
        boolean actual = task.matches("работа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Хлеб", "Яйца"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpic() {
        String[] subtasks = {"Молоко", "Хлеб", "Яйца"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(3, "Обсуждение релиза", "Проект X", "Завтра");

        boolean expected = true;
        boolean actual = meeting.matches("релиза");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchMeeting() {
        Meeting meeting = new Meeting(3, "Обсуждение релиза", "Проект X", "Завтра");

        boolean expected = false;
        boolean actual = meeting.matches("другое");

        Assertions.assertEquals(expected, actual);
    }
}