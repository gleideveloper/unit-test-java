package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcProbabilidadeAdocaoTest {

    @Test
    @DisplayName("Probabilidade alta para gatos jovens com peso baixo")
    void probabilidadeAltaCenario1() {
        // idade 4 anos e 4kg -> probabilidade alta

        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDto(
                        "Abrigo feliz",
                        "949999-5541",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDto(
                        TipoPet.CACHORRO,
                        "Rex",
                        "Vira-lata",
                        4,
                        "Marrom",
                        4.0f
                ), abrigo);

        CalcProbabilidadeAdocao calc = new CalcProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calc.calcular(pet);

        assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    @DisplayName("Probabilidade média para gatos idosos com peso baixo")
    void probabilidadeMediaCenario2() {
        // idade 15 anos e 4kg -> probabilidade media

        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDto(
                        "Abrigo feliz",
                        "949999-5541",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDto(
                        TipoPet.CACHORRO,
                        "Rex",
                        "Vira-lata",
                        15,
                        "Marrom",
                        4.0f
                ), abrigo);

        CalcProbabilidadeAdocao calc = new CalcProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calc.calcular(pet);

        assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }

    @Test
    @DisplayName("Probabilidade média para gatos idosos com peso alto")
    void probabilidadeBaixaCenario3() {
        // idade 15 anos e 15kg -> probabilidade baixa

        Abrigo abrigo = new Abrigo(
                new CadastroAbrigoDto(
                        "Abrigo feliz",
                        "949999-5541",
                        "abrigofeliz@gmail.com"
                )
        );
        Pet pet = new Pet(
                new CadastroPetDto(
                        TipoPet.CACHORRO,
                        "Rex",
                        "Vira-lata",
                        15,
                        "Marrom",
                        20.0f
                ), abrigo);

        CalcProbabilidadeAdocao calc = new CalcProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calc.calcular(pet);

        assertEquals(ProbabilidadeAdocao.BAIXA, probabilidade);
    }
}