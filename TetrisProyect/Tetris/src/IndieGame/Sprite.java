package IndieGame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import Math.Vector2D;

public abstract class Sprite {
	protected int animPeriod= 1000/10;//TimeSpan.FromTicks((10000000 / 10)).Milliseconds;
	
    protected Vector2D position;
	protected  BufferedImage hojaSprite=null;
	protected int  []_pto=new int[]{0,0};
	protected int _width;
	protected int _height;

	protected GameContext _contexto=null;
	protected abstract Shape getShape();
	protected abstract void update();
	protected abstract void draw(Graphics2D g);

}

