package com.devbackend.teste.problema01.repository;

import com.devbackend.teste.problema01.model.M_Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Ticket extends JpaRepository<M_Ticket, Long> {
    @Query(value = "select * from teste.ticket\n" +
            "where \n" +
            "EXTRACT(MONTH FROM data_abertura) = cast(:mes as numeric) and EXTRACT(YEAR FROM data_abertura) = cast(:ano as numeric)\n" +
            "or\n" +
            "EXTRACT(MONTH FROM data_encerramento) = cast(:mes as numeric) and EXTRACT(YEAR FROM data_encerramento) = cast(:ano as numeric) order by data_abertura asc;", nativeQuery = true)
    List<M_Ticket> findAllTicketsFromMonthAndYear(@Param("mes") String mes, @Param("ano") String ano);
}
