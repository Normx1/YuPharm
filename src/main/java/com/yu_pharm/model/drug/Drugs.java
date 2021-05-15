package com.yu_pharm.model.drug;

import java.util.List;
import java.util.stream.Collectors;

public interface Drugs<T extends Drug>  {

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
	}
}
