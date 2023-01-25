package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

    static class UczenDAOTest {

        private UczenDAO dao;

        @BeforeEach
        void setUp() throws Exception {
            DriverManagerDataSource datasource = new DriverManagerDataSource();
            datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
            datasource.setUsername("BADAGRA15");
            datasource.setPassword("BADAGRA15");
            datasource.setDriverClassName("oracle.jdbc.OracleDriver");

            /*Import jdbTemplate */
            dao = new UczenDAO(new JdbcTemplate(datasource));
        }

        @Test
        void testList() {
            /* Import java.util */
            List<Uczen> listUczen = dao.list();

            assertTrue(listUczen.isEmpty());
        }

        @Test
        void testSave() {
            fail("Not yet implemented");
        }

        @Test
        void testGet() {
            fail("Not yet implemented");
        }

        @Test
        void testUpdate() {
            fail("Not yet implemented");
        }

        @Test
        void testDelete() {
            fail("Not yet implemented");
        }
    }
}
