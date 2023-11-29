package model;

public class Main {
	public static void main(String[] args){
		ConexaoDAO con=new ConexaoDAO();
		if(con.conectarBD()!=null) {
			System.out.print("ola");
		}
	}
}
