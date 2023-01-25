package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public class UczenDAO {

		@Autowired
		private JdbcTemplate jdbcTemplate;

		public UczenDAO(JdbcTemplate t) {
			this.jdbcTemplate = t;
		}

		public List<Uczen> list() {
			String sql = "SELECT * FROM Uczniowie";
			List<Uczen> u = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uczen.class));
			return u;
		}

		/* Insert – wstawianie nowego wiersza do bazy */
		public void save(Uczen sale) {
		}

		/* Read – odczytywanie danych z bazy */
		public Uczen get(int id) {
			return null;
		}

		/* Update – aktualizacja danych */
		public void update(Uczen sale) {
		}

		/* Delete – wybrany rekord z danym id */
		public void delete(int id) {
		}
	}