package hilosConcurrentes;

public class Programa1 implements IPrograma {

	private final int _LIMITE = 1000;
	String _nombre = "Programa1";

	@Override
	public void cuenta(String nombreProceso) {
		for (int i = 0; i < _LIMITE; i++) {
			System.out.println(nombreProceso+ " "+_nombre + " contado hasta" + _LIMITE + " : " + i);
		}

	}

}
