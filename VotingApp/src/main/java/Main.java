import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {

		
		
		Session session = connectDB();
		AppFrame appFrame = new AppFrame();
		LogView logView = new LogView(appFrame, session);

		Query query = session.createQuery("from Voters");

		List<Voters> zipCodesList = query.list();
		for (Voters z : zipCodesList) {
			System.out.println(+z.getId() + "," + z.getPesel());
		}

//		disconnectDB();

	}

	private static void disconnectDB() {
		HibernateConnection.shutdown();

	}

	private static Session connectDB() {
		Session session = HibernateConnection.getSessionFactory().openSession();

		session.beginTransaction();
		return session;

	}

}
