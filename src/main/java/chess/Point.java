package chess;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private static final Map<String, Point> POINT_POOL = new HashMap<>();

    static {
        for (Row row : Row.values()) {
            iterateXCoordinate(row);
        }
    }

    private final Column x;
    private final Row y;

    public Point(Column x, Row y) {
        this.x = x;
        this.y = y;
    }

    private static void iterateXCoordinate(Row row) {
        for (Column column : Column.values()) {
            POINT_POOL.put(
                column.getXCoordinate() + row.getYCoordinate(), new Point(column, row));
        }
    }

    public static Point of(String point) {
        validatePoint(point);
        return POINT_POOL.get(point);
    }

    private static void validatePoint(String point) {
        if (!POINT_POOL.containsKey(point)) {
            throw new IllegalArgumentException("존재하지 않는 좌표입니다.");
        }
    }


}
