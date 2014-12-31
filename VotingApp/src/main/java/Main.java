import org.hibernate.Session;


public class Main {

	public static void main(String[] args) {
		
		Session session=connectDB();
		
		AppFrame appFrame = new AppFrame();
		LogView logView = new LogView(appFrame);

		
		disconnectDB();
		
	}

	private static void disconnectDB() {
		HibernateConnection.shutdown();
		
	}

	private static Session connectDB() {
		Session session = HibernateConnection.getSessionFactory()
				.openSession();

		session.beginTransaction();
		return session;

	}

}
