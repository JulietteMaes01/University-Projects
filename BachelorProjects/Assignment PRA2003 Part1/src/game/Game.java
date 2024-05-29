package game;

import java.io.*;

/**
 * Class for setting the bases of the game.
 * For PRA2003 (2020) Assignment part 1.
 * Juliette Maes i6230492
 */

public class Game
{
    private int _level;
    private State _state;
    private int _score;
    private String saveFileName = "GameState.txt";




    public Game(int level)
    {
        this._level = level;
        int _rows =this._level+4;
        int _cols=((_rows) * 3 + 1) / 2;
        this._state= new State(_rows,_cols, this._score , this.CalcSafe());
        this._state.SetParentGame(this);
    }
    public Game()
    {
        this._level=1;
        int _rows =this._level+4;
        int _cols=((_rows) * 3 + 1) / 2;
        this._state= new State(_rows,_cols, this._score, this.CalcSafe());
        this._state.SetParentGame(this);
    }
/**
* Assignment.
* For PRA2003 (2020) Assignment part 2.
* Juliette Maes i6230492
*/

    public int get_level()
    {
        return _level;
    }

    public void set_level(int _level)
    {
        this._level = _level;
    }

    public State get_State()
    {
       return _state;
    }

    public int CalcSafe()
    {
        return 3; //Will see that later
    }

    public void nextLevel()
    {
        _level++;
        int _rows =this._level+4;
        int _cols=((_rows) * 3 + 1) / 2;
        this._state= new State(_rows,_cols, this._score, this.CalcSafe());
        this._state.SetParentGame(this);
    }

/**
 * Assignment.
 * For PRA2003 (2020) Assignment part 3.
 * Juliette Maes i6230492
 */

public void load() throws BadFileFormatException, IOException
    {
        File test = new File(saveFileName);
        if (!test.exists()) return;
        FileReader FR = new FileReader(saveFileName);
        BufferedReader reader = new BufferedReader(FR);
        String levStr = reader.readLine(); // load _level from file
        try
        {

            _level = Integer.parseInt(levStr); // change String to integer format
        }

        catch (Exception e)
        {
            BadFileFormatException error = new BadFileFormatException("Invalid Level : " + levStr, -1, -1);
            throw error;
        }

        _state = new State(_level, reader, this);
    }

    public void save () throws IOException
    {
//        if (this.get_State().get_status() == Status.Dead) return; //don't save a game where you are dead
        final PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter(saveFileName, false)));

///not needed as treated by toString        out.println(_level);
        out.println(_state.toString());
        out.close();
    }


    public void set_score(int score) {
    this._score = score;
    }
}

