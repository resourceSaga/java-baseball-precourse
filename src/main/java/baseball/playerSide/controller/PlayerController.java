package baseball.playerSide.controller;

import baseball.playerSide.service.PlayerJudement;

import java.util.List;

public class PlayerController {

    private int gameNumberLength;
    private List<Integer> playerNumberList;

    public PlayerController(int gameNumberLength) {
        this.gameNumberLength = gameNumberLength;
        System.out.println("야구 게임 시작");
        playerAction();
    }

    private void playerAction() {
        PlayerJudement playerJudement = new PlayerJudement(gameNumberLength);
        playerNumberList =  playerJudement.getPlayerNumberList();
    }

    public List getPlayerNumberList(){
        return playerNumberList;
    }
}
