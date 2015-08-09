package IndieGame;

public interface GameContext {



	/// <summary>
	/// Devuelve la posicion del jugador
	/// </summary>
	/// <returns></returns>
	public abstract  int[][]  getPlayerPosition();

	/// <summary>
	/// Devuelve la direccion a donde mira el jugador
	/// </summary>
	/// <returns></returns>
	public abstract int getPlayerDirection();

	/// <summary>
	/// Devuelve el timepo transcurrido del juego
	/// </summary>
	/// <returns></returns>
	public abstract long getSecondsElapsed();

	/// <summary>
	/// Devuelve el estado del boton teniendo en cuenta el jugador
	/// </summary>
	/// <param name="player"></param>
	/// <param name="button"></param>
	/// <returns></returns>
	public abstract boolean keyState(Object player, Object button);

	/// <summary>
	/// Retorna el ancho de la pantalla
	/// </summary>
	/// <returns></returns>
	public abstract int getWhidth();

	/// <summary>
	/// Retorna el largo de la pantalla
	/// </summary>
	/// <returns></returns>
	public abstract int getHeight();
	
	
	public abstract boolean colisiono(Sprite s);
	

}
