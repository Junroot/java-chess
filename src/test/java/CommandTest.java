import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import chess.domain.command.Command;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    @DisplayName("시작 커맨드")
    void startCommand() {
        assertThat(Command.foundCommandByIndex("start")).isEqualTo(Command.START);
    }

    @Test
    @DisplayName("종료 커맨드")
    void endCommand() {
        assertThat(Command.foundCommandByIndex("end")).isEqualTo(Command.END);
    }

    @Test
    @DisplayName("시작 커맨드에 인자를 입력할 경우 예외 처리")
    void startCommandWithArgument() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Command.foundCommandByIndex("start a1")
        ).withMessage("유효하지 않은 입력입니다.");
    }

    @Test
    @DisplayName("종료 커맨드에 인자를 입력할 경우 예외 처리")
    void endCommandWithArgument() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Command.foundCommandByIndex("end a1")
        ).withMessage("유효하지 않은 입력입니다.");
    }

    @Test
    @DisplayName("무브 커맨드")
    void moveCommand() {
        assertThat(Command.foundCommandByIndex("move a1 a2")).isEqualTo(Command.MOVE);
    }

    @Test
    @DisplayName("무브 커맨드의 인자가 부족하거나 넘는 경우 예외처리")
    void moveCommandWithInvalidArgumentCount() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Command.foundCommandByIndex("move a1")
        ).withMessage("유효하지 않은 입력입니다.");

        assertThatIllegalArgumentException().isThrownBy(() ->
            Command.foundCommandByIndex("move a1 a2 a3")
        ).withMessage("유효하지 않은 입력입니다.");
    }

    @Test
    @DisplayName("인자 리스트를 구하는 테스트")
    void testGetArguments() {
        assertThat(Command.arguments("start")).isEqualTo(Collections.emptyList());
    }
}
