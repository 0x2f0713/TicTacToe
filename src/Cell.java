/**
 * Created by CCNE on 09/09/2022.
 */
public class Cell {
    public CellStatus cellStatus;

    Cell() {
        this.cellStatus = CellStatus.Blank;
    }
    public boolean setCellStatus(CellStatus cellStatus) {
        if(this.cellStatus == CellStatus.Blank) {
            this.cellStatus = cellStatus;
            return true;
        }
        System.out.println("Invalid!");
        return false;
        
    }
}
