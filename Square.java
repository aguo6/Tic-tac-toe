package tictac;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	public enum State {
		X, O, BLANK
	}

	private final int SQUARE_SIZE = 150;
	private int x, y;

	// keep track of what state this square is in
	private State state = State.BLANK;

	public Square(int _x, int _y) {
		// set the x and y of the square
		x = _x;
		y = _y;
	}

	public boolean isBlank() {
		return state == State.BLANK;
	}

	public void setState(State _state) {
		state = _state;
	}

	public State getState() {
		return state;
	}

	public boolean isHit(int _x, int _y) {
		return _x >= x && _x <= x + SQUARE_SIZE && _y >= y && _y <= y + SQUARE_SIZE;
	}

	public boolean equals(Square other) {
		return this.state == other.state && this.state != State.BLANK;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);

		if (state == State.X) {
			g.setColor(Color.RED);
			g.fillPolygon(new int[] { x + 6, x + 2, x + SQUARE_SIZE - 6, x + SQUARE_SIZE - 2 },
					new int[] { y + 2, y + 6, y + SQUARE_SIZE - 2, y + SQUARE_SIZE - 6 }, 4);
			g.fillPolygon(new int[] { x + SQUARE_SIZE - 6, x + SQUARE_SIZE - 2, x + 6, x + 2 },
					new int[] { y + 2, y + 6, y + SQUARE_SIZE - 2, y + SQUARE_SIZE - 6 }, 4);
		} else if (state == State.O) {
			g.setColor(Color.BLUE);
			g.fillArc(x + 2, y + 2, SQUARE_SIZE - 4, SQUARE_SIZE - 4, 0, 360);
			g.setColor(Color.WHITE);
			g.fillArc(x + 8, y + 8, SQUARE_SIZE - 16, SQUARE_SIZE - 16, 0, 360);
		}
	}
}
