package com.web.app.dao;

import com.web.app.entities.Officer;
import com.web.app.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaOfficerDaoTest {
    @Autowired
    private JpaOfficerDao dao;

    @Autowired
    private JdbcTemplate template;

    private List<Integer> ids() {
        return  template.query("select id from officers",
                (rs, num) -> rs.getInt("id"));
    }
    @Test
    void save() {

        Officer officer = new Officer(null, Rank.ADMIRAL, "John", "Rambo");
        officer = dao.save(officer);
        assertNotNull(officer.id());
    }

    @Test
    void findByIdThatExist() {
        ids().forEach( id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id, officer.get().id());
        });
    }
    @Test
    void findByIdDoesNotExist() {
        Optional<Officer> officer = dao.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    void findAll() {
        List<String> names = dao.findAll().stream().map(x->x.lastName()).toList();
        assertThat(names.contains(List.of("Kirk", "Picard", "Sisko", "Janeway", "Archer", "Pike", "Freeman")));
    }

    @Test
    void delete() {
        ids().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            dao.delete(officer.get());
        });
        assertEquals(0, dao.count());
    }

    @Test
    void existById() {
    }

    @Test
    void count() {
        assertEquals(ids().size(), dao.count());
    }
}