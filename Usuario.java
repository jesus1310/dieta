import java.util.ArrayList;

/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    //Atributo para guardar el nombre del usuario
    private String nombre;
    //Atributo que guarda las proteinas ingeridas
    private float proteinasIngeridas;
    //Atributo que guarda los carbohidratos ingeridos
    private float carbohidratosIngeridos;
    //Atributo que guarda las grasas ingeridas
    private float grasasIngeridas;
    //Atributo que guarda las calorias ingeridas
    private float caloriasIngeridas;
    //Atributo que guarda el alimento mas calorico
    private Alimento masCalorico;
    //ArrayList para almacenar todos los alimentos ingeridos por el usuario
    private ArrayList<Alimento> alimentosIngeridos;
    
    /**
     * Constructor para objetos de la clase Usuario.
     */
    public Usuario(String nombre){
        this.nombre = nombre;
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        masCalorico = null;
        alimentosIngeridos = new ArrayList<Alimento>();
    }
    
    /**
     * Método para que el usuario coma algún alimento, pasando por parámetro el alimento y la cantidad de dicho alimento expresada en gramos.
     */
    public void comer(Alimento producto,float gramos){
        proteinasIngeridas = proteinasIngeridas + (producto.getProteinas() * (gramos / 100));
        carbohidratosIngeridos = carbohidratosIngeridos + (producto.getCarbohidratos() * (gramos / 100));
        grasasIngeridas = grasasIngeridas + (producto.getGrasas() * (gramos / 100));
        caloriasIngeridas = caloriasIngeridas + (producto.getCalorias() * (gramos / 100));
        
        if (masCalorico != null){
            if (masCalorico.getCalorias() <= producto.getCalorias()){
                masCalorico = producto; 
            }
        }
        else{
            masCalorico = producto;
        }
        alimentosIngeridos.add(producto);
    }
    
    /**
     * Método que muestra los datos de las cantidades ingeridas por el usuario.
     */
    public void mostrarDatos(){
        if (proteinasIngeridas != 0 || carbohidratosIngeridos != 0 || grasasIngeridas != 0){
            float totales = proteinasIngeridas + carbohidratosIngeridos + grasasIngeridas;
            System.out.println("Nombre de usuario: " + nombre);
            System.out.println("Proteínas ingeridas: " + proteinasIngeridas + "(" + (proteinasIngeridas / totales * 100) + "%)");
            System.out.println("Carbohidratos ingeridos: " + carbohidratosIngeridos + "(" + (carbohidratosIngeridos / totales * 100) + "%)");
            System.out.println("Grasas ingeridas: " + grasasIngeridas + "(" + (grasasIngeridas / totales * 100) + "%)");
            System.out.println("Calorias totales: " + caloriasIngeridas);
        }
        else{
            System.out.println("Nombre de usuario: " + nombre);
            System.out.println("Proteínas ingeridas: " + proteinasIngeridas);
            System.out.println("Carbohidratos ingeridos: " + carbohidratosIngeridos);
            System.out.println("Grasas ingeridas: " + grasasIngeridas);
            System.out.println("Calorias totales: " + caloriasIngeridas);
        }
    }
    
    /**
     * Método que muestra las calorias totales ingeridas por el usuario
     */
    public float getCaloriasTotales(){
        return caloriasIngeridas;
    }
    
    /**
     * Método que muestra el nombre del usuario
     */
    public String  getNombre(){
        return nombre;
    }
    
    /**
     * Método que compara las calorias totales del usuario sobre el que se invoca con las del usuario pasado por parámetro
     */
    public void comparaCalorias(Usuario usuario){
        String nombreMayor = nombre;
        String nombreMenor = usuario.getNombre();
        if (getCaloriasTotales() < usuario.getCaloriasTotales()){
            nombreMayor = usuario.getNombre();
            nombreMenor = nombre;
            System.out.println(nombreMayor + " ha ingerido más calorías que " + nombreMenor + 
            "(" + usuario.getCaloriasTotales() + " frente a " + getCaloriasTotales() + ")");
        }
        else if (getCaloriasTotales() == usuario.getCaloriasTotales()){
            System.out.println("Ambos usuarios han ingerido las mismas calorías, " + getCaloriasTotales());
        }        
        else{
            System.out.println(nombreMayor + " ha ingerido más calorías que " + nombreMenor + 
            "(" + getCaloriasTotales() + " frente a " + usuario.getCaloriasTotales() + ")");
        }
    }
    
    /**
     * Método para mostrar el alimento más calórico ingerido por el usuario
     */
    public void alimentoMasCalorico(){
        if (masCalorico == null){
            System.out.println("El usuario aun no ha ingerido ningún alimento");
        }
        else{
            System.out.println("El más calórico es " + masCalorico.getNombre() + " con " + masCalorico.getCalorias() + " calorias");
        }
    }
    
    /**
     * Método que muestra por pantalla las caracteristicas de un alimento ingerido por el usuario.
     * Mostrará el alimento que ocupe la posición indicada por parámetro.
     * El primer alimento ocupa la posición 1, el segundo la posición 2, etc.
     */
    public void mostrarDatosAlimento(int posicion){
        if (posicion >= 1 && posicion <= alimentosIngeridos.size()){
            int indice = posicion - 1;
            Alimento alimentoPosicionParametro = alimentosIngeridos.get(indice);
            alimentoPosicionParametro.muestraDatos();
        }
        else{
            System.out.println("El índice introducido no es válido");
        }
    }
    
    /**
     * Método que muestra si un alimento cuyo nombre se pasa por parámetro ha sido ingerido por el usuario.
     * Tambien muestra cuantas veces lo ha ingerido
     */
    public void cantidadDeAlimentoIngerido(String nombreDelAlimento){
        int contador = 0;
        for(Alimento alimentoBuscado : alimentosIngeridos){
            if (alimentoBuscado.getNombre().contains(nombreDelAlimento)){
                contador = contador + 1;
            }
        }
        
        if (contador >= 2){
            System.out.println("Se han encontrado " + contador + " veces el alimento cuyo nombre coincide con el texto buscado " + "(" + nombreDelAlimento + ")");
        }
        else if (contador == 0){
            System.out.println("No se han encontrado alimentos cuyo nombre contenga el texto buscado" + "(" + nombreDelAlimento + ")");
        }
        else {
             System.out.println("Se ha encontrado " + contador + " vez el alimento cuyo nombre coincide con el texto buscado " + "(" + nombreDelAlimento + ")");
        }
    }
    
    /**
     * Método que muestra por pantalla si algún alimento se ha ingerido mas de una vez, en caso de que los haya.
     * Si no los hubiera, se informará de ello
     */
    public void ingeridosMasDeUnaVez(){
        int contNombreRepetido = 0;
        String nombreAlimentoEncontrado = null;
        ArrayList<String> listaNombres = new ArrayList<String>();
        int indice = 0;
        for (Alimento alimentoLocalizado : alimentosIngeridos){
            if (nombreAlimentoEncontrado != alimentoLocalizado.getNombre()){
                nombreAlimentoEncontrado = alimentoLocalizado.getNombre();
            }
            listaNombres.add(nombreAlimentoEncontrado);
            if (listaNombres.get(indice) == nombreAlimentoEncontrado){
                contNombreRepetido = contNombreRepetido + 1;
            }
            indice = indice + 1;
        }
        System.out.println(listaNombres);
    }
}
