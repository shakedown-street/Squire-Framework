package com.squire.api;

/**
 * A little bit of wheel reinventing; this is a replacement for the Point class
 * in Java's library.
 * 
 * @author Jordan Price
 */

public class Point {

	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the x and y to the new value given in the parameters.
	 * 
	 * @param x
	 *            The new x position
	 * @param y
	 *            the new y position
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Changes the x and y values by the value given in the parameters.
	 * 
	 * @param x
	 *            The value to add to x
	 * @param y
	 *            The value to add to y
	 */
	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
