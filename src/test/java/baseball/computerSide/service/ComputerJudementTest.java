package baseball.computerSide.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerJudementTest {

    @DisplayName("길이: 3")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @Test
    void computerCreateListTest() {
        int startNum = 1;
        int endNum = 9;
        int numLen = 3;
        List resultList = ComputerJudement.createNumberList(startNum, endNum, numLen);
        assertEquals(3, resultList.size(), "컴퓨터의 숫자 생성이 잘못되었습니다.");
        System.out.println(resultList);
    }

    @DisplayName("같을때")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"132/132", "153/153", "632/632", "326/326", "942/942"})
    void judgementTest(String strc) {
        String[] arry = strc.split("");

        List<Integer> computer = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[0]));
            add(Integer.parseInt(arry[1]));
            add(Integer.parseInt(arry[2]));
        }};

        List<Integer> player = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[4]));
            add(Integer.parseInt(arry[5]));
            add(Integer.parseInt(arry[6]));
        }};

        boolean result = ComputerJudement.judge(computer, player);
        assertEquals(true, result, "정답 판별 불가능");
    }

    @DisplayName("다를때")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"132/235", "153/641", "632/732", "326/523", "942/172"})
    void judgementTestSecond(String strc) {
        String[] arry = strc.split("");

        List<Integer> computer = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[0]));
            add(Integer.parseInt(arry[1]));
            add(Integer.parseInt(arry[2]));
        }};

        List<Integer> player = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[4]));
            add(Integer.parseInt(arry[5]));
            add(Integer.parseInt(arry[6]));
        }};

        boolean result = ComputerJudement.judge(computer, player);
        assertEquals(false, result, "정답 판별 불가능");
    }

    @DisplayName("3스트라이크")
    @Test
    void judgeTest3Strike(){
        List<Integer> computerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        List<Integer> playerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        ComputerJudement.judge(computerSide, playerSide);
        String msg = ComputerJudement.getReportMsg();
        assertEquals("3스트라이크 ", msg, "정답 판별 불가능");
    }

    @DisplayName("2스트라이크")
    @Test
    void judgeTest2Strike(){
        List<Integer> computerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        List<Integer> playerSide = new ArrayList<Integer>() {{
            add(2);
            add(6);
            add(4);
        }};
        ComputerJudement.judge(computerSide, playerSide);
        String msg = ComputerJudement.getReportMsg();
        assertEquals("2스트라이크 ", msg, "정답 판별 불가능");
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void judgeTest1Strike2Ball(){
        List<Integer> computerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        List<Integer> playerSide = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(7);
        }};
        ComputerJudement.judge(computerSide, playerSide);
        String msg = ComputerJudement.getReportMsg();
        assertEquals("1스트라이크 2볼", msg, "정답 판별 불가능");
    }

    @DisplayName("3볼")
    @Test
    void judgeTest3Ball(){
        List<Integer> computerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        List<Integer> playerSide = new ArrayList<Integer>() {{
            add(7);
            add(4);
            add(2);
        }};
        ComputerJudement.judge(computerSide, playerSide);
        String msg = ComputerJudement.getReportMsg();
        assertEquals("3볼", msg, "정답 판별 불가능");
    }

    @DisplayName("낫싱")
    @Test
    void judgeTestNothing(){
        List<Integer> computerSide = new ArrayList<Integer>() {{
            add(2);
            add(7);
            add(4);
        }};
        List<Integer> playerSide = new ArrayList<Integer>() {{
            add(1);
            add(8);
            add(3);
        }};
        ComputerJudement.judge(computerSide, playerSide);
        String msg = ComputerJudement.getReportMsg();
        assertEquals("낫싱", msg, "정답 판별 불가능");
    }


}