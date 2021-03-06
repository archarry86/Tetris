package Math;

import IndieGame.GenericGame;

public class Vector2D {

	
	public float getX() {
		return _x;
	}

	public float getY() {
		return _y;
	}

	private float _x;
	
	
	private float _y;
	
	public Vector2D(){
		_x = 0;
		_y = 0;
	}
	
	
	public Vector2D(float x, float y){
		_x = x;
		_y = y;
	}
	
	
	
	
	public static Vector2D Add(Vector2D a, Vector2D b){
		
		return new Vector2D(a._x+b._x, a._y+ b._y);
	}

	public Vector2D Copy() {
		return new Vector2D(_x,_y);
	}

	public Vector2D Multiply(int scalar) {
		// TODO Auto-generated method stub
		return new Vector2D(_x* scalar,_y* scalar);
	}
	
	public Vector2D Div(int scalar) {
		// TODO Auto-generated method stub
		return new Vector2D(_x/ scalar,_y/ scalar);
	}
	
	public String toString()
	{
		return "("+_x+","+_y+")";
	
	}
}
