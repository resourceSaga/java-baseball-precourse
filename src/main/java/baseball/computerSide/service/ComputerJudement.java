package baseball.computerSide.service;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoon SeoYul <devops.reso@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class ComputerJudement {

    public ComputerJudement() {
    }

    /**
     * 새로운 숫자 문자열을 생성한다.
     * @param startNum 시작 범위
     * @param endNum 끝 범위
     * @param numLen 문자열의 길이
     * @return 출제 문자열
     */
    public static List<Integer> createNumberList(int startNum, int endNum, int numLen) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(Randoms.pickNumberInRange(startNum, endNum));

        while (numberList.size() != numLen) {
            int createdNum = Randoms.pickNumberInRange(startNum, endNum);
            numberList = validateNumber(createdNum, numberList);
        }
        return numberList;
    }

    /**
     * 중복된 숫자가 아님을 검증한다.
     * @param createdNum 생성된 숫자
     * @param numberList 출제 문자열
     * @return 출제 문자열
     */
    private static List validateNumber(int createdNum, List numberList) {
        if (numberList.indexOf(createdNum) == -1) {
            numberList.add(createdNum);
        }
        return numberList;
    }

    /**
     * 플레이어 입력 문자열과 컴퓨터의 출제 문자열을 비교하여 정답 확인
     * @param computerNumbers 컴퓨터의 출제 문자열
     * @param playerNumbers 플레이어의 입력 문자열
     * @return 정답이라면 true, 아니라면 false
     */
    public static boolean judge(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int[] answer = new int[2];
        for (int i = 0; i < computerNumbers.size(); i++) {
            answer = strikeChecker(computerNumbers.get(i), playerNumbers, i, answer);
            answer = ballChecker(computerNumbers.get(i), playerNumbers, i, answer);
        }
        System.out.println(reporting(answer));
        if (answer[0] == 3) {
            return true;
        }
        return false;
    }

    /**
     * 사용자 입력 문자열이 스트라이크인지 확인하여 객체에 결과 저장
     * @param origin 검사할 숫자
     * @param playerNumbers 플레이어 입력 문자열
     * @param currentIndex 비교할 현재 위치
     * @param answer 결과 배열
     * @return 첫 번째 요소로 스트라이크 적중 수량을 가진 배열
     */
    private static int[] strikeChecker(int origin, List<Integer> playerNumbers, int currentIndex, int[] answer) {
        if (origin == playerNumbers.get(currentIndex)) {
            answer[0] += 1;
        }
        return answer;
    }

    /**
     * 사용자 입력 문자열이 볼인지 확인하여 객체에 결과 저장
     * @param origin 검사할 숫자
     * @param playerNumbers 플레이어 입력 문자열
     * @param currentIndex 비교할 현재 위치
     * @param answer 결과 배열
     * @return 두 번째 요소로 볼 적중 수량을 가진 배열
     */
    private static int[] ballChecker(int origin, List<Integer> playerNumbers, int currentIndex, int[] answer) {
        List tmp = new ArrayList(playerNumbers);
        tmp.remove(currentIndex);
        if (tmp.contains(origin)) {
            answer[1] += 1;
        }
        return answer;
    }

    /**
     * 스트라이크/볼 데이터를 바탕으로 결과를 출력해주는 메소드
     * @param answer 사용자 적중 결과
     * @return 출력할 문자열
     */
    private static String reporting(int[] answer) {
        String result = "";
        if (answer[0] > 0) {
            result = answer[0] + "스트라이크 ";
        }
        if (answer[1] > 0) {
            result += answer[1] + "볼 ";
        }
        if (result.length() == 0) {
            result = "낫싱";
        }
        return result;
    }
}
