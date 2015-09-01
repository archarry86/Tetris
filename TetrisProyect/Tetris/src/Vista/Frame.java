package Vista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import IndieGame.AbstractGame;
import IndieGame.GameProperties;
import IndieGame.GenericGame;

public class Frame extends JFrame {

	public static int ALTO_FRAME = 900;
	public static int ANCHO_FRAME = 700;
	public static String TITULO = "Tetris";

	private GenericGame abstractGame;
	private PnlLineas pnlLineas;

	public Frame() {

		super();

		GameProperties.loadProperties();

		abstractGame = new GenericGame();
		// ANCHO_FRAME = abstractGame.Width+50;
		// ALTO_FRAME = abstractGame.Height+100;

		setSize(ANCHO_FRAME, ALTO_FRAME);
		setTitle(TITULO);

		pnlLineas = new PnlLineas();

		abstractGame.setLineas(pnlLineas);
		// add(new JButton("asdasd"),BorderLayout.SOUTH);
		abstractGame.GameStar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(abstractGame);

		//System.out.println(this.getLayout().getClass().getName());

		// abstractGame.setBounds(0, 0, abstractGame.getWidth(),
		// abstractGame.getHeight());
		// pnlLineas.setBounds(abstractGame.getWidth()+3, 0,
		// pnlLineas.getWidth(), pnlLineas.getHeight());
		GridLayout experimentLayout = new GridLayout(0, 2);
		setLayout(experimentLayout);
		//System.out.println(abstractGame.getWidth());
		//System.out.println(this.abstractGame.getHeight());
		setSize(abstractGame.getWidth() + pnlLineas.getWidth() + 400,
				this.abstractGame.getHeight() + 100);
		add(abstractGame);
		add(pnlLineas);
		// setLayout(null);
	}

	public void paint(Graphics g) {

		super.paint(g);

		abstractGame.paintScreen();
		// pnlLineas.paint(g);
	}
}
