package education;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Random;

public class Mark {
    private static final Random random = new Random();
    Mark() {}
    public static Mark randomMark(int maxMark){
        var mark = new Mark();
        mark.value = random.nextInt(maxMark);
        mark.isValid = false;
        mark.evaluatedAt = LocalDateTime.now();
        mark.evaluatedBy = "SYSTEM";
        return mark;
    }
    @Getter
    private int value;
    @Getter
    private boolean isValid;
    @Getter
    private LocalDateTime evaluatedAt;
    @Getter
    private String evaluatedBy;
}
