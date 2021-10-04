package baseball.computerSide.controller;

import baseball.computerSide.service.Judement;

import java.util.List;

public class GameStarter {

    private int startNum, endNum, numLen;
    private List computerSelectNumberList;

    public GameStarter(int startNum, int endNum, int numLen) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.numLen = numLen;
    }

    public void start(){
        computerSelectNumberList = Judement.createNumberList(startNum, endNum, numLen);
    }
}
