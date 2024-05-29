package game;

public class BadFileFormatException extends Exception
{
    private String _message;
    private int _row;
    private int _col;

    public BadFileFormatException (String message, int row, int col)
    {
        this._message = message;
        this._row = row;
        this._col = col;
    }

    @Override
    public String toString() {
        return "BadFileFormatException {" +
                "message = '" + _message + '\'' +
                (_row >= 0?
                ", row = " + _row : "") +
                (_col >= 0?
                ", col = " + _col : "") +
                '}';
    }
}
