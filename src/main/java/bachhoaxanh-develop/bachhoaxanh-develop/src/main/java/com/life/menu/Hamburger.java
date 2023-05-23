package com.life.menu;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Hamburger {

	private static HashMap<Key, ImageIcon> cache = new HashMap<Key, ImageIcon>();

	private Hamburger() {
	}

	public static ImageIcon icon(int width, int height, float delta, boolean flip) {

		if (delta < 0f || delta > 1f)
			throw new IllegalArgumentException("Delta must be between 0.0f and 1.0f");

		Key k = new Key(width, height, delta, flip);
		if (cache.containsKey(k))
			return cache.get(k);

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		double w = (double) width;
		double h = (double) height;

		int top = 0, bottom = 0;
		if (h % 3 != 0) { // straighten out sub-pixel inequality
			top++;
			if ((h - 1) % 3 != 0)
				bottom++;
		}

		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.DARK_GRAY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (flip)
			g.rotate(Math.toRadians(180 * (1f - delta)), w / 2, h / 2);

		double fragmentSize = (h - top - bottom) / 3;
		double strokeSize = fragmentSize / 2.5;

		BasicStroke stroke = new BasicStroke((float) strokeSize);
		g.setStroke(stroke);

		Line2D.Double line1 = new Line2D.Double(0, (fragmentSize / 2) + top + (fragmentSize * delta),
				w - (w / 2 * delta), (fragmentSize / 2) + top - (strokeSize / 2 * delta));

		Line2D.Double line2 = new Line2D.Double(strokeSize * delta, (fragmentSize / 2) + fragmentSize + top, w,
				(fragmentSize / 2) + fragmentSize + top);

		Line2D.Double line3 = new Line2D.Double(0, (fragmentSize / 2) + fragmentSize * 2 + top - (fragmentSize * delta),
				w - (w / 2 * delta),
				(fragmentSize / 2) + fragmentSize * 2 + top + (strokeSize / 2 * delta) + bottom * delta);

		g.draw(line1);
		g.draw(line2);
		g.draw(line3);
		g.dispose();

		ImageIcon icn = new ImageIcon(img);
		cache.put(k, icn);

		return icn;
	}

	public static JComponent barFor(JSlideMenu menu, boolean flip) {
		JPanel hamburgerBar;
		JButton hamburgerButton;
		JLabel title;

		title = new JLabel("", JLabel.CENTER);
		hamburgerBar = new JPanel();
		hamburgerButton = new JButton();
		
		HamburgerController controller = new HamburgerController(hamburgerButton, flip);

		hamburgerButton.setIcon(icon(20, 20, 0f, flip));

		hamburgerButton.addActionListener(evt -> {
			if (menu.isShowing()) {
				if (menu.activeItem() != null)
					menu.closeItem();
				else
					menu.close();
			} else
				menu.open();
		});
		hamburgerButton.setContentAreaFilled(false);

		hamburgerBar.setLayout(new BorderLayout());
		hamburgerBar.add(hamburgerButton, BorderLayout.WEST);
		hamburgerBar.add(title, BorderLayout.CENTER);

		menu.addSlideMenuListener(new SlideMenuListener() {

			@Override
			public void menuOpened(JSlideMenu menu) {
				controller.increment();
			}

			@Override
			public void menuClosed(JSlideMenu menu) {
				controller.decrement();
			}

			@Override
			public void itemOpened(JSlideMenuItem item) {
				title.setText(item.toString());
			}

			@Override
			public void itemClosed(JSlideMenuItem item) {
				title.setText("");
			}

		});

		return hamburgerBar;
	}

	private static class Key {

		int width;
		int height;
		float delta;
		boolean flip;

		public Key(int w, int h, float delta, boolean flip) {
			width = w;
			height = h;
			this.delta = delta;
			this.flip = flip;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(delta);
			result = prime * result + (flip ? 1231 : 1237);
			result = prime * result + height;
			result = prime * result + width;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (Float.floatToIntBits(delta) != Float.floatToIntBits(other.delta))
				return false;
			if (flip != other.flip)
				return false;
			if (height != other.height)
				return false;
			if (width != other.width)
				return false;
			return true;
		}
	}

	private static class HamburgerController extends DeltaController {

		final static int size = 20;
		boolean flip;
		JButton button;

		HamburgerController(JButton b, boolean flip) {
			super(0.05f, 35);
			button = b;
			this.flip = flip;
		}

		@Override
		public void step() {
			if(getDelta() < .2f || getDelta() >.8f)
				setTimerDelay(35);
			else
				setTimerDelay(10);
			
			button.setIcon(icon(size, size, getDelta(), flip));
		}

	}

}
