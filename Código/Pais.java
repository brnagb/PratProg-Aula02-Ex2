package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Pais {
	//Atributos
   int id;
   String nome;
   long populacao;
   double area;
   int maiorPopulacao;
   int menorPopulacao;
   int vetorTresPaises;
	
	//Construtor
   public Pais() {
   
   }
	
   public Pais (int id, String nome, long populacao, double area) {
      this.id = id;
      this.nome = nome;
      this.populacao = populacao;
      this.area = area;
   }
	
	// Obtém conexão com o banco de dados
   public Connection obtemConexao() throws SQLException {
      return DriverManager
         .getConnection("jdbc:mysql://localhost/pais?user=alunos&password=alunos");
   }
	//Criar
   public void criar() {
      String sqlInsert = "INSERT INTO pais(nome, , populacao, area) VALUES (?, ?, ?)";
   
      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setString(1, getNome());
         stm.setString(2, getpopulacao());
         stm.setString(3, getarea());
         stm.execute();
         String sqlQuery = "SELECT LAST_INSERT_ID()";
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
         ResultSet rs = stm2.executeQuery();) {
            if(rs.next()){
               setId(rs.getInt(1));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
	//Atualizar
   public void atualizar() {
      String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
   
      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
         stm.setString(1, getNome());
         stm.setString(2, getpopulacao());
         stm.setString(3, getarea());
         stm.setInt(4, getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
	//Excluir
   public void excluir() {
      String sqlDelete = "DELETE FROM pais WHERE id = ?";
   
      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
	//Carregar
   public void carregar() {
      String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
   
      try (Connection conn = obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
         stm.setInt(1, getId());
         try (ResultSet rs = stm.executeQuery();) {
            if (rs.next()) {
               setNome(rs.getString("nome"));
               setPopulacao(rs.getString("populacao"));
               setArea(rs.getString("area"));
            } else {
               setId(-1);
               setNome(null);
               setPopulacao(null);
               setArea(null);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (SQLException e1) {
         System.out.print(e1.getStackTrace());
      }
   }
	
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public long getPopulacao() {
      return populacao;
   }

   public void setPopulacao(long populacao) {
      this.populacao = populacao;
   }

   public double getArea() {
      return area;
   }

   public void setArea(double area) {
      this.area = area;
   }
	
   public int getMaiorPopulacao(Pais[] pais){
	   if(this.getPais.Populacao() > this.maiorpopulacao)
	      this.maiorpopulacao = pais.getPopulacao();
	        return this.maiorpopulacao;
   } 
   
   public int getMenorPopulacao(Pais[] pais){
       if(pais.getPopulacao() < this.menorpopulacao)
          this.menorpopulacao = pais.getPopulacao();
       return this.menorpopulacao; 
   }
   
   public int getVetorTresPaises(String nome){
	  this.vetorTresPaises = new int [3];			  
   }

}
