package baseball.computerSide.controller;

import baseball.computerSide.service.ComputerJudement;
import baseball.computerSide.service.GameJudement;
import baseball.playerSide.controller.PlayerController;
import nextstep.utils.Console;

import java.util.List;

public class GameController {

    private int startNum, endNum, numLen;
    private List<Integer> computerSelectNumberList;
    private List<Integer> playerSelectNumberList;

    public GameController(int startNum, int endNum, int numLen) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.numLen = numLen;
    }

    public void start(){
        computerSelectNumberList = ComputerJudement.createNumberList(startNum, endNum, numLen);
        PlayerController playerController = new PlayerController(numLen);
        run(playerController);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        end();

    }
    private void run(PlayerController playerController){
        boolean result = false;
        while (!result){
            playerController.playerAction();
            playerSelectNumberList = playerController.getPlayerNumberList();
            result = ComputerJudement.judge(computerSelectNumberList, playerSelectNumberList);
        }
    }

    private void end(){
        int result = 0;
        while (result == 0){
            result = GameJudement.endSelect();
        }
        if (result == 1){
            start();
        }
    }
}
