package game;

import main.Action;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * Assignment.
 * For PRA2003 (2020) Assignment part 4.
 * Juliette Maes i6230492
 */

public class GameView extends JPanel implements KeyListener
{
        private Game _game;

// the original images loaded
    BufferedImage oriPlayerImg;
    BufferedImage oriBot1Img;
    BufferedImage oriBot2Img;
    BufferedImage oriHeapImg;
    BufferedImage oriBonesImg;
// the canvas
    BufferedImage gridCanvas;
// the displayed (resized) version
    BufferedImage PlayerImg;
    BufferedImage Bot1Img;
    BufferedImage Bot2Img;
    BufferedImage HeapImg;
    BufferedImage BonesImg;

        HashMap<Character,BufferedImage> spritesMap = new HashMap<Character,BufferedImage>();

        private int _rows;
        private int _cols;
        private int lastPanelWidth = 0;
        private int lastPanelHeight = 0;

        private boolean canvasIsSetup = false;

        private int GridCellWidth;
        private int GridCellHeight;

        private final Set<Integer> pressed = new TreeSet<Integer>();

        private Timer keyTimer = null;
        private int   keyFlags = 0;

    private static final int  LEFT = 0x1;
    private static final int  UP = 0x2;
    private static final int  RIGHT = 0x4;
    private static final int  DOWN = 0x8;

    private JLabel statusLabel = null;

    Map<Integer, Integer> keyEventMap = Map.<Integer, Integer>of(KeyEvent.VK_LEFT, 0x1,
            KeyEvent.VK_UP, 0x2,
            KeyEvent.VK_RIGHT, 0x4,
            KeyEvent.VK_DOWN, 0x8,
            KeyEvent.VK_SPACE, 0x40,
            KeyEvent.VK_L, 0x10,
            KeyEvent.VK_S, 0x20,
            KeyEvent.VK_B, 0x80,
            KeyEvent.VK_T, 0x100);

    Map<Integer,Action> actionMap = new HashMap<Integer,Action>()
    {
    {
        put(0x1, Action.L);
        put(0x2, Action.U);
        put(0x3, Action.UL);
        put(0x4, Action.R);
        put(0x6, Action.UR);
        put(0x8, Action.D);
        put(0x9, Action.DL);
        put( 0x12, Action.DR);
        put(  0x30, Action.LastStand);
        put(   0x40, Action.Pass);
        put(     0x80, Action.Blast);
        put(    0x100, Action.Teleport);
    }};

    public GameView(Game game) throws IOException
        {
            this._game = game;

            addKeyListener(this);
            setFocusable(true);
            statusLabel = new JLabel("Score status", JLabel.SOUTH_EAST);
        }



    public void loadSprites() {
        try
        {
            oriPlayerImg = ImageIO.read(new File("player.png"));
            oriBot1Img   = ImageIO.read(new File("robot-1.png"));
            oriBot2Img   = ImageIO.read(new File("robot-2.png"));
            oriHeapImg   = ImageIO.read(new File("heap.png"));
            oriBonesImg  = ImageIO.read(new File("bones.png"));
        }
        catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

        public void SetUpView()
        {
            // resize image in each grid
            PlayerImg = resizeImg(oriPlayerImg, GridCellWidth, GridCellHeight);
            Bot1Img = resizeImg(oriBot1Img, GridCellWidth, GridCellHeight);
            Bot2Img = resizeImg(oriBot2Img, GridCellWidth, GridCellHeight);
            HeapImg = resizeImg(oriHeapImg, GridCellWidth, GridCellHeight);
            BonesImg = resizeImg(oriBonesImg, GridCellWidth, GridCellHeight);

            spritesMap.clear();
            spritesMap.put('@',PlayerImg);
            spritesMap.put('1',Bot1Img);
            spritesMap.put('2',Bot2Img);
            spritesMap.put('#',HeapImg);
            spritesMap.put('X',BonesImg);

            this.add(statusLabel);
            statusLabel.setLocation(10,10);
        }

    public void Show() {
            this.repaint();
    }


        public BufferedImage resizeImg(BufferedImage orig, int newWidth, int newHeight)
        {
            BufferedImage resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB); // make sure background is transparent
            Graphics2D g = resized.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
            g.drawImage(orig, 0, 0, newWidth, newHeight,0, 0, orig.getWidth(), orig.getHeight(), null);
            g.dispose();


           // RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON,
            // RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY

            //Image.SCALE_SMOOTH

            return resized;

        }


