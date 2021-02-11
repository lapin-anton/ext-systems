package ru.java_project.ext.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.java_project.ext.domain.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT st FROM Student st WHERE " +
        "st.firstName = :firstName AND " +
        "st.lastName = :lastName AND " +
        "st.middleName = :middleName AND " +
        "st.dateOfBirth = :dateOfBirth AND " +
        "st.passportSeria = :passportSeria AND " +
        "st.passportNumber = :passportNumber AND " +
        "st.passportDate = :passportDate"
    )
    List<Student> findStudent(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("dateOfBirth") LocalDate dateOfBirth,
            @Param("passportSeria") String passportSeria,
            @Param("passportNumber") String passportNumber,
            @Param("passportDate") LocalDate passportDate
    );
}
