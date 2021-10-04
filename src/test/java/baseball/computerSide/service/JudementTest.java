package baseball.computerSide.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class JudementTest {
    private int startNum, endNum, numLen;

    @DisplayName("길이: 3")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @Test
     void computerCreateListTest() {
        startNum = 1;
        endNum = 9;
        numLen = 3;
        List resultList = Judement.createNumberList(startNum, endNum, numLen);
        assertEquals(3, resultList.size(),"컴퓨터의 숫자 생성이 잘못되었습니다.");
        System.out.println(resultList);
    }
}