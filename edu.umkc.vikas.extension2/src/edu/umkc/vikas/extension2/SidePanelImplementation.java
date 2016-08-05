package edu.umkc.vikas.extension2;

import java.awt.Color;
import java.awt.Dimension;

import edu.umkc.vikas.myplugin.BoardPanel;
import edu.umkc.vikas.myplugin.SidePanel;
import edu.umkc.vikas.myplugin.Tetris;

public class SidePanelImplementation extends SidePanel {

	/*public SidePanelImplementation(Tetris tetris) {
		//super(tetris);
		// TODO Auto-generated constructor stub
	}*/
	
	public void initializeTetris(Tetris tetris){
		this.tetris=tetris;
	}
	
	public void setStyle(){
		setPreferredSize(new Dimension(200, BoardPanel.PANEL_HEIGHT));
		setBackground(Color.BLACK);
	}

}
