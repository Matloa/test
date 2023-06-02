import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

public @interface Test {
    class GameTest {

        public static ArrayList<Player> players = new ArrayList<>();

        Game game = new Game();
        Player playera = new Player("Mat", 0, 0, false);

        @Test
        public void wrongAnswer() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(3);
            game.wrongAnswer();

            assertTrue(playera.getinPenaltyBox());

        }

        @Test
        public void wasCorrectlyAnswered() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(3);
            game.wasCorrectlyAnswered();

            assertEquals(1, playera.getPurses());

        }

        @Test
        public void addPlayer1() {
            game.add(playera);

            assertEquals(1, players.size());

        }

        @Test
        public void addPlayer2to6() {
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);

            assertEquals(6, players.size());

        }

        @Test
        public void addPlayers7() {
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            game.add(playera);
            assertEquals(6, players.size());

        }

        @Test
        public void rockpritting() {
            assertTrue(game.rockQuestions.getLast().equals("Rock Question " + 50));
        }

        @Test
        public void inPenaltyBoxCheckeringFalse() {
            game.add(playera);
            game.setCurrentPlayer();
            playera.SetinPenaltyBox(true);

            assertEquals(false, game.inPenaltyBoxChecker(5));
        }

        @Test
        public void inPenaltyBoxCheckeringTrue() {
            game.add(playera);
            game.setCurrentPlayer();
            playera.SetinPenaltyBox(true);

            assertEquals(true, game.inPenaltyBoxChecker(4));
        }

        @Test
        public void easierchanges1() {
            game.add(playera);
            playera.SetPlace(7);
            assertEquals(11, playera.SetPlace(11));

        }

        @Test
        public void easierchanges2() {
            game.add(playera);
            playera.Setname("HatingSE");
            assertEquals("LovingSE", playera.Setname("LovingSE"));

        }

        @Test
        public void RollTo4() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(4);

            assertEquals(4, playera.getPlace());

        }
        @Test
        public void RollLapChange() {
            game.add(playera);
            game.setCurrentPlayer();
            playera.SetPlace(12);
            game.roll(5);

            assertEquals(4, playera.getPlace());

        }

        @Test
        public void sportsQuestion() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(2);

            assertEquals("Sports", game.currentCategory());

        }

        @Test
        public void scienceQuestion() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(1);

            assertEquals("Science", game.currentCategory());

        }

        @Test
        public void popQuestion() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(4);

            assertEquals("Pop", game.currentCategory());

        }

        @Test
        public void rockQuestion() {
            game.add(playera);
            game.setCurrentPlayer();
            game.roll(3);

            assertEquals("Rock", game.currentCategory());

        }

        @Test
        public void FinalQuestion() {
            game.add(playera);
            game.setCurrentPlayer();
            playera.SetPlace(1);
            playera.SetPurses(2);
            playera.SetinPenaltyBox(true);
            playera.Setname("Passing the SE Exam");
            game.roll(3);
            game.wasCorrectlyAnswered();
            assertEquals(false, playera.getinPenaltyBox());
            assertEquals("Pop", game.currentCategory());
            assertEquals(4, playera.getPlace());
            assertEquals(3, playera.getPurses());
            assertEquals("Passing the SE Exam", playera.getname());

        }
    }

}
