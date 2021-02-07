package ru.java_project.ext.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.java_project.ext.domain.MarriageCertificate;

@Repository
public interface MarriageDao extends JpaRepository<MarriageCertificate, Long> {

}
