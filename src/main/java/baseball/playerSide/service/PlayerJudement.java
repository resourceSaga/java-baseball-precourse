package baseball.playerSide.service;

import nextstep.utils.Console;

import java.util.*;

public class PlayerJudement {

    private int gameNumberLength;
    private List<Integer> playerNumberList;

    public PlayerJudement(int gameNumberLength) {
        this.gameNumberLength = gameNumberLength;
        this.playerNumberList = new ArrayList<>();
    }

    public List getPlayerNumberList(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        listConverter(inputNum);
        inputValidater();
        return playerNumberList;
    }

    private void listConverter(String inputStr){
        List<String> playerStringList = Arrays.asList(inputStr.split(""));

        if (playerStringList.size() != this.gameNumberLength){
            System.out.println("[ERROR]: " + this.gameNumberLength + "자리의 수를 입력해주세요.");
            playerNumberList = null;
        }

        for (String str : playerStringList){
            playerNumberList.add(typeChecker(str));
        }
    }

    private void inputValidater(){
        for (int i = 0; i < playerNumberList.size(); i++){
            int inputNum = numberChecker(playerNumberList.get(i));
            playerNumberList.set(i, inputNum);
            duplicateChecker(inputNum);
        }

        if (playerNumberList.contains(-1)){
            System.out.println("[ERROR]: 올바른 숫자를 입력해 주세요.");
            playerNumberList = null;
        }
    }

    private int typeChecker(String str){
        if (playerNumberList == null){
            return -1;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return -1;
        }

    }

    private int numberChecker(int number){
        if (playerNumberList == null){
            return -1;
        }

        if (number > 0 && number < 10){
            return number;
        }

        return -1;
    }

    private void duplicateChecker(int inputNum){
        int firstIndex = -1;
        if (playerNumberList.contains(inputNum)){
            firstIndex = playerNumberList.indexOf(inputNum);
        }

        List tmpList = playerNumberList.subList(firstIndex+1, playerNumberList.size());
        if (tmpList.contains(inputNum)){
            playerNumberList.set(firstIndex, -1);
        }
    }
}
