package baseball.playerSide.service;

import nextstep.utils.Console;

import java.util.*;
/**
 * @author Yoon SeoYul <devops.reso@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class PlayerJudement {

    private int gameNumberLength;
    private List<Integer> playerNumberList;

    /**
     * 시스템 안내 문자열
     * @return 메시지 문자열
     */
    public String getSystemMsg() {
        return systemMsg;
    }

    private String systemMsg;

    public PlayerJudement(int gameNumberLength) {
        this.gameNumberLength = gameNumberLength;
    }

    /**
     * 플레이어 입력 데이터 초기화
     */
    public void init() {
        this.playerNumberList = new ArrayList<>();
        this.systemMsg = null;
    }

    /**
     * 플레이어로부터 문자열을 입력받아 데이터 저장
     * @return 문자열
     */
    public List getPlayerNumberList() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        systemMsg = listConverter(inputNum);
        if (systemMsg == null) {
        systemMsg = inputValidater();
            System.out.println(systemMsg);
        }
        if (systemMsg != null){
            System.out.println(systemMsg);
        }
        return playerNumberList;
    }

    /**
     * 입력받은 문자열을 리스트 변환
     * @param inputStr 플레이어 입력 문자열
     */
    private String listConverter(String inputStr) {
        List<String> playerStringList = Arrays.asList(inputStr.split(""));

        if (playerStringList.size() != this.gameNumberLength) {
            playerNumberList = null;
            return "[ERROR]: " + this.gameNumberLength + "자리의 수를 입력해주세요.";
        }

        for (String str : playerStringList) {
            playerNumberList.add(typeChecker(str));
        }
        return null;
    }

    /**
     * 입력받은 문자열이 게임 조건에 맞는지 유효성 검사
     */
    private String inputValidater() {
        if (playerNumberList == null) {
            return null;
        }
        for (int i = 0; i < playerNumberList.size(); i++) {
            int inputNum = numberChecker(playerNumberList.get(i));
            playerNumberList.set(i, inputNum);
            duplicateChecker(inputNum);
        }

        if (playerNumberList.contains(-1)) {
            playerNumberList = null;
            return "[ERROR]: 올바른 숫자를 입력해 주세요.";
        }
        return null;
    }

    /**
     * 문자를 숫자타입으로 변경
     * @param str 입력받은 문자 하나
     * @return 타입 변환된 수
     */
    private int typeChecker(String str) {
        if (playerNumberList == null) {
            return -1;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    /**
     * 변환 된 수 가 게임 조건에 맞는지 검사
     * @param number 수
     * @return number가 게임 조건에 맞다면 number, 아니라면 -1
     */
    private int numberChecker(int number) {
        if (playerNumberList == null) {
            return -1;
        }

        if (number > 0 && number < 10) {
            return number;
        }

        return -1;
    }

    /**
     * 중복 수 를 검사
     * @param inputNum 입력 수
     */
    private void duplicateChecker(int inputNum) {
        int firstIndex = -1;
        if (playerNumberList.contains(inputNum)) {
            firstIndex = playerNumberList.indexOf(inputNum);
        }

        List tmpList = playerNumberList.subList(firstIndex + 1, playerNumberList.size());
        if (tmpList.contains(inputNum)) {
            playerNumberList.set(firstIndex, -1);
        }
    }
}
