package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	public Key keyPressed;
	
	public KeyListener() {
		keyPressed = null;
	}

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (keyPressed != Key.RIGHT)) {
            keyPressed = Key.LEFT;
        }

        if ((key == KeyEvent.VK_RIGHT) && (keyPressed != Key.LEFT)) {
            keyPressed = Key.RIGHT;

        }

        if ((key == KeyEvent.VK_UP) && (keyPressed != Key.DOWN)) {
            keyPressed = Key.UP;

        }

        if ((key == KeyEvent.VK_DOWN) && (keyPressed != Key.UP)) {
            keyPressed = Key.DOWN;

        }
    }
}