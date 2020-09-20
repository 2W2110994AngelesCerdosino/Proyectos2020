/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTO.DTOReporte;
import DTO.DTOVisitas;
import Modelo.Empleados;
import Modelo.Pacientes;
import Modelo.Visitas;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.sql.*;



/**
 *
 * @author NotebookSFC
 */
public class Controller 
{
    public  String CONN = "jdbc:sqlserver://KEYROLI-DESKTOP:1433;databaseName=Visitas";
    private String USER = "sa";
    private String PASS = "Oliver88$";
    
    //open connection
    private Connection con;
    
     private void abrirConexion()
     {
         try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(CONN,USER,PASS);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
     }
     
     private void cerrarConexion()
     {
         try 
         {
             if(con!=null && !con.isClosed()) //VER ERROR
                 con.close();
         } 
         
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
     
     //agregar visita
     public void agregarVisita(Visitas v)
     {
         try 
         {
         abrirConexion();
         PreparedStatement ps = con.prepareStatement("INSERT INTO Visitas (idPaciente, LegajoRecepcionsta, Nombre, Duracion) VALUES (?,?,?,?)");
         ps.setInt(1, v.getPaciente().getIdPaciente());
         ps.setInt(2, v.getLegajoRecepcionista());
         ps.setString(3, v.getNombre());
         ps.setInt(4, v.getDuracion());
         ps.close();
                 
         } 
          catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
     }
     
     //obtener empleados
        public ArrayList<Empleados> obtenerEmpleado()
         {
             ArrayList<Empleados> lista = new ArrayList<Empleados>();
            try
            {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Empleados ");
            while(rs.next())
            {
                int legajo = rs.getInt("Legajo");
                String nombre = rs.getString("nombre");
                
                Empleados e = new Empleados(legajo, nombre);
                lista.add(e);
                
                }
                rs.close();
                con.close();
            } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return lista;    
        }
        
        //obtener paciente
        public ArrayList<Pacientes> obtenerPacientes()
         {
             ArrayList<Pacientes> lista = new ArrayList<Pacientes>();
            try
            {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pacientes ");
            while(rs.next())
            {
                int idPaciente = rs.getInt("IdPaciente");
                String nombre = rs.getString("nombre");
                
                Pacientes p = new Pacientes(idPaciente, nombre);
                lista.add(p);
                
                }
                rs.close();
                con.close();
            } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return lista;    
        }
            
     
     //obtener visita
     //Nombre del paciente, nombre del visitante, nombre del recepcionista, duración
     public ArrayList<DTOVisitas> obtenerVisitasDTO()
     {
         ArrayList<DTOVisitas> lista = new ArrayList<>();
         try
         {
             abrirConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT P.Nombre AS P_Nombre, V.Nombre as V_Nombre, E.Nombre AS E_Nombre, Duracion FROM Visitas V JOIN Pacientes P ON V.IdPaciente = P.IdPaciente JOIN Empleados E ON E.Legajo = V.LegajoRecepcionista ORDER BY P.Nombre");
             while(rs.next())
             {
                String P_Nombre = rs.getString("P_Nombre");
                String V_Nombre = rs.getString("V_Nombre");
                String E_Nombre = rs.getString("E_Nombre");
                int Duracion = rs.getInt("Duracion");
                DTOVisitas v = new DTOVisitas(E_Nombre, E_Nombre, E_Nombre, Duracion);
                lista.add(v);
                
             }
             rs.close();
              
             
         }
          catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
             
     }
     
     // SELECT P.Nombre,COUNT(*) AS Q_Visitantes FROM Visitas V JOIN Pacientes P ON V.IdPaciente = P.IdPaciente GROUP BY P.Nombre
     
     public ArrayList<DTOReporte> obtenerReporteDTO()
     {
         ArrayList<DTOReporte> lista = new ArrayList<>();
         try
         {
             abrirConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT P.Nombre, COUNT(*) AS Q_Visitantes FROM Visitas V JOIN Pacientes P ON V.IdPaciente = P.IdPaciente GROUP BY P.Nombre");
             while(rs.next())
             {
                String Nombre = rs.getString("Nombre");
                int Cantidad = rs.getInt("Q_Visitantes");
                DTOReporte v = new DTOReporte(Nombre, Cantidad);
                lista.add(v);
                
             }
             rs.close();
              
             
         }
          catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
             
     }
     
     
     public double PromedioVisitasMas10Min()
     {
        double promedio = 0; 
        String sql = "SELECT AVG(Duracion) AS AVG_D_Visita FROM Visitas WHERE Duracion > 1";
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            promedio = rs.getInt(1);
            rs.close();
            con.close();
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();                    
        }
        return promedio;    
     }
   
    
    
    
}
