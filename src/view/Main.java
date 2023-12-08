package view;

import java.time.LocalDate;


import DAO.*;
import model.*;

public class Main {
	public static void main(String[] args){
		LivroDao l=new LivroDao();
		ClienteDao c=new ClienteDao();
		System.out.println(l.getAll().toString());
		System.out.println(c.getAll().toString());
		EmprestimoDao empres=new EmprestimoDao();
		empres.Emprestar(new Emprestimo(6,4,LocalDate.of(2222, 12, 12)));
		for(Emprestimo e:empres.getAll()) {
		System.out.println(e);
		}
	}
}
