package io.github.pdrotmz.libraryapi.repository;

import io.github.pdrotmz.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
