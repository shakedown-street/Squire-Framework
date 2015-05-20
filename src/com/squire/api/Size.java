package com.squire.api;

/**
 * More wheel reinventing; this is a replacement for the 'Dimension' class in
 * Java's library.
 * 
 * @author Jordan Price
 */

public class Size {

	public int w, h;

	public Size(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}
}
