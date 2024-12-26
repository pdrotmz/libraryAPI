package io.github.pdrotmz.libraryapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.pdrotmz.libraryapi.model.Autor;
import io.github.pdrotmz.libraryapi.model.GeneroLivro;
import io.github.pdrotmz.libraryapi.model.Livro;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivroTest() {
        Livro livro = new Livro();

        livro.setIsbn("455948-664213");
        livro.setTitulo("O livro dos cinco anéis");
        livro.setDataPublicacao(LocalDate.of(1645, 5, 12));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(100));
        
        Autor autor = autorRepository.findById(UUID.fromString("04cb69bf-987b-485d-a762-f4d586e311b1")).orElseThrow();
        livro.setAutor(autor);

        livroRepository.save(livro);

    }

}