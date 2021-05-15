package com.yu_pharm.model.drug;

import com.yu_pharm.model.Data;

public interface Drug extends Data {

	int id();

	void delete();


	class Smart implements Drug {

		private final Drug obj;


		public Smart(Drug obj) {
			this.obj = obj;
		}


		@Override
		public int id() {
			return obj.id();
		}

		public String name() {
			return get("name", String.class);
		}

		public String description() {
			return get("description", String.class);
		}

		public boolean recipeRequired() {
			return get("recipeRequired", boolean.class);
		}

		public double price() {
			return get("price", double.class);
		}

		@Override
		public void delete() {
			obj.delete();
		}

		@Override
		public <T> T get(String key, Class<T> type) {
			return obj.get(key, type);
		}

		@Override
		public <T> void set(String key, T value) {
			obj.set(key, value);
		}
	}
}
