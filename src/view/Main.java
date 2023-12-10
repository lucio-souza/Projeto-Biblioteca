package view;
import java.sql.SQLException;

import DAO.*;
import model.*;
public class Main {
	public static void main(String[] args){
		EmprestimoDao e=new EmprestimoDao();
		
		try {
			System.out.println(e.getAll());
			e.devolverLivro(1);
			System.out.println(e.getOneById(1));
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		}
	}
