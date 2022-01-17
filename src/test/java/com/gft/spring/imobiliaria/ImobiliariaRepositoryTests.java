package com.gft.spring.imobiliaria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.entities.Room;
import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.repositories.BusinessRepository;
import com.gft.spring.imobiliaria.repositories.CategoryRepository;
import com.gft.spring.imobiliaria.repositories.DistrictRepository;
import com.gft.spring.imobiliaria.repositories.MunicipalityRepository;
import com.gft.spring.imobiliaria.repositories.RoomRepository;
import com.gft.spring.imobiliaria.repositories.StateRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ImobiliariaRepositoryTests {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private StateRepository staterepository;
	
	@Autowired
	private BusinessRepository businessrepository;
	
	@Autowired
	private RoomRepository roomrepository;
	
	@Autowired
	private DistrictRepository districtrepository;
	
	@Autowired
	private MunicipalityRepository municipalityrepository;
	
	@Test
	public void roomrepository() {
		
		Category cat0 = repository.save(new Category("Casa"));
		assertThat(cat0.getId()).isGreaterThan(0);
		
		Category cat1 = repository.save(new Category("Apartamento"));
		assertThat(cat1.getId()).isGreaterThan(0);
		
		Category cat2 = repository.save(new Category("Chácara"));
		assertThat(cat2.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateBusiness() {
		
		Business business0 = businessrepository.save(new Business("Alugel"));
		assertThat(business0.getId()).isGreaterThan(0);
		
		Business business1 = businessrepository.save(new Business("Compra"));
		assertThat(business1.getId()).isGreaterThan(0);
		
		Business business2 = businessrepository.save(new Business("Venda"));
		assertThat(business2.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateRoom() {
		
		Room room0 = roomrepository.save(new Room("1"));
		assertThat(room0.getId()).isGreaterThan(0);
		
		Room room1 = roomrepository.save(new Room("2"));
		assertThat(room1.getId()).isGreaterThan(0);
		
		Room room2 = roomrepository.save(new Room("3"));
		assertThat(room2.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateMunicipality() {
		
		Municipality municipality0 = municipalityrepository.save(new Municipality("Mooca"));
		assertThat(municipality0.getId()).isGreaterThan(0);
		
		Municipality municipality1 = municipalityrepository.save(new Municipality("Interlagos"));
		assertThat(municipality1.getId()).isGreaterThan(0);
		
		Municipality municipality2 = municipalityrepository.save(new Municipality("Brooklin"));
		assertThat(municipality2.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateDistrict() {
		
		District district0 = districtrepository.save(new District("Mooca"));
		assertThat(district0.getId()).isGreaterThan(0);
		
		District district1 = districtrepository.save(new District("Interlagos"));
		assertThat(district1.getId()).isGreaterThan(0);
		
		District district2 = districtrepository.save(new District("Brooklin"));
		assertThat(district2.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateState() {
		
		State state0 = staterepository.save(new State("Acre"));
		assertThat(state0.getId()).isGreaterThan(0);
		
		State state1 = staterepository.save(new State("Alagoas"));
		assertThat(state1.getId()).isGreaterThan(0);
		
		State state2 = staterepository.save(new State("Amapá"));
		assertThat(state2.getId()).isGreaterThan(0);
		
		State state3 = staterepository.save(new State("Amazonas"));
		assertThat(state3.getId()).isGreaterThan(0);

		State state4 = staterepository.save(new State("Bahia"));
		assertThat(state4.getId()).isGreaterThan(0);

		State state5 = staterepository.save(new State("Ceará"));
		assertThat(state5.getId()).isGreaterThan(0);

		State state6 = staterepository.save(new State("Distrito Federal"));
		assertThat(state6.getId()).isGreaterThan(0);

		State state7 = staterepository.save(new State("Espírito Santo"));
		assertThat(state7.getId()).isGreaterThan(0);
		
		State state8 = staterepository.save(new State("Goiás"));
		assertThat(state8.getId()).isGreaterThan(0);
		
		State state9 = staterepository.save(new State("Maranhão"));
		assertThat(state9.getId()).isGreaterThan(0);
		
		State state10 = staterepository.save(new State("Mato Grosso"));
		assertThat(state10.getId()).isGreaterThan(0);
		
		State state11 = staterepository.save(new State("Mato Grosso do sul"));
		assertThat(state11.getId()).isGreaterThan(0);
		
		State state12 = staterepository.save(new State("Minas Gerais"));
		assertThat(state12.getId()).isGreaterThan(0);
		
		State state13 = staterepository.save(new State("Pará"));
		assertThat(state13.getId()).isGreaterThan(0);
		
		State state14 = staterepository.save(new State("Paraíba"));
		assertThat(state14.getId()).isGreaterThan(0);
		
		State state15 = staterepository.save(new State("Paraná"));
		assertThat(state15.getId()).isGreaterThan(0);

		State state16 = staterepository.save(new State("Pernambuco"));
		assertThat(state16.getId()).isGreaterThan(0);
		
		State state17 = staterepository.save(new State("Piauí"));
		assertThat(state17.getId()).isGreaterThan(0);
		
		State state18 = staterepository.save(new State("Rio de Janeiro"));
		assertThat(state18.getId()).isGreaterThan(0);
		
		State state19 = staterepository.save(new State("Rio Grande do Norte"));
		assertThat(state19.getId()).isGreaterThan(0);
		
		State state20 = staterepository.save(new State("Rio Grande do Sul"));
		assertThat(state20.getId()).isGreaterThan(0);
		
		State state21 = staterepository.save(new State("Rondônia"));
		assertThat(state21.getId()).isGreaterThan(0);
		
		State state22 = staterepository.save(new State("Roraima"));
		assertThat(state22.getId()).isGreaterThan(0);
		
		State state23 = staterepository.save(new State("Santa Catarina"));
		assertThat(state23.getId()).isGreaterThan(0);
		
		State state24 = staterepository.save(new State("São Paulo"));
		assertThat(state24.getId()).isGreaterThan(0);
		
		State state25 = staterepository.save(new State("Sergipe"));
		assertThat(state25.getId()).isGreaterThan(0);
		
		State state26 = staterepository.save(new State("Tocantins"));
		assertThat(state26.getId()).isGreaterThan(0);
		
	}
	
}
