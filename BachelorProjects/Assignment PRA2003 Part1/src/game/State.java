package game;

import game.Game;
import main.Action;
import main.RC;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * State Class including the main game properties.
 * For PRA2003 (2020) Assignment part 1.
 * Juliette Maes i6230492
 */

public class State
{

    private int _rows;
    private int _cols;
    private char[][] _grid;
    private boolean _blasterUsed= false;

    private Game _ParentGame;

    private int _score;
    private int _safe;

    private int _numOfBots;
    private int _numOf2StepsBots;
    private int _numOf1StepBots;
    private ArrayList<RC> OneStepBotsList; // List of 1S robots
    private ArrayList<RC> TwoStepsBotsList; // list f 2S robots


    public Status get_status() {
        return _status;
    }

    private Status _status;
    private static final char Empty = '.';
    private static final char Player = '@';
    private static final char Robot_1 = '1';
    private static final char Robot_2 = '2';
    private static final char Heap = '#';
    private static final char Dead = 'X';

    private RC PlayerAt;

    public State (final int rows, final int cols, final int score, final int safe)
    {
        this._rows=rows;
        this._cols=cols;
        this._numOfBots = (_rows*_cols)/4;
        this._numOf2StepsBots = (int) Math.round(.1*_numOfBots);
        this._numOf1StepBots = (_numOfBots-_numOf2StepsBots);
        this._score=score;
        this._safe=safe;
        this._grid = new char [rows][cols];
        this._status = Status.Active;

        SetupGame();
    }

    public void SetParentGame(Game game)
    {
        this._ParentGame=game;
    }

    private void SetupGame()
    {
        // first initialize the grid

        for(int i=0; i< _grid.length; i++)
            for (int j=0; j < _grid[i].length; j++)
            {
                _grid[i][j] = Empty;
            }

        // now set the 1-step robots

        OneStepBotsList= new ArrayList<RC>();
        for(int i=0; i< _numOf1StepBots; i++)
            {
                int randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
                int randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
                //first verify space is not used
                while (_grid[randRow][randCol] != Empty)
                {
                    randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
                    randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
                }

                _grid[randRow][randCol] = Robot_1;
                OneStepBotsList.add(new RC(randRow,randCol));
            }

        // then set the 2-steps robots
    
        TwoStepsBotsList = new ArrayList<RC>();
        for(int i=0; i< _numOf2StepsBots; i++)
        {
            int randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
            int randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
            //first verify space is not used
            while (_grid[randRow][randCol] != Empty)
            {
                randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
                randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
            }

            _grid[randRow][randCol] = Robot_2;
            TwoStepsBotsList.add(new RC(randRow,randCol));
        }

        // now set the player

        {
            int randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
            int randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
            //first verify space is not used
            while (_grid[randRow][randCol] != Empty)
            {
                randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
                randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
            }

            _grid[randRow][randCol] = Player;
            PlayerAt = new RC(randRow, randCol);
        }

    }

    public Character get_spriteAt(int row, int col)
    {
        return (_grid[row][col]);
    }

    @Override
    public String toString()
    {
        String gridstr ="";

        for(int i=0; i< _grid.length; i++) {
            for (int j = 0; j < _grid[i].length; j++)
            {
                gridstr += _grid[i][j] + (j < _grid[i].length - 1 ? " " : "");
            }
            gridstr += "\n";
        }
        return _ParentGame.get_level() + "\n" +
                gridstr +
                "Score: " + _score + "\n" +
                "Robots: " +_numOfBots + "\n" +
                "Teleports: " + _safe + "\n" +
                (_blasterUsed ? "[NoBLAST]" : "[BLAST]") + "\n" +
                "Status: " + _status;
    }


     boolean playerStep(final Action action)
     {
     // Move the player one step in the specified direction, if possible.

         //clear old position
         boolean moved = false;

         _grid[PlayerAt.get_row()][PlayerAt.get_col()]= Empty;
         switch (action)
         {
             case U:
                 if (PlayerAt.get_row()==0 || _grid[PlayerAt.get_row()-1][PlayerAt.get_col()]!= Empty) moved=false; // bc of boundaries
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row() - 1, PlayerAt.get_col());
                     moved = true;
                 }
                 break;

