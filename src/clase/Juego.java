package clase;

public class Juego {

	private int id;
	private String nombre;
	private float jugabilidad;
	private float diseño;
	private float rejugabilidad;
	private float mundo;
	private float graficos;
	private float historia;
	private float banda_sonora;
	private float media;

	/********** METODOS **********/
	@Override
	public String toString() {
		return "Juego [id=" + id + ", juego=" + nombre + ", jugabilidad=" + jugabilidad + ", diseño=" + diseño
				+ ", rejugabilidad=" + rejugabilidad + ", mundo=" + mundo + ", graficos=" + graficos + ", historia="
				+ historia + ", banda_sonora=" + banda_sonora + ", media=" + media + "]";
	}

	/*************** GETTER && SETTER ***************/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getJugabilidad() {
		return jugabilidad;
	}

	public void setJugabilidad(float jugabilidad) {
		this.jugabilidad = jugabilidad;
	}

	public float getDiseño() {
		return diseño;
	}

	public void setDiseño(float diseño) {
		this.diseño = diseño;
	}

	public float getRejugabilidad() {
		return rejugabilidad;
	}

	public void setRejugabilidad(float rejugabilidad) {
		this.rejugabilidad = rejugabilidad;
	}

	public float getMundo() {
		return mundo;
	}

	public void setMundo(float mundo) {
		this.mundo = mundo;
	}

	public float getGraficos() {
		return graficos;
	}

	public void setGraficos(float graficos) {
		this.graficos = graficos;
	}

	public float getHistoria() {
		return historia;
	}

	public void setHistoria(float historia) {
		this.historia = historia;
	}

	public float getBanda_sonora() {
		return banda_sonora;
	}

	public void setBanda_sonora(float banda_sonora) {
		this.banda_sonora = banda_sonora;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
