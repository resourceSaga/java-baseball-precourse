package baseball.computerSide.controller;

import baseball.computerSide.service.Judement;
import baseball.playerSide.controller.PlayerController;

import java.util.List;

public class GameStarter {

    private int startNum, endNum, numLen;
    private List<Integer> computerSelectNumberList;
    private List<Integer> playerSelectNumberList;

    public GameStarter(int startNum, int endNum, int numLen) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.numLen = numLen;
    }

    public void start(){
        computerSelectNumberList = Judement.createNumberList(startNum, endNum, numLen);
        PlayerController playerController = new PlayerController(numLen);
        playerSelectNumberList = playerController.getPlayerNumberList();

//        System.out.println(computerSelectNumberList);
//        if (playerSelectNumberList != null){
//            System.out.println(playerSelectNumberList);
//        } else {
//            System.out.println("null");
//        }

    }
}
