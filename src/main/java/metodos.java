import java.util.ArrayList;
import java.util.Scanner;

public class metodos {
    public static void main(String[] args) {
        ArrayList<tarea> tareas = new ArrayList<>();
        tareas.add(new tarea("Crear metodo para calcular tiempo de trabajo", "completa", 3,
                "Contar unicamente las tareas no realizadas"));
        tareas.add(new tarea("X", "X", 10, "X"));
        tareas.add(new tarea("Pruebas unitarias", "incompleta", 10, "X"));
        //laBase(tareas);
        menu(tareas);
    }

    /*public static ArrayList<tarea> laBase(ArrayList<tarea> tareas){
        tareas.add(new tarea("Crear metodo para calcular tiempo de trabajo", "completa", 3,
                "Contar unicamente las tareas no realizadas"));
        tareas.add(new tarea("X", "X", 10, "X"));
        tareas.add(new tarea("Pruebas unitarias", "incompleta", 10, "X"));

        return tareas;
    }*/

    public static void menu(ArrayList<tarea> tareas) {
        String respuesta;
        do {
            tareaCompletada(tareas);
            tareaNoCompletada(tareas);
            tareaNoCompletadaD(tareas);
            imprimirOpcion(tareas);

            Scanner scanner= new Scanner(System.in);
            System.out.println("¿Desea hacer otra operación? s/n");
            respuesta= scanner.nextLine();

        }while(respuesta.equals("s"));
    }

    public static void tareaCompletada(ArrayList<tarea> tareas) {
        System.out.println("Tareas completadas:");

        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getEstado() == "completa") {
                    System.out.println("[ " + "x" + " ]" + " " + tareas.get(i).getTitulo());
                }
        }
    }

    public static void tareaNoCompletada(ArrayList<tarea> tareas) {
        System.out.println("Tareas NO completadas:");

        for (int i = 0; i < tareas.size(); i++) {
            try {
                if (tareas.get(i).getEstado() == "incompleta") {
                    System.out.println("[ " + " ]" + " " + tareas.get(i).getTitulo());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void tareaNoCompletadaD(ArrayList<tarea> tareas) {
        System.out.println("Tarea no completada con descripcion adjunta:");

        for (int i = 0; i < tareas.size(); i++) {
            try {
                if (tareas.get(i).getEstado() == "incompleta") {
                    System.out.println("[ " + " ]" + " " + tareas.get(i).getTitulo() + "-->>> " +
                            tareas.get(i).getDescripcion());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void imprimirOpcion(ArrayList<tarea> tareas) {
        System.out.println("----------------------------");
        System.out.println("Ingrese una operación");

        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("crear")) {
            crear(tareas);

        } else if (respuesta.equalsIgnoreCase("actualizar")) {
            actualizar(tareas);

        } else if (respuesta.equalsIgnoreCase("eliminar")) {
            eliminar(tareas);

        } else if (respuesta.equalsIgnoreCase("leer")) {
            leer(tareas);

        } else {
            System.out.println("La operación NO está bien escrita. Vuelva a intentarlo");
            imprimirOpcion(tareas);
        }
    }

    public static ArrayList<tarea> crear(ArrayList<tarea> tareas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A continuación añadirá una nueva tarea:");
        System.out.println("Rellene los datos que le pediremos");
        System.out.println("Título de la tarea:");
        String titulo = scanner.nextLine();

        System.out.println("Estado de la tarea (completa/incompleta):");
        String estado = scanner.nextLine();

        System.out.println("¿Alguna descripción a añadir?");
        String descripcion = scanner.nextLine();

        System.out.println("Tiempo de duración en minutos:");
        int tiempo = scanner.nextInt();

        tareas.add(new tarea(titulo, estado, tiempo, descripcion));

        return tareas;
    }

    public static ArrayList<tarea> actualizar(ArrayList<tarea> tareas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuál de las siguientes tareas quisieras modificar?");
        leer(tareas);
        int opcion= scanner.nextInt();

        System.out.println("¿Qué modificación quisiera hacerle?");
        System.out.println("[1] Título");
        System.out.println("[2] Estado");
        System.out.println("[3] Tiempo");
        System.out.println("[4] Descripcion");
        int opcion2= scanner.nextInt();

        System.out.println("A continuación anote lo que desea modificar:");
        scanner.nextLine();
        String cambio= scanner.nextLine();

        if(opcion2==1) {
            tareas.get(opcion).setTitulo(cambio);
        }else if(opcion2==2){
            tareas.get(opcion).setEstado(cambio);
        }else if(opcion2==3){
            try {
                int numero = Integer.valueOf(cambio);
                tareas.get(opcion).setTiempo(numero);
            }catch(Exception e){
                System.out.println("Lamentablemente lo que acabas de introducir por el teclado no es un" +
                        " valor número, VUELVA A INTENTARLO");
                actualizar(tareas);
            }
        }else if(opcion2==4){
            tareas.get(opcion).setDescripcion(cambio);
        }else{
            System.out.println("El número que acaba de colocar no cumple con ninguna de las opciones");
            System.out.println("Por favor, inténtelo nuevamente");
            actualizar(tareas);
        }
        return tareas;
    }

    public static ArrayList<tarea> eliminar(ArrayList<tarea> tareas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuál de las siguientes tareas quisieras eliminar?");

        for (int i = 0; i < tareas.size(); i++) {
            System.out.print("["+i+"]");
            System.out.println(tareas.get(i).getTitulo() + " | " + tareas.get(i).getEstado() + " | " +
                    tareas.get(i).getTiempo() + " | " + tareas.get(i).getDescripcion());
        }

        int opcion= scanner.nextInt();
        tareas.remove(opcion);
        System.out.println("¡Ha sido eliminado exitosamente!");

        return tareas;

    }

    public static void leer(ArrayList<tarea> tareas) {
        for (int i = 0; i < tareas.size(); i++) {
            System.out.print("["+i+"]");
            System.out.println(tareas.get(i).getTitulo() + " | " + tareas.get(i).getEstado() + " | " +
                    tareas.get(i).getTiempo() + " | " + tareas.get(i).getDescripcion());
        }
    }
}