package baseball;

import baseball.computerSide.controller.GameStarter;

public class Application {
    private static int RANGE_START_NUMBER = 1;
    private static int RANGE_END_NUMBER = 9;
    private static int GAME_NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter(RANGE_START_NUMBER,RANGE_END_NUMBER, GAME_NUMBER_LENGTH);
        gameStarter.start();
    }
}
