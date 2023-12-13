package view;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.*;
import model.*;
public class Main {
	public static void main(String[] args){
		EmprestimoDao e=new EmprestimoDao();
		LivroDao l=new LivroDao();
		ClienteDao c=new ClienteDao();
		try {
			System.out.println(e.getAll());
			System.out.println(l.getAll());
			System.out.println(c.getAll());
			e.emprestar(new Emprestimo(16, 8, LocalDate.now()));
			System.out.println(e.getOneById(1));
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		}
	}
