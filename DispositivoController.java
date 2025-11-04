import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DispositivoController {
    
    public DispositivoController() { }

    /**
     * Se crean instancias de dispositivos variados y se agregan a la lista.
     */
    public void initCatalogo(ListaDispositivos lista) {
        if (lista == null) return;

        lista.agregarDispositivo(new SensorSuelo("S-001", "SoilPro A1", "AgroSense", 
                2.5, "activo", "Humedad", 100.0, 60));
        lista.agregarDispositivo(new SensorSuelo("S-002", "SoilLite B2", "GreenTech", 
                1.8, "activo", "Humedad", 90.0, 120));
        lista.agregarDispositivo(new EstacionMetereologica("E-001", "Estacion Norte", 
                "WeatherCo", 8.5, "activo", 
                new String[]{"Temperatura", "Humedad", "Lluvia"}, "Finca Norte"));
        lista.agregarDispositivo(new EstacionMetereologica("E-002", "Estacion Sur", 
                "MeteoCorp", 9.0, "inactivo", 
                new String[]{"Viento", "Presion", "Radiacion"}, "Finca Sur"));
        lista.agregarDispositivo(new DronRiego("D-001", "IrrigaX-10", "SkyAgro", 
                50.0, "activo", 10.0, 35.0));
        lista.agregarDispositivo(new DronRiego("D-002", "IrrigaLite", "AeroFarms", 
                45.0, "activo", 7.5, 28.0));
        lista.agregarDispositivo(new ValvulaAutomatica("V-001", "ValvulaCentral", 
                "ValveMakers", 5.0, "activo", 12.0));
        lista.agregarDispositivo(new ValvulaAutomatica("V-002", "ValvulaSector3", 
                "ValveMakers", 3.5, "inactivo", 8.0));

        lista.agregarDispositivo(new SensorSuelo("S-003", "SoilX Pro", "SmartSoil", 
                2.2, "activo", "Conductividad", 80.0, 30));
        lista.agregarDispositivo(new EstacionMetereologica("E-003", "Estacion Oeste", 
                "WeatherCo", 7.5, "activo", 
                new String[]{"Temperatura", "Humedad"}, "Finca Oeste"));
        lista.agregarDispositivo(new DronRiego("D-003", "SprayMax", "SkyAgro", 
                55.0, "inactivo", 12.0, 40.0));
    }

    /**
     * Listar todos los dispositivos
     */
    public List<Dispositivo> listarTodos(ListaDispositivos lista) {
        return lista == null ? new ArrayList<>() : lista.obtenerTodos();
    }

    /**
     * Buscar por ID
     */
    public Dispositivo buscarPorId(ListaDispositivos lista, String id) {
        if (lista == null || id == null) return null;
        return lista.obtenerPorId(id);
    }

    /**
     * Buscar por nombre (subcadena)
     */
    public List<Dispositivo> buscarPorNombre(ListaDispositivos lista, String nombre) {
        if (lista == null || nombre == null) return new ArrayList<>();
        return lista.obtenerPorNombre(nombre);
    }

    /**
     * Se usa Comparator para ordenar por consumo eléctrico
     */
    public List<Dispositivo> ordenarPorConsumo(ListaDispositivos lista) {
        List<Dispositivo> copia = lista == null ? new ArrayList<>() : lista.obtenerTodos();
        copia.sort(new Comparator<Dispositivo>() {
            @Override
            public int compare(Dispositivo d1, Dispositivo d2) {
                return Double.compare(d1.getConsumoElectrico(), d2.getConsumoElectrico());
            }
        });
        return copia;
    }
}