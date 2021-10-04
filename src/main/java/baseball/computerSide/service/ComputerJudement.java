package baseball.computerSide.service;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerJudement {

    public ComputerJudement() {
    }

    public static List<Integer> createNumberList(int startNum, int endNum, int numLen) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(Randoms.pickNumberInRange(startNum, endNum));

        while (numberList.size() != numLen){
            int createdNum = Randoms.pickNumberInRange(startNum, endNum);
            numberList = validateNumber(createdNum, numberList);
        }

        return numberList;
    }

    private static List validateNumber(int createdNum, List numberList) {
        if (numberList.indexOf(createdNum) == -1){
            numberList.add(createdNum);
        }

        return numberList;
    }

    public static boolean judge(List<Integer> computerNumbers, List<Integer> playerNumbers){
        int[] answer = new int[2];
        for (int i = 0; i < computerNumbers.size(); i++){
            answer = strikeChecker(computerNumbers.get(i), playerNumbers, i, answer);
            answer = ballChecker(computerNumbers.get(i), playerNumbers, i, answer);
        }
        System.out.println(reporting(answer));
        if (answer[0] == 3){
            return true;
        }
        return false;
    }

    private static int[] strikeChecker(int origin, List<Integer> playerNumbers, int currentIndex, int[] answer){
        if (origin == playerNumbers.get(currentIndex)){
            answer[0] += 1;
        }
        return answer;
    }

    private static int[] ballChecker(int origin, List<Integer> playerNumbers, int currentIndex, int[] answer){
        List tmp = new ArrayList(playerNumbers);
        tmp.remove(currentIndex);
        if (tmp.contains(origin)){
            answer[1] += 1;
        }
        return answer;
    }

    private static String reporting(int[] answer){
        String result = "";
        if (answer[0] > 0){
            result = answer[0] + "스트라이크 ";
        }
        if (answer[1] > 0){
            result += answer[1] + "볼 ";
        }
        if (result.length() == 0 ){
            result = "낫싱";
        }
        return result;
    }
}
