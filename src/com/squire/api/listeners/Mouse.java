package com.squire.api.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Because of the short time frame and my work schedule I was unable to
 * implement click/mouse handling.
 * 
 * @author Jordan Price
 *
 */
public class Mouse implements MouseListener, MouseMotionListener {
	
	public static int mouseX, mouseY, clickX, clickY = 0;

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Mouse.mouseX = e.getX();
		Mouse.mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Mouse.clickX = e.getX();
		Mouse.clickY = e.getY();
	}

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
	public void mouseReleased(MouseEvent e) {

	}

}
