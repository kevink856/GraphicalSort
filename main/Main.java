package main;

import java.awt.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import panels.Gui;
import panels.Settings;
import panels.TitlePanel;
import panels.DrawPanel;
import panels.Errors;

public class Main {

	private Gui gui;
	private Settings settings;
	private Errors errors;
	private JFrame guiFrame, settingsFrame, errorsFrame;
	private JPanel guiPanel, titlePanel, drawPanel;
	private List sortList;
	private JSpinner sortSpinner;
	public static int[] barHeights;
	public static int barWidth, barCount, currentBar, ghostBar, lastBar, sorti, sortj;

	public Main() {

		this.guiFrame = new JFrame("Graphical Sort");
		this.settingsFrame = new JFrame("Settings");
		this.errorsFrame = new JFrame("Error");

		this.guiPanel = new JPanel();
		this.titlePanel = new TitlePanel();
		this.drawPanel = new DrawPanel();

		this.sortList = new List(5, false);
		this.sortSpinner = new JSpinner(new SpinnerNumberModel(50, 10, 800, 1));

		sorti = 0;
		sortj = 0;
		barCount = 0;
		barWidth = 0;
		currentBar = -1;
		ghostBar = -1;
		lastBar = -1;
		barHeights = new int[0];

		this.gui = new Gui(drawPanel);
		this.settings = new Settings(sortSpinner, settingsFrame);
		this.errors = new Errors(errorsFrame);

		this.gui.makeGui(guiFrame, settingsFrame, errorsFrame, sortList, guiPanel, titlePanel);
		this.settings.makeSettings(guiFrame, sortList, guiPanel, titlePanel, drawPanel);
		this.errors.makeErrors();

	}

}