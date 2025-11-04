import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner;
    private final DispositivoView dispositivoView;
    private final DispositivoController dispositivoController;
    private final FiltroController filtroController;
    private final ListaDispositivos lista;

    public MenuView(DispositivoController dc, FiltroController fc, ListaDispositivos lista) {
        this.scanner = new Scanner(System.in);
        this.dispositivoView = new DispositivoView();
        this.dispositivoController = dc;
        this.filtroController = fc;
        this.lista = lista;
    }

    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Sistema AgroTec - Menú Principal ===");
            System.out.println("1. Listar todos los equipos");
            System.out.println("2. Listar todos (detallado)");
            System.out.println("3. Buscar equipo por ID");
            System.out.println("4. Buscar equipo por nombre");
            System.out.println("5. Ordenar catálogo por consumo eléctrico");
            System.out.println("6. Mostrar dispositivos medibles (medir + reportar)");
            System.out.println("7. Mostrar dispositivos accionables (ejecutar/detener)");
            System.out.println("8. Mostrar dispositivos registrables (y registrar un evento)");
            System.out.println("9. Añadir dispositivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEnteroSeguro();
            switch (opcion) {
                case 1:
                    dispositivoView.mostrarListado(dispositivoController.listarTodos(lista));
                    break;
                case 2:
                    dispositivoView.mostrarListadoDetallado(dispositivoController.listarTodos(lista));
                    break;
                case 3:
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine().trim();
                    dispositivoView.mostrarDispositivo(dispositivoController.buscarPorId(lista, id));
                    break;
                case 4:
                    System.out.print("Ingrese nombre o parte del nombre: ");
                    String nombre = scanner.nextLine().trim();
                    dispositivoView.mostrarListado(dispositivoController.buscarPorNombre(lista, nombre));
                    break;
                case 5:
                    dispositivoView.mostrarListado(dispositivoController.ordenarPorConsumo(lista));
                    break;
                case 6:
                    dispositivoView.mostrarMediciones(filtroController.filtrarMedibles(lista));
                    break;
                case 7:
                    ejecutarAccionables();
                    break;
                case 8:
                    manejarRegistrables();
                    break;
                case 9:
                    agregarDispositivoDemo();
                    break;
                case 0:
                    System.out.println("Saliendo... ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private int leerEnteroSeguro() {
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void ejecutarAccionables() {
        List<Accionable> accionables = filtroController.filtrarAccionables(lista);
        if (accionables.isEmpty()) {
            System.out.println("No hay dispositivos accionables.");
            return;
        }
        System.out.println("Dispositivos accionables:");
        // Listar con índices
        List<Dispositivo> dispositivos = dispositivoController.listarTodos(lista);
        List<Integer> indices = new ArrayList<>();
        int i = 1;
        for (Dispositivo d : dispositivos) {
            if (d instanceof Accionable) {
                System.out.println(i + ". " + d.toString());
                indices.add(i - 1);
            }
            i++;
        }
        System.out.print("Seleccione el número del dispositivo para ejecutar acción (o 0 para volver): ");
        int opt = leerEnteroSeguro();
        if (opt <= 0 || opt > indices.size()) {
            System.out.println("Volviendo al menú...");
            return;
        }
        Dispositivo elegido = dispositivos.get(indices.get(opt - 1));
        Accionable act = (Accionable) elegido;
        System.out.println("1) Ejecutar acción");
        System.out.println("2) Detener acción");
        System.out.print("Seleccione: ");
        int actOpt = leerEnteroSeguro();
        if (actOpt == 1) {
            String res = act.ejecutarAccion();
            System.out.println("Resultado: " + res);
        } else if (actOpt == 2) {
            String res = act.detenerAccion();
            System.out.println("Resultado: " + res);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private void manejarRegistrables() {
        List<Registrable> regs = filtroController.filtrarRegistrables(lista);
        if (regs.isEmpty()) {
            System.out.println("No hay dispositivos registrables.");
            return;
        }
        System.out.println("Dispositivos registrables:");
        List<Dispositivo> dispositivos = dispositivoController.listarTodos(lista);
        List<Integer> indices = new ArrayList<>();
        int i = 1;
        for (Dispositivo d : dispositivos) {
            if (d instanceof Registrable) {
                System.out.println(i + ". " + d.toString());
                indices.add(i - 1);
            }
            i++;
        }
        System.out.print("Seleccione el número del dispositivo para registrar evento (o 0 para volver): ");
        int opt = leerEnteroSeguro();
        if (opt <= 0 || opt > indices.size()) {
            System.out.println("Volviendo al menú...");
            return;
        }
        Dispositivo elegido = dispositivos.get(indices.get(opt - 1));
        Registrable r = (Registrable) elegido;
        System.out.print("Ingrese descripción del evento a registrar: ");
        String evento = scanner.nextLine().trim();
        r.registrarEvento(evento);
        System.out.println("Evento registrado. Estado actual del dispositivo:");
        dispositivoView.mostrarDispositivo(elegido);
    }

    private void agregarDispositivoDemo() {
        System.out.println("Agregar dispositivo - elija tipo:");
        System.out.println("1) SensorSuelo");
        System.out.println("2) EstacionMeteorologica");
        System.out.println("3) DronRiego");
        System.out.println("4) ValvulaAutomatica");
        System.out.print("Tipo: ");
        int tipo = leerEnteroSeguro();
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Fabricante: ");
        String fab = scanner.nextLine().trim();
        System.out.print("Consumo electrico (W): ");
        double cons;
        try { 
            cons = Double.parseDouble(scanner.nextLine().trim()); 
        } catch (Exception e) { 
            cons = 1.0; 
        }
        System.out.print("Estado: ");
        String estado = scanner.nextLine().trim();

        switch (tipo) {
            case 1:
                System.out.print("Tipo de medicion: ");
                String tmed = scanner.nextLine().trim();
                System.out.print("Rango humedad (numero): ");
                double rango;
                try { 
                    rango = Double.parseDouble(scanner.nextLine().trim()); 
                } catch (Exception e) { 
                    rango = 100.0; 
                }
                System.out.print("Frecuencia muestreo (s): ");
                int freq;
                try { 
                    freq = Integer.parseInt(scanner.nextLine().trim()); 
                } catch (Exception e) { 
                    freq = 60; 
                }
                lista.agregarDispositivo(new SensorSuelo(id, nombre, fab, cons, estado, tmed, rango, freq));
                break;
            case 2:
                System.out.print("Sensores (separados por coma): ");
                String sens = scanner.nextLine().trim();
                String[] arr = sens.split("\\s*,\\s*");
                System.out.print("Ubicacion: ");
                String ubi = scanner.nextLine().trim();
                lista.agregarDispositivo(new EstacionMetereologica(id, nombre, fab, cons, estado, arr, ubi));
                break;
            case 3:
                System.out.print("Capacidad tanque (L): ");
                double cap;
                try { 
                    cap = Double.parseDouble(scanner.nextLine().trim()); 
                } catch (Exception e) { 
                    cap = 5.0; 
                }
                System.out.print("Autonomia vuelo (min): ");
                double aut;
                try { 
                    aut = Double.parseDouble(scanner.nextLine().trim()); 
                } catch (Exception e) { 
                    aut = 30.0; 
                }
                lista.agregarDispositivo(new DronRiego(id, nombre, fab, cons, estado, cap, aut));
                break;
            case 4:
                System.out.print("Presion maxima: ");
                double pres;
                try { 
                    pres = Double.parseDouble(scanner.nextLine().trim()); 
                } catch (Exception e) { 
                    pres = 10.0; 
                }
                lista.agregarDispositivo(new ValvulaAutomatica(id, nombre, fab, cons, estado, pres));
                break;
            default:
                System.out.println("Tipo inválido. Volviendo.");
                return;
        }
        System.out.println("Dispositivo agregado al catálogo.");
    }
}