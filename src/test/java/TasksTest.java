import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void simpleTaskTrueTest() {
        SimpleTask task = new SimpleTask(1, "Сделать кулич");
        String title = "Сделать кулич";

        boolean expected = true;
        boolean actual = task.matches(title);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskFalseTest() {
        SimpleTask task = new SimpleTask(1, "Сделать кулич");
        String title = "Сходить в кино";

        boolean expected = false;
        boolean actual = task.matches(title);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicTaskTrueTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        String subtask = "Яйца";

        boolean expected = true;
        boolean actual = epic.matches(subtask);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicTaskFalseTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        String subtask = "Печенье";

        boolean expected = false;
        boolean actual = epic.matches(subtask);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTaskTrueTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Выкатка 3й версии приложения";

        boolean expected = true;
        boolean actual = meeting.matches(query);
    }

    @Test
    public void meetingTaskFalseTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Во вторник после обеда";

        boolean expected = false;
        boolean actual = meeting.matches(query);
    }
}
