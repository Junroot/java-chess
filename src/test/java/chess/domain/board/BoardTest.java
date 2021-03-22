package chess.domain.board;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.piece.Piece;
import chess.dto.BoardDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board;

    @BeforeEach
    @DisplayName("보드의 초기 설정")
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("빈 보드 생성")
    void createBoard() {
        BoardDto actualBoard = board.boardDto();
        List<List<String>> expectedBoard = new ArrayList<>();
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));

        assertThat(expectedBoard).isEqualTo(actualBoard.board());
    }

    @Test
    @DisplayName("흑과 백이 대칭적으로 말을 놓는 기능")
    void putSymmetrically() {
        List<List<String>> expectedBoard = new ArrayList<>();
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", "R", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", "r", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        expectedBoard.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", "."));
        board.putSymmetrically(Piece.ROOK, Point.of("c3"));
        BoardDto actualBoard = board.boardDto();

        assertThat(expectedBoard).isEqualTo(actualBoard.board());
    }
}