        public void SetUp_Canvas ()
        {
            lastPanelWidth = this.getWidth();
            lastPanelHeight = this.getHeight();
            gridCanvas = new BufferedImage(lastPanelWidth,lastPanelHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2dGrid = gridCanvas.createGraphics();
            _rows = _game.get_State().get_Rows();
            _cols = _game.get_State().get_Cols();


            // cell size
            GridCellHeight = ((this.getHeight()-20)/(_rows + 1));
            GridCellWidth = this.getWidth()/(_cols+1);

            int x0 = GridCellWidth/2;
            int y0 = GridCellHeight/2;

            // Draw the grid
            g2dGrid.setPaint(Color.white);
            g2dGrid.fillRect(0, 0, this.getWidth(), this.getHeight());
            final Color gridLight = new Color(240, 240, 240);
            final Color gridDark = new Color(190, 190, 190);
            for (int row = 0; row < _rows; row++)
                for (int col = 0; col < _cols; col++)
                {
                    final int x = x0 + GridCellWidth * col;
                    final int y = y0 + GridCellHeight * row;
                    g2dGrid.setPaint(gridDark);
                    g2dGrid.fillRect(x+1, y+1, GridCellWidth-1, GridCellHeight-1);
                    g2dGrid.setPaint(gridLight);
                    g2dGrid.fillRect(x+1, y+1, GridCellWidth-2, GridCellHeight-2);
                }

            canvasIsSetup = true;
        }


        public void paint(Graphics g)
        {
            //if canvs is not setup no need to paint whatsoever
            if (!canvasIsSetup) return;
            //check if size changed
            if (this.getWidth() != lastPanelWidth || this.getHeight() != lastPanelHeight)
            {
                SetUp_Canvas();  //the board
                SetUpView();   // the sprites
            }
            g.drawImage(gridCanvas,0,0, null);
            for (int i = 0; i < _rows; i++)
                for (int j = 0 ; j < _cols; j++)
                {
                    Character sprite = _game.get_State().get_spriteAt(i,j);
                    if (sprite != '.')
                    {
                        g.drawImage(spritesMap.get(sprite), (GridCellWidth/2) + GridCellWidth * j, (GridCellHeight/2) + GridCellHeight * i,null);
                    }
                }
        }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent arg0)
    {
        int c = arg0.getKeyCode();
        if (_game.get_State().get_status() == Status.Cleared) //any other key goes to next level (assigment requirement)
        {
            _game.nextLevel();
            this.SetUp_Canvas();
            this.SetUpView();
            repaint();
            return;
        }
        if (_game.get_State().get_status() == Status.Dead) // restart a new game if dead
        {
            //_game = new Game(1);
            _game.get_State().ResetGame();
            this.SetUp_Canvas();
            this.SetUpView();
            repaint();
            return;
        }
        if (keyEventMap.containsKey(c))
                keyFlags |= keyEventMap.get(c);
        if (keyTimer == null)
        {
            keyTimer = new Timer(100, keyTimerAction);
            keyTimer.start();
        }


    }

    ActionListener keyTimerAction =
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    keyTimer.stop();
                    keyTimer = null;
                    Action action = actionMap.get(keyFlags);
                    if (action != null) _game.get_State().apply(action);
                    keyFlags = 0;
                    repaint();
                }
            };

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
