package Chess.Figures;

import Chess.Desk.Cell;
import Chess.Desk.MoveChecker;
import Chess.Desk.MoveTemplate;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Rook extends Figure{
    public Rook(Color color) {
        super("rook", color);
    }
    public MoveTemplate[] legalDirections = new MoveTemplate[]{
            new MoveTemplate(0, +1), new MoveTemplate(0, -1),
            new MoveTemplate(+1, 0), new MoveTemplate(-1, 0),
    };
    private final Set<MoveTemplate> Cells = Set.of();
    private final Set<MoveTemplate> Directions = Set.of(
            MoveChecker.Directions.get("rightHorizontal"),
            MoveChecker.Directions.get("leftHorizontal"),
            MoveChecker.Directions.get("upperVertical"),
            MoveChecker.Directions.get("downVertical"));

    @Override
    public Figure copy() {
        return new Rook(this.color);
    }

    public Set<MoveTemplate> getCells() {
        return Cells;
    }
    public Set<MoveTemplate> getDirections() {
        return Directions;
    }
    @Override
    public void move(Cell[] cells) {
        if (cells.length == 0)
            return;
        for (var i = 1; i < cells.length - 1; i++){
            var cell = cells[i];
            if (cell.getFigure() != null)
                return;
        }
        if (cells[cells.length - 1].getFigure() != null && cells[cells.length - 1].getFigure().color == color){
            return;
        }
        cells[0].moveFigure(cells[cells.length - 1]);
    }
}
