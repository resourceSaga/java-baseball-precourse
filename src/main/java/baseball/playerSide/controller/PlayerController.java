package baseball.playerSide.controller;

import baseball.playerSide.service.PlayerJudement;

import java.util.List;
/**
 * @author Yoon SeoYul <devops.reso@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class PlayerController {

    private int gameNumberLength;              // 출제된 숫자열의 길이
    private List<Integer> playerNumberList;    // 플레이어의 입력 수열

    public PlayerController(int gameNumberLength) {
        this.gameNumberLength = gameNumberLength;
    }

    /**
     * 플레이어가 해야하는 행동(문자열 입력)을 관리한다.
     */
    public void playerAction() {
        PlayerJudement playerJudement = new PlayerJudement(gameNumberLength);
        playerNumberList = null;
        while (playerNumberList == null) {
            playerJudement.init();
            playerNumberList = playerJudement.getPlayerNumberList();
        }
    }

    /**
     * 플레이어의 입력 수열 반환
     * @return 플레이어의 입력 수열 List<Integer>
     */
    public List getPlayerNumberList() {
        return playerNumberList;
    }
}
