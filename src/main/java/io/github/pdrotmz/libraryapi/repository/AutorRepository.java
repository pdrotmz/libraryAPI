package io.github.pdrotmz.libraryapi.repository;

import io.github.pdrotmz.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
