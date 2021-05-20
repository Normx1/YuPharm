package com.yu_pharm.model.drug;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public interface Drugs<T extends Drug> {

	Drug create();

	List<T> all();


	class Smart implements Drugs<Drug.Smart> {

		private final Drugs<?> drugs;


		public Smart(Drugs<?> drugs) {
			this.drugs = drugs;
		}


		@Override
		public Drug.Smart create() {
			return new Drug.Smart(drugs.create());
		}

		@Override
		public List<Drug.Smart> all() {
			return drugs.all().stream().map(Drug.Smart::new).collect(Collectors.toList());
		}


		public Drug.Smart findById(int id) {
			return all().stream()
					.filter(d -> d.id() == id)
					.findFirst()
					.orElseThrow(() -> new NoSuchElementException("No such drug with id '" + id + "'"));
		}

		public Drug.Smart findByName(String name) {
			return all().stream()
					.filter(d -> d.name().contains(name))
					.findFirst()
					.orElseThrow(() -> new NoSuchElementException("No such drug with name containing '" + name + "'"));
		}
	}
}
