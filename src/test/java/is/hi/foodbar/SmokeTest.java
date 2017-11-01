package is.hi.foodbar;

import is.hi.foodbar.controller.SearchController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author Karítas Sif Halldórsdóttir
 * @author Brynja Pálína Sigurgeirsdóttir
 * @author Elvar Kjartansson, elk11@hi.is
 * @date nóvember 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem athugar hvort SearchController keyrir
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    SearchController searchController;

    /**
     * Aðferð til að athuga hvort SearchController hlutur hefur verið búinn til
     */

    @Test
    public void contextLoads() {

        assertThat(searchController).isNotNull();
    }

}