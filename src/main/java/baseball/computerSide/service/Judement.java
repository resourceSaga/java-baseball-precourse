package baseball.computerSide.service;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Judement {

    public Judement() {
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
}
