package baseball.computerSide.service;

import nextstep.utils.Console;

public class GameJudement {
    public GameJudement() {
    }

    public static int endSelect(){
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        int result = validateNumber(Console.readLine());
        if (result == 1){
            return 1;
        }
        if (result == 2){
            return 2;
        }
        return 0;
    }

    public static int validateNumber(String input){
        if (input.equals("1")){
            return 1;
        }

        if (input.equals("2")){
            return 2;
        }

        return 3;
    }
}
