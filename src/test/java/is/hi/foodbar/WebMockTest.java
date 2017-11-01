package is.hi.foodbar;


import is.hi.foodbar.controller.AddRestController;
import is.hi.foodbar.services.RestaurantsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

/**
 *
 * @author Karítas Sif Halldórsdóttir
 * @author Brynja Pálína Sigurgeirsdóttir
 * @author Elvar Kjartansson
 * @date nóvember 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest og
 * Mockito til að prófa service klasa
 */

@RunWith(SpringRunner.class)
/**
 *  Aðeins veflagið er keyrt upp en ekki allur "context"-inn
 *  Getum beðið um að keyra bara upp AddRestController klasann
 *  Biðjum um að bæta RestaurantsService inn í "context-inn" sem Mock (prófanahlut)
 */
@WebMvcTest(AddRestController.class)

public class WebMockTest {

    // Þjónninn (Tomcat) ekki keyrður upp
    @Autowired
    private MockMvc mockMvc;

    // Bætum við prófunar (e. Mock) service klasa - kemur úr springframework safninu (fyrir Mockito
    // sérstaklega gert fyrir Mockito safnið
    @MockBean
    RestaurantsService restaurantsService;

    /**
     * Aðferð sem prófar /lifir á AddRestController en með
     * erALifi() false. Ættum að fá til baka indexPage.jsp síðuna
     */
    @Test
    public void testaLifirTrue() throws Exception {
        // Látum erNafnRett() skila true
        // Notum Mockito í prófanirnar - Mockito er Framework fyrir unit testing í Java
        // http://site.mockito.org/

        // Prófið ætti að takast - prófum sönnu leiðina í if-setningunni
        when(restaurantsService.erALifi()).thenReturn(true);
        this.mockMvc.perform(get("/lifir"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(view().name("view/indexPage"));

    }
    /**
     * Aðferð sem prófar /lifir AddRestController en með
     * erALifi() false. Ættum að fá til baka restaurantListPage.jsp síðuna
     */
    @Test
    public void testaLifirFalse() throws Exception {

        // Prófið ætti að takast - prófum ósönnu leiðina í if-setningunni
        when(restaurantsService.erALifi()).thenReturn(false);
        this.mockMvc.perform(get("/lifir")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("view/restaurantListPage"));
    }

    /**
     * Prófið ætti að mistakast - prófum ósönnu leiðina erALifi() en berum
     * saman við rangan streng
     * @throws Exception
     */
    @Test
    public void testaLifirFalseMedRongumStreng() throws Exception {

        // Prófið ætti að ekki takast - prófum ósönnu leiðina í if-setningunni
        when(restaurantsService.erALifi()).thenReturn(false);


        this.mockMvc.perform(get("/lifir")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("view/indexPage"));
    }

}