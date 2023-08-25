package hu.demo.junior.jpa.repository;


import hu.demo.junior.jpa.dto.OrderResponse;
import hu.demo.junior.jpa.model.Cuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Cuser, Long> {


    @Query("SELECT new hu.demo.junior.jpa.dto.OrderResponse(u.firstName , M.Name) FROM Cuser u JOIN u.mobilapps M")
    public List<OrderResponse> getJoinInformation();

    Optional<Cuser> findByUsername(String username);
}
