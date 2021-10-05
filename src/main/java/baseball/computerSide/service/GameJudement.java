package baseball.computerSide.service;

import nextstep.utils.Console;
/**
 * @author Yoon SeoYul <devops.reso@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class GameJudement {

    public GameJudement() {
    }

    /**
     * 게임이 끝났을 때, 선택지
     * @return 플레이어의 선택, 새 시작 1, 종료 2, 잘못된 입력 0 반환
     */
    public static int endSelect() {
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        int result = validateNumber(Console.readLine());
        if (result == 1) {
            return 1;
        }
        if (result == 2) {
            return 2;
        }
        return 0;
    }

    /**
     * 사용자 입력 유효성 검증
     * @param input 사용자 입력 문자열
     * @return 1과 2가 아닌 모든 문자열은 3을 반환
     */
    public static int validateNumber(String input) {
        if (input.equals("1")) {
            return 1;
        }

        if (input.equals("2")) {
            return 2;
        }
        return 3;
    }
}
