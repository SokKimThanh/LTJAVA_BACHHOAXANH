package com.life.menu;

public interface SlideMenuListener {

	public void menuOpened(JSlideMenu menu);
	
	public void menuClosed(JSlideMenu menu);
	
	public void itemOpened(JSlideMenuItem item);
	
	public void itemClosed(JSlideMenuItem item);
}
