package view;

import java.util.Date;

import DAO.*;
import model.*;
public class Main {
	public static void main(String[] args){
		LivroDao livroDao=new LivroDao();
		Livro livro=new Livro();
		livro.
		setAutor("joao");
		livro.setDtPubli(new Date());
		livro.setGenero("terror");
		livro.setTitulo("teste");
		
		livroDao.create(livro);
		for(Livro l : livroDao.getAll()) {
			System.out.println("livro:"+l.getId());
		}
		System.out.println(livroDao.getOneByID(1).getId());
	}
}
