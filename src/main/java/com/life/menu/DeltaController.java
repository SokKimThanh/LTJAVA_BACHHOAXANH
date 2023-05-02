package com.life.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class DeltaController {
	
	private float delta;
	private float deltaStep;
	
	private Timer timer;
	private boolean incrementing;
	
	public DeltaController(float deltaStep, int timerDelay) {
		setDeltaStep(deltaStep);
		
		delta = 0f;
		timer = new Timer(timerDelay, new EventHandler());
		incrementing = false;
	}
	
	public DeltaController(float deltaStep) {
		this(deltaStep, (int)(100*deltaStep));
	}
	
	public DeltaController() {
		this(0.25f);
	}

	public void increment() {
		if(isIncrementing())
			return;
		
		if(isRunning())
			stop();
		
		incrementing = true;
		incrementInit();
		timer.start();
	}
	
	public void decrement() {
		if(isDecrementing())
			return;
		
		if(isRunning())
			stop();
		
		incrementing = false;
		decrementInit();
		timer.start();
	}
	
	public void stop() {
		if(!isRunning())
			return;

		timer.stop();
		
		if(incrementing)
			incrementInterrupted();
		else
			decrementInterrupted();
	}
	
	public abstract void step();
	
	public void incrementInit() {
	}
	
	public void incrementComplete() {
	}
	
	public void incrementInterrupted() {
	}
	
	public void decrementInit() {
	}
	
	public void decrementComplete() {
	}
	
	public void decrementInterrupted() {
	}
	
	public float getDelta() {
		return delta;
	}
	
	public void setDelta(float newDelta) {
		if(newDelta < 0f || newDelta > 1f)
			throw new IllegalArgumentException("Delta values must be between 0.0f and 1.0f");
		
		delta = newDelta;
	}
	
	public float getDeltaStep() {
		return deltaStep;
	}
	
	public void setDeltaStep(float newDeltaStep) {
		if(newDeltaStep < 0f || newDeltaStep > 1f)
			throw new IllegalArgumentException("Delta step values must be between 0.0f and 1.0f");
		
		deltaStep = newDeltaStep;
	}
	
	public boolean isIncrementing() {
		return isRunning() && incrementing;
	}
	
	public boolean isDecrementing() {
		return isRunning() && !incrementing;
	}
	
	public boolean isRunning() {
		return timer.isRunning();
	}
	
	public int getTimerDelay() {
		return timer.getDelay();
	}
	
	public void setTimerDelay(int newDelay) {
		timer.setDelay(newDelay);
	}
	
	
	private class EventHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(isIncrementing()) {
				if(delta + deltaStep >= 1f) {
					delta = 1f;
					step();
					timer.stop();
					incrementComplete();
				} else {
					delta += deltaStep;
					step();
				}
			} else if(isDecrementing()) {
				if(delta - deltaStep <= 0f) {
					delta = 0f;
					step();
					timer.stop();
					decrementComplete();
				} else {
					delta -= deltaStep;
					step();
				}
			}
		}
	}
	
	
	
	
	
}
