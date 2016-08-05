package edu.umkc.vikas.extension1;

import edu.umkc.vikas.myplugin.Clock;

public class ClockImplementation implements Clock {
	
	
	public float millisPerCycle;
	
	/**
	 * The last time that the clock was updated (used for calculating the
	 * delta time).
	 */
	public long lastUpdate;
	
	/**
	 * The number of cycles that have elapsed and have not yet been polled.
	 */
	public int elapsedCycles;
	
	/**
	 * The amount of excess time towards the next elapsed cycle.
	 */
	public float excessCycles;
	
	/**
	 * Whether or not the clock is paused.
	 */
	public boolean isPaused;
	
	public ClockImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCyclesPerSecond(float cyclesPerSecond) {
		this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
		//return cyclesPerSecond+50;
	}
	
	public void reset() {
		
		this.elapsedCycles = 0;
		this.excessCycles = 0.0f;
		this.lastUpdate = getCurrentTime();
		this.isPaused = false;
	}
	
	
	public void update() {
		
		long currUpdate = getCurrentTime();
		float delta = (float)(currUpdate - lastUpdate) + excessCycles;
		
		//Update the number of elapsed and excess ticks if we're not paused.
		if(!isPaused) {
			this.elapsedCycles += (int)Math.floor(delta / millisPerCycle);
			this.excessCycles = delta % millisPerCycle;
		}
		
		//Set the last update time for the next update cycle.
		this.lastUpdate = currUpdate;
	}
	
	
	public void setPaused(boolean paused) {
		this.isPaused = paused;
	}
	
	
	public boolean isPaused() {
		return isPaused;
	}
	
	
	public boolean hasElapsedCycle() {
		
		if(elapsedCycles > 0) {
			this.elapsedCycles--;
			return true;
		}
		return false;
	}
	
	
	public boolean peekElapsedCycle() {
		return (elapsedCycles > 0);
	}
	
	
	public long getCurrentTime() {
		return (System.nanoTime() / 1000000L);
	}

}
