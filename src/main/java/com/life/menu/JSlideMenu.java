package com.life.menu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.LinkedList;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class JSlideMenu {

	private float listCoveringPercent;
	private int minListWidth;
	private boolean hideList;
	private boolean showing;
	private boolean closeOnIconify;
	private boolean closeOnOffMenuTouch;

	private JInternalFrame window;
	private JScrollPane scroll;
	private JPanel itemPanel;
	private JSlideMenuItem activeItem;
	private JList<JSlideMenuItem> list;
	private DefaultListModel<JSlideMenuItem> model;

	private ListController listController;
	private ItemController itemController;

	private Component comp;

	private LinkedList<SlideMenuListener> listeners;

	public JSlideMenu(JFrame parentFrame, Component comp) {
		this.comp = comp;

		listCoveringPercent = 0.25f;
		minListWidth = 100;
		hideList = false;
		closeOnIconify = true;
		closeOnOffMenuTouch = true;

		listController = new ListController();
		itemController = new ItemController();

		model = new DefaultListModel<>();
		list = new JList<JSlideMenuItem>(model);
		scroll = new JScrollPane(list) {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				if (hideList)
					return new Dimension((int) (comp.getWidth() * listController.getDelta()), comp.getHeight());

				return new Dimension( // Make sure it won't stick out of frame,
										// if minListWidth > getWidth
						Math.min((int) (comp.getWidth() * listController.getDelta()),
								Math.max((int) (minListWidth * listController.getDelta()), (int) ((comp.getWidth()
										/ (100 / (int) (listCoveringPercent * 100)) * listController.getDelta())))),
						comp.getHeight());
			}
		};

		scroll.setBorder(null);
		scroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(evt -> {
			if (evt.getValueIsAdjusting() || list.getSelectedIndex() < 0)
				return;

			openItem(getItem(list.getSelectedIndex()));
		});

		itemPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				if (hideList)
					return new Dimension((comp.getWidth() - (scroll.getPreferredSize().width)), comp.getHeight());

				return new Dimension(
						(int) ((comp.getWidth() - (scroll.getPreferredSize().width * listController.getDelta()))
								* itemController.getDelta()),
						comp.getHeight());

			}

		};

		itemPanel.setVisible(false);

		JPanel shadow = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				if(hideList)
					return itemPanel.getPreferredSize();
				
				return new Dimension(
						comp.getWidth() - (scroll.getPreferredSize().width  + itemPanel.getPreferredSize().width),
						comp.getHeight());
			}
		};

		shadow.setOpaque(false);

		shadow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				if (closeOnOffMenuTouch)
					close();
			}
		});

		window = new JInternalFrame();
		window.setLayout(new BorderLayout());
		window.add(scroll, BorderLayout.WEST);
		window.add(itemPanel, BorderLayout.CENTER);
		window.add(shadow, BorderLayout.EAST);
		((BasicInternalFrameUI) window.getUI()).setNorthPane(null);
		window.setBorder(null);

		parentFrame.getLayeredPane().add(window, Integer.valueOf(100));

		// shadow
		window.setOpaque(false);
		window.getContentPane().setBackground(new Color(0, 0, 0, 0));

		parentFrame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent evt) {
				list.invalidate();
				window.pack();
			}
		});

		parentFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowIconified(WindowEvent e) {
				if (closeOnIconify)
					close();
			}
		});

		listeners = new LinkedList<>();
	}

	public void addItem(JSlideMenuItem item) {
		model.addElement(item);
	}

	public void addItem(int index, JSlideMenuItem item) {
		model.add(index, item);
	}

	public void removeItem(int index) {
		model.remove(index);
	}

	public void removeItem(JSlideMenuItem item) {
		model.removeElement(item);
	}

	public int indexOf(JSlideMenuItem item) {
		return model.indexOf(item);
	}

	public JSlideMenuItem getItem(int index) {
		return model.get(index);
	}

	public void open() {
		if (showing)
			return;

		showing = true;
		window.setLocation(comp.getLocation());
		window.setVisible(true);

		listController.increment();

		for (SlideMenuListener l : listeners)
			l.menuOpened(this);
	}

	public void close() {
		if (!showing)
			return;

		showing = false;
		if (activeItem != null)
			closeItem();

		list.getSelectionModel().clearSelection();
		listController.decrement();

		for (SlideMenuListener l : listeners)
			l.menuClosed(this);
	}

	public void openItem(int index) {
		openItem(model.get(index));
	}

	public void openItem(JSlideMenuItem item) {
		if (hideList) {
			listController.decrement();
		}

		itemPanel.setVisible(true);
		itemPanel.removeAll();
		item.setup(itemPanel);

		boolean hasActiveItem = activeItem != null;
		activeItem = item;

		if (!hasActiveItem) {
			itemController.increment();
		}
		window.pack();

		for (SlideMenuListener l : listeners)
			l.itemOpened(item);
	}

	public void closeItem() {
		JSlideMenuItem i = activeItem;
		activeItem = null;
		itemController.decrement();

		if (hideList) {
			listController.increment();
		}
		list.getSelectionModel().clearSelection();
		window.pack();

		for (SlideMenuListener l : listeners)
			l.itemClosed(i);
	}

	public void setHideList(boolean aFlag) {
		if (hideList == aFlag)
			return;

		hideList = aFlag;
		if (activeItem != null)
			list.setVisible(!aFlag);

		list.invalidate();
		window.pack();
	}

	public void setListCoveringPercent(float percent) {
		if (percent == listCoveringPercent)
			return;

		listCoveringPercent = percent;
		list.invalidate();
		window.pack();
	}

	public boolean getHideList() {
		return hideList;
	}

	public boolean getCloseOnIconify() {
		return closeOnIconify;
	}

	public void setCloseOnIconify(boolean bool) {
		closeOnIconify = bool;
	}

	public boolean getCloseOnOffMenuTouch() {
		return closeOnOffMenuTouch;
	}

	public void setCloseOnOffMenuTouch(boolean bool) {
		closeOnOffMenuTouch = bool;
	}

	public JSlideMenuItem activeItem() {
		return activeItem;
	}

	public float getListCoveringPercent() {
		return listCoveringPercent;
	}

	public int getMinListWidth() {
		return minListWidth;
	}

	public void setMinListWidth(int lw) {
		minListWidth = lw;
		list.invalidate();
		window.pack();
	}

	public JList<JSlideMenuItem> getList() {
		return list;
	}

	public JScrollPane getScrollPane() {
		return scroll;
	}

	public void addSlideMenuListener(SlideMenuListener l) {
		listeners.add(l);
	}

	public void removeSlideMenuListener(SlideMenuListener l) {
		listeners.remove(l);
	}

	public boolean isShowing() {
		return showing;
	}

	private class ListController extends DeltaController {

		ListController() {
			super(0.05f);
		}

		@Override
		public void step() {
			if (getDelta() < .2f || getDelta() > .8f)
				setTimerDelay(25);
			else
				setTimerDelay(10);

			window.getContentPane().setBackground(new Color(0, 0, 0, (int)(115 * getDelta())));
			list.invalidate();
			window.pack();
		}

		@Override
		public void decrementComplete() {
			if (!isShowing())
				window.setVisible(false);
		}
	}

	private class ItemController extends DeltaController {

		ItemController() {
			super(0.05f);
		}

		@Override
		public void step() {
			if (getDelta() < .2f || getDelta() > .8f)
				setTimerDelay(25);
			else
				setTimerDelay(10);

			itemPanel.invalidate();
			window.pack();
		}

		@Override
		public void decrementComplete() {
			itemPanel.removeAll();
			itemPanel.setVisible(false);
		}
	}

}