package com.teamfresh.voc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.teamfresh.voc.constant.VocStatus;
import com.teamfresh.voc.constant.VocType;
import com.teamfresh.voc.domain.Carrier;
import com.teamfresh.voc.domain.Customer;
import com.teamfresh.voc.domain.Voc;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class VocRepositoryTest {
	@Autowired
	private VocRepository vocRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CarrierRepository carrierRepository;

	private Customer customer;
	private Carrier carrier;
	private Voc voc;

	private int vocOriginalCount;

	@BeforeEach
	void setUp() {
		vocOriginalCount = vocRepository.findAll().size();

		customer = Customer.builder()
			.company_name("고객사")
			.manager_name("담당자")
			.contact("01011111111")
			.build();
		customerRepository.save(customer);

		carrier = Carrier.builder()
			.carrier_name("운송기사")
			.company_name("운송사")
			.build();
		carrierRepository.save(carrier);

		voc = Voc.builder()
			.contents("test")
			.type(VocType.CUSTOMER)
			.status(VocStatus.PROCEED)
			.customer(customer)
			.carrier(carrier)
			.penalty(null)
			.reparation(null)
			.build();
	}

	@Test
	@DisplayName("VOC 전체 목록 조회")
	@Transactional
	void find_all_voc_list() {
		// given
		int count = 3;
		for (int i = 0; i < count; i++) {
			createVoc(i);
		}

		// when
		List<Voc> vocList = vocRepository.findAll();

		// then
		Assertions.assertEquals(vocOriginalCount + count, vocList.size());
	}

	@Test
	@DisplayName("VOC 저장 테스트")
	@Transactional
	void save_voc() {
		// when
		Voc saveVoc = vocRepository.save(voc);

		// then
		Assertions.assertNotNull(saveVoc);
		Assertions.assertEquals(carrier, saveVoc.getCarrier());
		Assertions.assertEquals(customer, saveVoc.getCustomer());
	}

	private void createVoc(int i) {
		customer = Customer.builder()
			.company_name("고객사" + i)
			.manager_name("담당자" + i)
			.contact("0101111111" + i)
			.build();
		customerRepository.save(customer);

		carrier = Carrier.builder()
			.carrier_name("운송기사" + i)
			.company_name("운송사" + i)
			.build();
		carrierRepository.save(carrier);

		voc = Voc.builder()
			.contents("test" + i)
			.type(VocType.CUSTOMER)
			.status(VocStatus.PROCEED)
			.customer(customer)
			.carrier(carrier)
			.penalty(null)
			.reparation(null)
			.build();
		vocRepository.save(voc);
	}
}