             case UR:
                 if (PlayerAt.get_row()==0 || PlayerAt.get_col()== _grid[0].length-1
                 || _grid[PlayerAt.get_row()-1][PlayerAt.get_col()+1]!= Empty) moved= false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row()-1,PlayerAt.get_col()+1);
                 moved= true;
                 }
                 break;


             case R:
                 if (PlayerAt.get_col()== _grid[0].length-1 || _grid[PlayerAt.get_row()][PlayerAt.get_col()+1]!= Empty) moved= false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row(), PlayerAt.get_col() + 1);
                     moved = true;
                 }
                 break;

             case DR:
                 if (PlayerAt.get_row()==_grid.length-1 || PlayerAt.get_col()== _grid[0].length-1
                         || _grid[PlayerAt.get_row()+1][PlayerAt.get_col()+1]!= Empty) moved =  false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row() + 1, PlayerAt.get_col() + 1);
                     moved = true;
                 }
                 break;


             case D:
                 if (PlayerAt.get_row()== _grid.length-1 || _grid[PlayerAt.get_row()+1][PlayerAt.get_col()]!= Empty) moved =  false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row() + 1, PlayerAt.get_col());
                     moved = true;
                 }
                 break;


             case DL:
                 if (PlayerAt.get_row()==_grid.length-1 || PlayerAt.get_col()== 0
                         || _grid[PlayerAt.get_row()+1][PlayerAt.get_col()-1]!= Empty) moved = false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row() + 1, PlayerAt.get_col() - 1);
                     moved = true;
                 }
                 break;


             case L:
                 if (PlayerAt.get_col()== 0 || _grid[PlayerAt.get_row()][PlayerAt.get_col()-1]!= Empty) moved = false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row(), PlayerAt.get_col() - 1);
                     moved = true;
                 }
                 break;


             case UL:
                 if (PlayerAt.get_row()==0 || PlayerAt.get_col()== 0
                         || _grid[PlayerAt.get_row()-1][PlayerAt.get_col()-1]!= Empty) moved = false;
                 else {
                     PlayerAt.set_NewPos(PlayerAt.get_row() - 1, PlayerAt.get_col() - 1);
                     moved = true;
                 }
                 break;

         }

         _grid[PlayerAt.get_row()][PlayerAt.get_col()]= Player;
         return moved;

     // The destination cell must be an empty cell within the current grid area.
     // Return whether a step was performed.
     // ...

     }

     public boolean playerBlast()
    {
        Boolean gotOne=false;
        if (_blasterUsed) return false; // The blaster can only be used once per level.
        //kill all adjacent
        for (int i=Math.max(PlayerAt.get_row()-1,0); i <= Math.min(PlayerAt.get_row()+1, _grid.length-1);i++)
            for (int j= Math.max(PlayerAt.get_col()-1,0); j <= Math.min(PlayerAt.get_col()+1, _grid[0].length-1);j++) {
                if (_grid[i][j] == Robot_1) {
                    _grid[i][j] = Heap;
                    RC killed = null;
                    for(RC bot:OneStepBotsList)
                    {
                        if (bot.get_row() == i && bot.get_col() ==j)
                            killed = bot;
                    }
                    OneStepBotsList.remove(killed);
                    _numOfBots--;
                    _numOf1StepBots--;
                    _score++;
                    gotOne = true;
                }
                else if (_grid[i][j] == Robot_2) {
                    _grid[i][j] = Heap;
                    RC killed = null;
                    for(RC bot:TwoStepsBotsList)
                    {
                        if (bot.get_row() == i && bot.get_col() ==j)
                            killed = bot;
                    }
                    TwoStepsBotsList.remove(killed);
                    _numOfBots--;
                    _numOf2StepsBots--;
                    _score++;
                    gotOne = true;
                }
            }
            _blasterUsed = true;
            _ParentGame.set_score(_score);
            return gotOne;
    }

         void playerTeleport()
    {
        if (_safe<=0) return; //If the player's safe teleport count is greater than 0,
        else
        {
            // Teleport the player to a random empty cell.

            int randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
            int randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);

            //first verify space is not used

            while (!IsClearOf1Step(randRow,randCol) || !IsClearOf2Step(randRow,randCol))
            {
                randRow = Math.min((int) Math.round(Math.random() * _rows), _rows - 1);
                randCol = Math.min((int) Math.round(Math.random() * _cols), _cols - 1);
            }

            _grid[PlayerAt.get_row()][PlayerAt.get_col()] = Empty;
            _grid[randRow][randCol] = Player;
            PlayerAt.set_NewPos(randRow, randCol); // then choose a safe cell (i.e. no robot will step there)
            _safe--; // and decrement the safe teleport count.
        }
     }

     // Is space not used?

    private boolean IsClearOf1Step(int randRow, int randCol)
    {
        for (int i=Math.max(randRow-1,0); i <= Math.min(randRow+1, _grid.length-1);i++)
            for (int j= Math.max(randCol-1,0); j <= Math.min(randCol+1, _grid[0].length-1);j++)
                if (_grid[i][j] == Robot_1) return false;
        return true;
    }

    private boolean IsClearOf2Step(int randRow, int randCol)
    {
        for (int i=Math.max(randRow-2,0); i <= Math.min(randRow+2, _grid.length-1);i++)
            for (int j= Math.max(randCol-2,0); j <= Math.min(randCol+2, _grid[0].length-1);j++)
                if (_grid[i][j] == Robot_2) return false;
        return true;
    }

    void robotTurn()
     {

        /* //cleanup the deads
         for (int i = 0; i < _grid.length; i++)
             for (int j = 0; j < _grid[0].length;j++)
                 if (_grid[i][j]==Heap)  _grid[i][j] = Empty;*/

         char[][] tmpgrid = _grid.clone();
         ArrayList<RC> todlete1S = new ArrayList<RC>();
         ArrayList<RC> todlete2S = new ArrayList<RC>();

         for (RC robot1: OneStepBotsList
         ) {
             int newRow=robot1.get_row();
             int newCol=robot1.get_col();
             //move bot towards player
             //first free from location
             tmpgrid[robot1.get_row()][robot1.get_col()] = Empty;
             //move towards player
             if (PlayerAt.get_row()>robot1.get_row()) newRow = robot1.get_row() + 1;
             if (PlayerAt.get_row()<robot1.get_row()) newRow = robot1.get_row() - 1;
             if (PlayerAt.get_col()>robot1.get_col()) newCol = robot1.get_col() + 1;
             if (PlayerAt.get_col()<robot1.get_col()) newCol = robot1.get_col() - 1;
             robot1.set_NewPos(newRow,newCol);
             if (_grid[newRow][newCol] == Robot_1 || _grid[newRow][newCol] == Robot_2 || _grid[newRow][newCol] == Heap ) // got it... crash robot is dead
             {
                 tmpgrid[newRow][newCol] = Heap;
                 todlete1S.add(robot1);
                 _score++;
                 //now kill the guy I stepped onto
                 //first the little ones
                 for (RC theotherBot: OneStepBotsList
                 ) {
                     if (theotherBot.get_row()==newRow && theotherBot.get_col()==newCol) {
                         todlete1S.add(theotherBot);
                         _score++;
                         _numOfBots--;
                         _numOf1StepBots--;
                     }
                 }

                 //then the tough ones
                 for (RC theotherBot: TwoStepsBotsList
                 ) {
                     if (theotherBot.get_row()==newRow && theotherBot.get_col()==newCol)
                     {
                         todlete2S.add(theotherBot);
                         _score++;
                         _numOfBots--;
                         _numOf2StepsBots--;

                     }
                 }

             }
             else
                 tmpgrid[newRow][newCol] = Robot_1;
             if (PlayerAt.get_row()==newRow && PlayerAt.get_col()==newCol) // got it... player is dead
             {
                 tmpgrid[newRow][newCol] = Dead;
                 _status=Status.Dead;
                 _score = 0;
             }

         }

         for (RC robot2: TwoStepsBotsList
         ) {
             int newRow=robot2.get_row();
             int newCol=robot2.get_col();
             //move bot towards player
             //first free from location
             tmpgrid[robot2.get_row()][robot2.get_col()] = Empty;
             //move towards player
             if (PlayerAt.get_row()>robot2.get_row()) newRow = Math.min(robot2.get_row() + 2, _grid.length-1);
             if (PlayerAt.get_row()<robot2.get_row()) newRow = Math.max(robot2.get_row() - 2, 0);
             if (PlayerAt.get_col()>robot2.get_col()) newCol = Math.min(robot2.get_col() + 2, _grid[0].length-1);
             if (PlayerAt.get_col()<robot2.get_col()) newCol = Math.max(robot2.get_col() - 2,0);
             robot2.set_NewPos(newRow,newCol);
             if (_grid[newRow][newCol] == Robot_1 || _grid[newRow][newCol] == Robot_2 || _grid[newRow][newCol] == Heap) // got it... player is dead
             {
                 tmpgrid[newRow][newCol] = Heap;
                 todlete2S.add(robot2);
                 _score++;
                 //now kil the guy I stepped onto
                 //first the little ones
                 for (RC theotherBot: OneStepBotsList
                 ) {
                     if (theotherBot.get_row()==newRow && theotherBot.get_col()==newCol)
                     {
                         todlete1S.add(theotherBot);
                         _score++;
                     }
                 }
                 //then the tough ones
                 for (RC theotherBot: TwoStepsBotsList
                 ) {
                     if (theotherBot.get_row()==newRow && theotherBot.get_col()==newCol)
                     {
                         todlete2S.add(theotherBot);
                         _score++;
                     }
                 }
             }
             else
                tmpgrid[newRow][newCol] = Robot_2;
             if (PlayerAt.get_row()==newRow && PlayerAt.get_col()==newCol) // got it... player is dead
             {
                 _grid[newRow][newCol] = Dead;
                 _status=Status.Dead;
                 _score = 0;
             }

         }

         //finally kill them
         for (RC toDel: todlete1S)
         {
             OneStepBotsList.remove(toDel);
         }
         todlete1S.clear();

         for (RC toDel: todlete2S)
         {
             TwoStepsBotsList.remove(toDel);
         }
         todlete2S.clear();

         _grid = tmpgrid;  // grid is "updated"
         _ParentGame.set_score(_score);
         if (OneStepBotsList.size()==0 && TwoStepsBotsList.size()==0) _status = Status.Cleared; // Moves on to next level!

     }


    public boolean apply(final Action action)
 {
     if (action == Action.LastStand)
     {
         while (_status==Status.Active)
                 robotTurn();
     // Continue passing until the level is completed (one way or the other!)
     // ...
     }


    // Apply the player action
     if (action == Action.Teleport)
         {
             playerTeleport();
             robotTurn();
         // Do a teleport
         // ...
         }
     else if (action == Action.Blast)
         {
             playerBlast();
             robotTurn();
         // Try a blast
         // ...
         }
     else if (action == Action.Pass)
         {
             robotTurn();
         // Must be a player step
         // ...
         }
     else {
         playerStep(action);
         robotTurn();// apply the robots' response
     }
     return true;
     }
