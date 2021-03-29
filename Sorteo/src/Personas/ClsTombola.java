package Personas;

import DabaBase.ClsConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author JRA
 */
public class ClsTombola {
    
    public void listas(){
        
    ClsConexion con=new ClsConexion();
    
    String nomb;
    String nganador;
    int ganadores=10;
    
    ArrayList<String> milista=new ArrayList<String>();
    ArrayList<String> misganadores=new ArrayList<String>();
     
    try{
    con.AbrirConexion();
    String halar="select * from datos";
    Statement st=(Statement)con.conexion.createStatement();
    ResultSet rs=st.executeQuery(halar);
    
    while(rs.next()){
        nomb=rs.getString("Persona");
        milista.add(nomb);        
    }
      
    System.out.println("LA GRAN RIFA");
    System.out.println("Participantes: \n");
    imprimirTodo(milista);
    
    while(misganadores.size()!=ganadores){
        Collections.shuffle(milista);
        nganador=milista.get(ganadores);
        misganadores.add(nganador);
        milista.remove(nganador);
    }
    
    
        System.out.println("\nGanadores:"+"\n");
        Collections.sort(misganadores);
        imprimir(misganadores);
        
        con.CerrarConexion();
    
    }catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }
    
    public void imprimirTodo(Collection coll){
        Iterator iter=coll.iterator();
        
        while(iter.hasNext()){
            System.out.println(""+iter.next());
        }
    
    }
    public void imprimir(Collection col){
        Iterator it=col.iterator();
        while(it.hasNext()){
            System.out.println("Ganador: "+it.next());
        }
    }
}
