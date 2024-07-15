package ConwayLife.Libraries;

public class SpaceshipLibrary {

    public static final String[] spaceships = new String[]{

            // Lightweight spaceship (period 3)
            ".*....\n" +
                    "*......\n" +
                    ".*.*...\n" +
                    ".....*.\n" +
                    "....*..",


            // Heavyweight spaceship (period 5)
            "....*..\n" +
                    "..*.*..\n" +
                    "..*....\n" +
                    "...*.*.\n" +
                    ".*.....",

            // Ants (period infinite)
            ".....*\n" +
                    "....**\n" +
                    "...*..\n" +
                    "..**..\n" +
                    ".*.....\n" +
                    "*.*....\n" +
                    "**....*\n" +
                    "....*..\n" +
                    "....**\n" +
                    ".....*"
    };
}
