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
    
    /**
     * Constructor para objetos de la clase Usuario.
     */
    public Usuario(String nombre){
        this.nombre = nombre;
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
    }
    
    /**
     * Método para que el usuario coma algún alimento, pasando por parámetro el alimento y la cantidad de dicho alimento expresada en gramos.
     */
    public void comer(Alimento producto,float gramos){
        proteinasIngeridas = proteinasIngeridas + (producto.getProteinas() * (gramos / 100));
        carbohidratosIngeridos = carbohidratosIngeridos + (producto.getCarbohidratos() * (gramos / 100));
        grasasIngeridas = grasasIngeridas + (producto.getGrasas() * (gramos / 100));
        caloriasIngeridas = caloriasIngeridas + (producto.getCalorias() * (gramos / 100));
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
}
