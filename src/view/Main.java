package view;

import DAO.*;
import model.*;

public class Main {
	public static void main(String[] args){
		LivroDao livrodao=new LivroDao();
		System.out.println(livrodao.getAll());
		System.out.println(livrodao.getOneByID(3));
		
		BibliotecarioDao biblidao=new BibliotecarioDao();
		biblidao.create(new Bibliotecario("lucio@gmail.com", 1234));
		Bibliotecario bibli=new Bibliotecario("leivas@gmail", 2222);
		bibli.setId(5);
		System.out.println(biblidao.getAll());
		System.out.println(biblidao.getOneById(1));
		biblidao.update(bibli);
		System.out.println(biblidao.getAll());
	}
}
