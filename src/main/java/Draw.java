import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class Draw {

    @Autowired
    private final DrawType type;
    private Set<Integer> winningNumbers;

    public Draw() {
        this.type = DrawType.SCANDINAVIAN;
        this.winningNumbers = new HashSet<>();
    }

    public void drawNumbers() {
        while (winningNumbers.size() < type.getPlayingNumbers()) {
            winningNumbers.add(randomNumberGenerator());
        }
    }

    public int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(type.getNumberPool());
    }

    public void printWinningNumbers() {
        for (Integer winningNumber : winningNumbers) {
            System.out.println(winningNumber);
        }
    }


}
