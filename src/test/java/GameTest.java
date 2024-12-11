import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    @Test
    public void test() {
        Game game = new Game();
        Player player1 = new Player(1, "Аня", 100);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Аня", "Коля");
        });
    }

    @Test
    public void test1() {
        Game game = new Game();
        Player player2 = new Player(2, "Коля", 200);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Аня", "Коля");
        });
    }

    @Test
    public void test2() {
        Game game = new Game();
        Player player1 = new Player(1, "Аня", 100);
        Player player2 = new Player(2, "Коля", 200);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Аня", "Коля");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        Game game = new Game();
        Player player1 = new Player(1, "Аня", 300);
        Player player2 = new Player(2, "Коля", 200);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Аня", "Коля");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        Game game = new Game();
        Player player1 = new Player(1, "Аня", 100);
        Player player2 = new Player(2, "Коля", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Аня", "Коля");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}
