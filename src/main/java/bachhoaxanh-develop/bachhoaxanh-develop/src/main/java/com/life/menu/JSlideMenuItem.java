package com.life.menu;

import javax.swing.*;

public abstract class JSlideMenuItem {

	public abstract String getName();

	public abstract void setup(JComponent comp);
	
	public String toString() {
		return getName();
	}
	
}