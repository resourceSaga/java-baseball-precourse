package baseball.playerSide.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerComputerJudementTest {

    @DisplayName("유효한 입력")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"132", "153", "632", "326", "942"})
    void goodPlayerTest(String strs) {
        String input = strs;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] arry = strs.split("");

        PlayerJudement playerJudement = new PlayerJudement(3);
        playerJudement.init();
        List list = playerJudement.getPlayerNumberList();
        List<Integer> ok = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[0]));
            add(Integer.parseInt(arry[1]));
            add(Integer.parseInt(arry[2]));
        }};
        System.out.println(input);
        assertEquals(ok, list, "유효하지 않은 사용자 입력 ");
    }

    @DisplayName("유효하지 않은 입력: ")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"ab1", "122", "1ab", "!ab", "12a"})
    void bedPlayerCase1(String strs) {
        String input = strs;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PlayerJudement playerJudement = new PlayerJudement(3);
        playerJudement.init();
        playerJudement.getPlayerNumberList();
        String result = "[ERROR]: 올바른 숫자를 입력해 주세요.";
        assertEquals(result, playerJudement.getSystemMsg(), "유효하지 않은 입력 검사 불가");
    }

    @DisplayName("길이가 다른 입력: ")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"ab", "12", "1a5b", "!a", "1", "1234", "a"})
    void bedPlayerCase2(String strs) {
        String input = strs;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PlayerJudement playerJudement = new PlayerJudement(3);
        playerJudement.init();
        playerJudement.getPlayerNumberList();
        String result = "[ERROR]: 3자리의 수를 입력해주세요.";
        assertEquals(result, playerJudement.getSystemMsg(), "길이검사 에러");
    }

}