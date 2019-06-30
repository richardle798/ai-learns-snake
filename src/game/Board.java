package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private static final int BOARD_WIDTH=50;
	private static final int BOARD_LENGTH=50;
	private static final int DELAY = 140;
	private static final int DOT_SIZE = 10;
	private static final int INITIAL_SIZE = 3;
	
	private boolean[][] boardContents;
	private SnakePart head;
	private SnakePart tail;
	private boolean inGame;
	private Timer timer;
	
	private int appleX;
	private int appleY;
	
	public Board() {
        addKeyListener(new KeyListener());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(BOARD_WIDTH*10, BOARD_LENGTH*10));
        initGame();
	}
	
    private void initGame() {
        boardContents = new boolean[BOARD_WIDTH][BOARD_LENGTH];
        initSnake();
        generateApple();

        timer = new Timer(DELAY, this);
        timer.start();
        
        inGame = true;
    }
    
    private void initSnake() {
    	SnakePart part = null;
    	for(int i=0; i < INITIAL_SIZE; i++) {
    		SnakePart newPart = new SnakePart(i,BOARD_LENGTH/2,part);
    		boardContents[i][BOARD_LENGTH/2] = true;
    		
    		part = newPart;
    		if(i == 0) {
    			tail = part;
    		}
    	}
    	
    	head = part;
    }
    
    private void generateApple() {
    	int x = (int) (Math.random() * BOARD_WIDTH);
    	int y = (int) (Math.random() * BOARD_LENGTH);

    	if(boardContents[x][y]) {
    		generateApple();
    	}
    	else {
    		appleX = x;
    		appleY = y;
    	}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

        	g.setColor(Color.GREEN);
        	g.fillOval(appleX*10, appleY*10, DOT_SIZE, DOT_SIZE);

        	SnakePart cur = tail;
            while(cur != null) {
                if (cur.equals(head)) {
                	g.setColor(Color.RED);
                } else {
                	g.setColor(Color.YELLOW);
                }
            	g.fillOval(cur.x*10, cur.y*10, DOT_SIZE, DOT_SIZE);

            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);
        }        
    }
    
    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2, HEIGHT / 2);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
