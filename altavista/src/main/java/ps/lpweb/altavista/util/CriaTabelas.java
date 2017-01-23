package ps.lpweb.altavista.util;

import javax.persistence.Persistence;

public class CriaTabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("altavista");

	}

}
