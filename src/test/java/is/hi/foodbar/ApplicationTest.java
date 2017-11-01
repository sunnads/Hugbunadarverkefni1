package is.hi.foodbar;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
/**
 *
 * @author Karítas Sif Halldórsdóttir
 * @author Brynja Pálína Sigurgeirsdóttir
 * @author Elvar Kjartansson
 * @date nóvember 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem framkvæmir prófanir án þess að þurfa að kalla á þjóninn
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc       // Spring MockMvc - allt "context"-ið keyrt upp
public class ApplicationTest {

    // Þjónninn (Tomcat) ekki keyrður upp
    @Autowired
    private MockMvc mockMvc;

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á /index
     * og fá til baka indexPage.jsp síðuna
     *
     */
    @Test
    public void demoProf() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("view/indexPage"));
    }

}