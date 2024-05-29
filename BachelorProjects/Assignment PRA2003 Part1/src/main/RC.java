package main;

/**
 * Class for Rows and Columns getters and setters.
 * For PRA2003 (2020) Assignment part 2.
 * Juliette Maes i6230492
 */

public class RC
{
    private int _row;
    private int _col;

    public RC(int row, int col)
    {
        this._col=col;
        this._row=row;
    }

    public int get_row()
    {
        return _row;
    }

    public int get_col()
    {
        return _col;
    }

    public void set_NewPos(int row, int col)
    {
        this._col=col;
        this._row=row;
    }

}
