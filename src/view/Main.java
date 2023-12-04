package view;

import java.time.LocalDate;
import DAO.*;
import model.*;
public class Main {
	public static void main(String[] args){
		LivroDao livroDao=new LivroDao();
		Livro livro=new Livro();
		livro.
		setAutor("joao");
		livro.setDtPubli(LocalDate.of(2002,12,04));
		livro.setGenero("terror");
		livro.setTitulo("teste");
		
		livroDao.create(livro);
		for(Livro l : livroDao.getAll()) {
			System.out.println(l.toString());
		}
		System.out.println(livroDao.getOneByID(4).toString());
		
		Livro li=new Livro("teste5",LocalDate.of(2022,12,20),"comedia","joao","disponivel");
		li.setId(4);
		
		livroDao.Update(li);
		livroDao.delete(1);
		for(Livro l : livroDao.getAll()) {
			System.out.println(l.toString());
		}
	}
}
