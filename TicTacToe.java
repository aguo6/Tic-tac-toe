package tictac;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class TicTacToe extends JFrame implements MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;
	public static TicTacToe instance;

	public Square[] squares;
	// keep track of who's turn it is
	public boolean is_X_turn = true;
	public boolean game_over = false;
	public String result;

	public TicTacToe() {
		// create squares
		squares = new Square[9];
		for (int i = 0; i < 9; i++) {
			// positioning the squares
			int x = 10 + (i % 3) * 155;
			int y = 120 + (i / 3) * 155;
			squares[i] = new Square(x, y);
		}

		// prepare JFrame
		setSize(480, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		// center on screen
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
		setVisible(true);

		// draw all squares
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// double-buffer to reduce flashing
		Image buffer = createImage(getWidth(), getHeight());
		Graphics g2 = buffer.getGraphics();
		draw(g2);
		g.drawImage(buffer, 0, 0, null);
		g.dispose();
	}

	public void draw(Graphics g) {
		// draw white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// add key and mouse listener
		addMouseListener(this);
		addKeyListener(this);

		// draw turn marker
		g.setColor(Color.BLACK);
		g.setFont(new Font("sans-serif", Font.PLAIN, 13));
		int y = 80;
		String string = "It's " + (is_X_turn ? "X" : "O") + "'s turn";
		FontMetrics metrics = g.getFontMetrics();
		// draw the string in the middle of the screen
		g.drawString(string, getWidth() / 2 - metrics.stringWidth(string) / 2, y);

		// draw squares
		for (int i = 0; i < 9; i++) {
			squares[i].draw(g);
		}

		// game over?
		if (game_over) {
			g.setColor(new Color(0, 0, 0, 184));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			string = "Game over. " + result;
			g.setFont(new Font("sans-serif", Font.BOLD, 27));
			metrics = g.getFontMetrics();
			g.drawString(string, getWidth() / 2 - metrics.stringWidth(string) / 2,
					getHeight() / 2 - metrics.getHeight() / 2);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!game_over) {
			for (int i = 0; i < 9; i++) {
				if (squares[i].isHit(e.getX(), e.getY())) {
					Square square = squares[i];
					// process a click for that square
					if (!square.isBlank()) {
						// don't bother dealing with a square already taken
						break;
					}

					// change square state to new state
					square.setState((is_X_turn ? Square.State.X : Square.State.O));
					// change turns
					is_X_turn = !is_X_turn;

					// check win
					if ((squares[0].equals(squares[1]) && squares[1].equals(squares[2]))
							|| (squares[3].equals(squares[4]) && squares[4].equals(squares[5]))
							|| (squares[6].equals(squares[7]) && squares[7].equals(squares[8]))
							|| (squares[0].equals(squares[3]) && squares[3].equals(squares[6]))
							|| (squares[1].equals(squares[4]) && squares[4].equals(squares[7]))
							|| (squares[2].equals(squares[5]) && squares[5].equals(squares[8]))
							|| (squares[0].equals(squares[4]) && squares[4].equals(squares[8]))
							|| (squares[2].equals(squares[4]) && squares[4].equals(squares[6]))) {
						game_over = true;
						result = (!is_X_turn ? "X" : "O") + " wins.";
					} else {
						boolean filled = true;
						for (int j = 0; j < 9; j++) {
							if (squares[j].isBlank()) {
								filled = false;
								break;
							}
						}
						if (filled) {
							game_over = true;
							result = "Tie.";
						}
					}
					break;
				}
			}
		}
		// redraw the board
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (game_over && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			// reset game state
			game_over = false;
			result = "";
			is_X_turn = true;

			for (int i = 0; i < 9; i++) {
				// positioning the squares
				int x = 10 + (i % 3) * 155;
				int y = 120 + (i / 3) * 155;
				squares[i] = new Square(x, y);
			}
			repaint();
		}
	}

	// stupid required functions
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	// main function
	public static void main(String[] args) {
		instance = new TicTacToe();
	}
}
