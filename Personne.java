public class Personne {
    public String nom;
    public int age;
    Personn( String nom,int age){
        this.nom=nom;
        this.age=age;
    }
    public int compareTo(Personn o) {
        return( this.age-o.age);
    }
    public String toString() {
        return "[ nom:"+nom+",age:"+age+"]";
    }

}
