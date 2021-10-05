package baseball.computerSide.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerJudementTest {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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

//    @BeforeEach
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }

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
        assertEquals(true, result, "정답 판별 에러");
//        assertEquals(3+"스트라이크 \n", outContent.toString(), "정답 판별 에러");
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
        assertEquals(false, result, "정답 판별 에러");


    }


}