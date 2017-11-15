package is.hi.foodbar.repository;

import is.hi.foodbar.model.Restaurants;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Tenging við gagnagrunninn fyrir veitingastaðina.
 *
 * @author Brynja Pálína Sigurgreisdóttir, bps5@hi.is
 * @author Elvar Kjartansson, elk11@hi.is
 * @date Október 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
public interface RestaurantRepository extends JpaRepository<Restaurants, Long>{

    /**
     * Nær í öll restaurants
     *
     * @return listi af restaurants
     */
    List<Restaurants> findAll();

    /**
     * Bætir við restaurant
     *
     * @param restaurants veitingastaðurinn sem á að bæta í gagnagrunninn
     * @return Veitingastað
     */
    Restaurants save(Restaurants restaurants);

    /**
     * Finnur veitingastað útfrá gefnu id
     *
     * @param id sem á að finna veitingastað með
     * @return listi af veitingastöðum sem passa við id
     */
    List<Restaurants> findById(long id);

    /**
     * Finnur veitingastað útfrá gefnu nafni
     *
     * @param name Strengur sem inniheldur nafnið sem á að finna
     * @return listi af öllum veitingastöðum sem passa við nafnið
     */
    List<Restaurants> findByName(String name);

    /**
     * Finnur alla veitingastaði sem passa við gefið nafn
     *
     * @param name Strengur sem inniheldur nafnið sem á að finna
     * @return listi af öllum veitingastöðum sem passa við nafnið
     */
    List<Restaurants> findAllByName(String name);

    /**
     * Finnur alla veitingastaði þar sem einhver partur af gefnu nafni
     * passar við einhvern part af nafni veitingastaðarins.
     * Tómi strengurinn skilar öllum veitingastöðum.
     * Tekur ekki mark á hástöfum (case insensitive)
     *
     * @param name Strengur sem inniheldur nafnið sem á að finna
     * @return listi af öllum veitingastöðum sem passa einhvernegin við nafnið
     */
    @Query(value = "SELECT r FROM Restaurants r where lower(r.name) LIKE lower(concat('%', :name,'%'))")
    List<Restaurants> findByNameMatch(@Param("name") String name);

    /**
     * Finnur alla veitingastaði þar sem einhver partur af gefnu heimilisfangi
     * passar við einhvern part af heimilisfangi veitingastaðarins.
     * Tómi strengurinn skilar öllum veitingastöðum.
     * Tekur ekki mark á hástöfum (case insensitive)
     *
     * @param address Strengur sem inniheldur heimilisfangið sem á að finna
     * @return listi af öllum veitingastöðum sem passa einhvernegin við heimilisfangið
     */
    @Query(value = "SELECT r FROM Restaurants r where lower(r.address) LIKE lower(concat('%', :address,'%'))")
    List<Restaurants> findByAddress(@Param("address") String address);

    /**
     * Finnur alla veitingastaði þar sem póstnúmerið sem veitingastaðurinn hefur
     * passar við númerið sem leitað er að
     *
     * @param postCode int póstnúmer sem leitað er að
     * @return listi af öllum veitingastöðum þar sem póstnúmerið er það sama
     */
    @Query(value = "SELECT r FROM Restaurants r where r.postCode = :postCode")
    List<Restaurants> findByPostCode(@Param("postCode") int postCode);

    /**
     * Finnur alla veitingastaði þar sem gæðastaðalsnúmerið sem veitingastaðurinn hefur
     * passar við númerið sem leitað er að
     *
     * @param quality int gæðastaðals númer sem er leitað að
     * @return listi af öllum veitingastöðum þar sem gæðastaðalsnúmer er það sama
     */
    @Query(value = "SELECT r FROM Restaurants r where r.quality = :quality")
    List<Restaurants> findByQuality(@Param("quality") int quality);

    /**
     * Finnur alla veitingastaði þar sem einhver partur af gefni tegund
     * passar við einhvern part af tegundum veitingastaðarins.
     * Tómi strengurinn skilar öllum veitingastöðum.
     * Tekur ekki mark á hástöfum (case insensitive)
     *
     * @param type tegundin sem á að finna
     * @return listi af veitingastöðum sem hafa tegund sem passar við það sem leitað var að
     */
    @Query(value = "SELECT r from Restaurants r JOIN r.type t WHERE lower(t.name) LIKE lower(concat('%', :type,'%'))")
    List<Restaurants> findByType(@Param("type") String type);

    /**
     * Finnur alla veitingastaði þar sem einhver partur af gefni matseðilstegund
     * passar við einhvern part af matseðilstegundum veitingastaðarins.
     * Tómi strengurinn skilar öllum veitingastöðum.
     * Tekur ekki mark á hástöfum (case insensitive)
     *
     * @param menuType matseðilstegundin sem á að finna
     * @return listi af veitingastöðum sem hafa matseðilstegund sem passar við það sem leitað var að
     */
    @Query(value = "SELECT r from Restaurants r JOIN r.menuType m WHERE lower(m.name) LIKE lower(concat('%', :menuType,'%'))")
    List<Restaurants> findByMenuType(@Param("menuType") String menuType);
}
