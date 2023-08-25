package hu.demo.junior.jpa.repository;

import hu.demo.junior.jpa.model.Mobilapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilAppRepository extends JpaRepository<Mobilapp, Long> {
}
