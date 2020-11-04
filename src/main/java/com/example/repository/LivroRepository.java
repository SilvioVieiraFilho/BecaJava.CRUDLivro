package com.example.repository;



import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Livro;






@Repository
public interface LivroRepository extends CrudRepository <Livro, Long> {
	






}
	 


