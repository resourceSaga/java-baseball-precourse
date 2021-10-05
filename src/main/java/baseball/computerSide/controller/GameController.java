package baseball.computerSide.controller;

import baseball.computerSide.service.ComputerJudement;
import baseball.computerSide.service.GameJudement;
import baseball.playerSide.controller.PlayerController;

import java.util.List;
/**
 * @author Yoon SeoYul <devops.reso@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class GameController {

    private int startNum, endNum, numLen;           // 수열 범위의 시작, 끝, 수열의 길이
    private List<Integer> computerSelectNumberList; // 컴퓨터가 출제한 문제
    private List<Integer> playerSelectNumberList;   // 플레이어의 풀이

    public GameController(int startNum, int endNum, int numLen) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.numLen = numLen;
    }

    /**
     * 게임 시작시 흐름 제어
     */
    public void start() {
        computerSelectNumberList = ComputerJudement.createNumberList(startNum, endNum, numLen);
        PlayerController playerController = new PlayerController(numLen);
        run(playerController);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        end();
    }

    /**
     * 게임 실행 제어
     * @param playerController
     */
    private void run(PlayerController playerController) {
        boolean result = false;
        while (!result) {
            playerController.playerAction();
            playerSelectNumberList = playerController.getPlayerNumberList();
            result = ComputerJudement.judge(computerSelectNumberList, playerSelectNumberList);
        }
    }

    /**
     * 게임이 끝났을때 흐름 제어
     */
    private void end() {
        int result = 0;
        while (result == 0) {
            result = GameJudement.endSelect();
        }
        if (result == 1) {
            start();
        }
    }
}
