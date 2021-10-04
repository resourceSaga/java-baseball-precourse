package baseball.playerSide.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerJudementTest {

    @DisplayName("유효한 입력")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"132", "153", "632", "326", "942"})
    void goodPlayerTest(String strs){
        String input = strs;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] arry = strs.split("");

        PlayerJudement playerJudement = new PlayerJudement(3);
        List list = playerJudement.getPlayerNumberList();
        List<Integer> ok = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[0]));
            add(Integer.parseInt(arry[1]));
            add(Integer.parseInt(arry[2]));
        }};
        System.out.println(input);
        assertEquals(ok, list,"유효하지 않은 사용자 입력 ");
    }

    @DisplayName("유효하지 않은 입력: ")
    @ParameterizedTest(name = "{displayName} input={0}")
    @ValueSource(strings = {"ab1", "122", "1ab", "!ab", "12a"})
    void bedPlayerCase1(String strs){
        String input = strs;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] arry = strs.split("");

        PlayerJudement playerJudement = new PlayerJudement(3);
        List list = playerJudement.getPlayerNumberList();
        List<Integer> ok = new ArrayList<Integer>() {{
            add(Integer.parseInt(arry[0]));
            add(Integer.parseInt(arry[1]));
            add(Integer.parseInt(arry[2]));
        }};
        System.out.println("사용자 입력 :" + input);
        assertEquals(ok, list,"유효하지 않은 사용자 입력 ");
    }

}