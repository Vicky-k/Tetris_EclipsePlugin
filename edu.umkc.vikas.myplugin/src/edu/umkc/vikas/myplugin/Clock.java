package edu.umkc.vikas.myplugin;

public interface Clock {
 
 void setCyclesPerSecond(float cyclesPerSecond);
	
	void reset() ;
	
	
	public void update() ;
	
	
	public void setPaused(boolean paused);
	
	
	public boolean isPaused();
	
	
	public boolean hasElapsedCycle();
	
	
	public boolean peekElapsedCycle();
	
	
	public long getCurrentTime() ;
}
