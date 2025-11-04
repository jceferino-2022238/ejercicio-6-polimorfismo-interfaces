/*
    Nombre: José Carlos Ceferino Fabián.
    Carné: 251043
    Ejercicio: implementación de interfaces con polimorfismo en Java.
    Descripción: programa para gestionar distintos tipos de dispositivos de monitoreo agrícola,
    utilizando interfaces para definir comportamientos comunes y una misma lista con polimorfismo.
*/

public class Main {
    public static void main(String[] args) {
        // Se crea la lista de dispositivos (modelo)
        ListaDispositivos lista = new ListaDispositivos();

        // Se crean los controladores
        DispositivoController dc = new DispositivoController();
        FiltroController fc = new FiltroController();

        // Inicializar catálogo
        dc.initCatalogo(lista);

        // Crear vista de menú y llamar el método para mostrar el menú principal
        MenuView menu = new MenuView(dc, fc, lista);
        menu.mostrarMenuPrincipal();
    }
}