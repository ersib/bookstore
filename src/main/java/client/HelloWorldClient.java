package client;

import entity.Address;
import entity.Author;
import entity.Award;
import entity.Book;
import entity.Chapter;
import entity.CustomerCard;
import entity.Publisher;
import entity.User;
import entity.compositekeys.ChapterId;
import entity.enums.BookCategory;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;
import entity.Message;

import java.util.Collection;
import java.util.Collections;

public class HelloWorldClient {
	public static void main(String[] args) {

		//createUpdateMessages();
		//createUpdateUsers();
		//createUpdateBooks();


		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();

		try {

			tx.begin();

			//createNewUser(session, "Ben Linus");

//			User user = session.get(User.class, 52);
//			if (user != null) {
//				System.out.println(user.getName());
//				System.out.println(user.getCard());
//			}

			//addTwoNewBooks(session);

			//addNewAuthorToExistingBoook(session);

			//addNewBook(session, "The Partner", "9788804454120", "John Grisham", session.get(Publisher.class, "MND"));

//			Author john = session.get(Author.class, 102);
//			john.getNickNames().add("Josh");
//			john.getNickNames().add("Grish");
//			session.save(john);


//			Publisher publisher = new Publisher("OREI", "O'Reilly Media, Inc.");
//			Book book = new Book("983724993482", "Just Hibernate", publisher);
//			Chapter firstChapter = new Chapter(1, "Basics", book);
//			Chapter secondChapter = new Chapter(2, "Advanced", book);
//			book.addChapter(firstChapter);
//			book.addChapter(secondChapter);
//			session.persist(book);

			Author author = new Author("Charles Dickens");
			author.setNickNames(Collections.singletonList("Charley"));
			author.setAward(new Award("Golden letter", 1878, "AIA"));
			session.persist(author);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			if (tx!=null)
				tx.rollback();
		} finally {
			if (session!=null)
				session.close();
		}
	}

	private static void createNewUser(Session session, String name) {
		CustomerCard card = new CustomerCard();
		User user = new User();
		user.setName(name);
		user.setCard(card);
		session.persist(user);
		System.out.println("user persisted " + user.getId());
	}

	private static void addTwoNewBooks(Session session) {
		Author author1 = new Author("Ken Arnold");
		Author author2 = new Author("James Gosling");

		Publisher pb1 = new Publisher("ADW", "Addison-Wesley Professional");

		Book book1 = new Book("0321349806", "The Java Programming Language", pb1);
		book1.getAuthors().add(author1);
		book1.getAuthors().add(author2);

		Book book2 = new Book("013390069X", "Java Language Specification", pb1);
		book2.getAuthors().add(author2);

		session.persist(book1);
		session.persist(book2);
	}

	private static void addNewBook(Session session, String title, String isbn, String author, Publisher pb) {

		Book book1 = new Book(isbn, title, pb);
		book1.setCategory(BookCategory.CLASSICS);
		book1.getAuthors().add(session.get(Author.class, 102));
		session.persist(book1);

	}

	private static void addNewAuthorToExistingBoook(Session session) {
		Book book2 = session.get(Book.class, "013390069X");
		Author author3 = new Author("Alex Buckley");
		session.persist(author3);
		author3.addBook(book2);
	}

	private static void createUpdateMessages() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();

			//Message message = new Message( "Log4j in Action");
			//session.save(message);

			Message message = (Message) session.get(Message.class, 2L);
			System.out.println(message);
			//message.setText("Hello World!");
			//System.out.println(message);

			tx.commit(); // only after this line being executed, the database message row is actually updated with the new text value
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		} finally {
			if (session!=null)
				session.close();
		}
	}

	private static void createUpdateUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();
			Address address = new Address("100 E Main St.", "Seattle", "87121");
			User user = new User("Jack", address);

			session.save(user);

			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (tx!=null)
				tx.rollback();
		} finally {
			if (session!=null)
				session.close();
		}
	}

	private static void createUpdateBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();
			Publisher publisher = new Publisher("PBL_WRDW", "Wordsworth Classics");
			Book book = new Book("185326041X", "The Great Gatsby", publisher);

			session.save(publisher);
			session.save(book);

			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (tx!=null)
				tx.rollback();
		} finally {
			if (session!=null)
				session.close();
		}
	}

}

