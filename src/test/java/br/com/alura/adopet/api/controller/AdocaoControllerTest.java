package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.service.AdocaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AdocaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdocaoService adocaoService;

    @Autowired
    private JacksonTester<SolicitacaoAdocaoDto> jsonDto;

    @Test
    void de4veriaDevolvercodigo400QuandoSolicitarAdocaoComDadosInvalidos() throws Exception {
        //ARRANGE
//        var json = "{}";
        var dto = new SolicitacaoAdocaoDto(null, null, "motivo");

        //ACT
        var response = mockMvc.perform(post("/adocoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto.write(dto).getJson())).andReturn().getResponse();

        //ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    void deveriaDevolvercodigo200QuandoSolicitarAdocaoComDadosValidos() throws Exception {
        //ARRANGE
        var dto = new SolicitacaoAdocaoDto(1l, 1l, "Motivo qualquer");
        //ACT
        var response = mockMvc.perform(post("/adocoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto.write(dto).getJson())).andReturn().getResponse();

        //ASSERT
        assertEquals(200, response.getStatus());
    }

}