/**
* Assignment.
* For PRA2003 (2020) Assignment part 3.
* Juliette Maes i6230492
*/

public State ( final int level, final BufferedReader reader , Game game) throws BadFileFormatException, IOException

    {
        SetParentGame(game);
    _rows = level + 4;
    _cols = (_rows * 3 + 1) / 2;
    _grid = new char[_rows][_cols];
    try
        {
         load(reader);
        }
        catch (Exception e)
        {
            ResetGame();
        }
    }

public void load (final BufferedReader reader) throws BadFileFormatException
{
    OneStepBotsList= new ArrayList<RC>();
    TwoStepsBotsList= new ArrayList<RC>();
        for(int i=0; i<_rows; i++)
        {
            String line = "";

            try {
                line = reader.readLine();
            } catch (IOException e) {
                BadFileFormatException error = new BadFileFormatException("Invalid row data : " + line, i, -1);
            }

            line = line.replace(" ", "");

            for (int j = 0; j < _cols; j++)
            {
                char chr = line.charAt(j);
                if (chr != Empty && chr != Player && chr != Robot_1 && chr != Robot_2 && chr != Dead && chr!= Heap)
                {
                    throw new BadFileFormatException("Invalid Character : " + chr, i, j);
                }

                if (chr == Dead)
                {
                    ResetGame();
                }

                if (chr == Player)
                {
                    PlayerAt = new RC(i,j);
                }

                if (chr ==Robot_1) {
                 OneStepBotsList.add(new RC(i,j));
                }
                if (chr ==Robot_2) {
                    TwoStepsBotsList.add(new RC(i,j));
                }

                _grid[i][j] = chr;

            }
        }

        //Read the score
    String scoreStr = "";
    try {
        scoreStr = reader.readLine();
        // check this is a score line
        if (!scoreStr.contains("Score:"))
        {
            throw new Exception();
        }
        else
        {
            _score = Integer.parseInt(scoreStr.split(":")[1].trim()); // cut string in 2
        }
    }
    catch (Exception e)
    {
        BadFileFormatException err = new BadFileFormatException("Invalid Score line : " + scoreStr,-1,-1);
        throw err;
    }

    //Read the number of bots
    String numOfBotsStr = "";
    try {
        numOfBotsStr = reader.readLine();
        // check this is a score line
        if (!numOfBotsStr.contains("Robots:"))
        {
            throw new Exception();
        }
        else
        {
            _numOfBots = Integer.parseInt(numOfBotsStr.split(":")[1].trim()); // cut string in 2
        }
    }
    catch (Exception e)
    {
        BadFileFormatException err = new BadFileFormatException("Invalid Number of Robots line : " + numOfBotsStr,-1,-1);
        throw err;
    }

    // same for teleports
    String SafeTeleportsStr = "";
    try {
        SafeTeleportsStr = reader.readLine();
        // check this is a score line
        if (!SafeTeleportsStr.contains("Teleports:"))
        {
            throw new Exception();
        }
        else
        {
            _safe = Integer.parseInt(SafeTeleportsStr.split(":")[1].trim()); // cut string in 2
        }
    }
    catch (Exception e)
    {
        BadFileFormatException err = new BadFileFormatException("Invalid Number of Teleports line : " + SafeTeleportsStr,-1,-1);
        throw err;
    }

    //Blaster
    String BlasterStr = "";
    try {
        BlasterStr = reader.readLine();
        // check this is a score line
        if (!BlasterStr.contains("[BLAST]")  && !BlasterStr.contains("[NoBLAST]"))
        {
            throw new Exception();
        }
        else
        {
            _blasterUsed = (BlasterStr == "[NoBLAST]"); // check if blast used
        }
    }
    catch (Exception e)
    {
        BadFileFormatException err = new BadFileFormatException("Invalid Blaster line : " + BlasterStr,-1,-1);
        throw err;
    }

    // Status
    String StatusStr = "";
    try {
        StatusStr = reader.readLine();
        // check this is a score line
        if (!StatusStr.contains("Status:"))
        {
            throw new Exception();
        }
        else
        {
            _status = Status.valueOf(StatusStr.split(":")[1].trim()); // cut string in 2
        }
    }
    catch (Exception e)
    {
        BadFileFormatException err = new BadFileFormatException("Invalid Status line : " + StatusStr,-1,-1);
        throw err;
    }

}

public void ResetGame()
{
    _ParentGame.set_level(1);
    _rows = 1 + 4;
    _cols = (_rows * 3 + 1) / 2;
    _grid = new char[_rows][_cols];
    this._numOfBots = (_rows*_cols)/4;
    this._numOf2StepsBots = (int) Math.round(.1*_numOfBots);
    this._numOf1StepBots = (_numOfBots-_numOf2StepsBots);
    this._score=0;
    this._safe=_ParentGame.CalcSafe();
    this._status = Status.Active;
    SetupGame();
}

    public int get_Rows()
    {
        return _rows;
    }

    public int get_Cols()
    {
        return _cols;
    }
}
