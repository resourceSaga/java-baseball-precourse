package baseball.playerSide.controller;

import baseball.playerSide.service.PlayerJudement;

import java.util.List;

public class PlayerController {

    private int gameNumberLength;
    private List<Integer> playerNumberList;

    public PlayerController(int gameNumberLength) {
        this.gameNumberLength = gameNumberLength;
    }

    public void playerAction() {
        PlayerJudement playerJudement = new PlayerJudement(gameNumberLength);
        playerNumberList = null;
        while(playerNumberList == null){
            playerJudement.init();
            playerNumberList =  playerJudement.getPlayerNumberList();
        }
    }

    public List getPlayerNumberList(){
        return playerNumberList;
    }
}
