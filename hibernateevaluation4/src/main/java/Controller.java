import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Controller {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice ;

        do{
            System.out.println("1. Insert ");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. query1");
            System.out.println("6. query2");
            System.out.println("7. query3");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1:
                    Dao.insert();
                    // Code for option 1
                    break;
                case 2:
                    Dao.update();
                    break;
                case 3:
                    Dao.delete();
                    break;
                case 4:
                    Dao.display();
                    break;
                case 5:
                    Dao.publisher();
                    break;
                case 6:
                    Dao.nirali();
                    break;
                case 7:
                    Dao.author();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        }while(choice!=0);
    }
}
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 4
//Apr 21, 2023 1:23:21 PM org.hibernate.Version logVersion
//INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
//Apr 21, 2023 1:23:21 PM org.hibernate.boot.jaxb.internal.stax.LocalXmlResourceResolver resolveEntity
//WARN: HHH90000012: Recognized obsolete hibernate namespace http://hibernate.sourceforge.net/hibernate-configuration. Use namespace http://www.hibernate.org/dtd/hibernate-configuration instead.  Support for obsolete DTD/XSD namespaces may be removed at any time.
//Apr 21, 2023 1:23:22 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
//INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
//Apr 21, 2023 1:23:22 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
//Apr 21, 2023 1:23:22 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/Hibernate_evaluation_Demo_4?createDatabaseIfNotExist=true]
//Apr 21, 2023 1:23:22 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//INFO: HHH10001001: Connection properties: {user=root, password=****}
//Apr 21, 2023 1:23:22 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//INFO: HHH10001003: Autocommit mode: false
//Apr 21, 2023 1:23:22 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//Apr 21, 2023 1:23:23 PM org.hibernate.dialect.Dialect <init>
//INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
//Apr 21, 2023 1:23:25 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@e344ad3] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//Hibernate: alter table Book add constraint FK5gbo4o7yxefxivwuqjichc67t foreign key (author_id) references Author (id)
//Hibernate: alter table Publication add constraint FK11p3uphjf9nf0ribsoj1krbqq foreign key (book_id) references Book (id)
//Apr 21, 2023 1:23:25 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//Hibernate: select publicatio0_.id as id1_2_, publicatio0_.book_id as book_id3_2_, publicatio0_.name as name2_2_ from Publication publicatio0_
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Publication{id=1, name='nirali', book=Book{id=1, name='physics', price=500, date=2020-01-10, author=Author{id=1, name='aarti'}}}
//Publication{id=2, name='nirali', book=Book{id=2, name='chemistry', price=700, date=2020-10-29, author=Author{id=2, name='aniketi'}}}
//Publication{id=3, name='arihant', book=Book{id=3, name='math', price=400, date=2023-01-01, author=Author{id=2, name='aniketi'}}}
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 2
//enter 1 for author update
// enter 2 for book update
//enter 3 for publication update
//2
//Enter the id to be update
//2
//750
//enter new price book
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Hibernate: update Book set author_id=?, date=?, name=?, price=? where id=?
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 4
//Hibernate: select publicatio0_.id as id1_2_, publicatio0_.book_id as book_id3_2_, publicatio0_.name as name2_2_ from Publication publicatio0_
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Publication{id=1, name='nirali', book=Book{id=1, name='physics', price=500, date=2020-01-10, author=Author{id=1, name='aarti'}}}
//Publication{id=2, name='nirali', book=Book{id=2, name='chemistry', price=750, date=2020-10-29, author=Author{id=2, name='aniketi'}}}
//Publication{id=3, name='arihant', book=Book{id=3, name='math', price=400, date=2023-01-01, author=Author{id=2, name='aniketi'}}}
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 5
//Hibernate: select book0_.id as id1_1_, book0_.author_id as author_i5_1_, book0_.date as date2_1_, book0_.name as name3_1_, book0_.price as price4_1_ from Book book0_ where book0_.date>='2021-01-01'
//Hibernate: select author0_.id as id1_0_0_, author0_.name as name2_0_0_, booklist1_.author_id as author_i5_1_1_, booklist1_.id as id1_1_1_, booklist1_.id as id1_1_2_, booklist1_.author_id as author_i5_1_2_, booklist1_.date as date2_1_2_, booklist1_.name as name3_1_2_, booklist1_.price as price4_1_2_, publicatio2_.id as id1_2_3_, publicatio2_.book_id as book_id3_2_3_, publicatio2_.name as name2_2_3_ from Author author0_ left outer join Book booklist1_ on author0_.id=booklist1_.author_id left outer join Publication publicatio2_ on booklist1_.id=publicatio2_.book_id where author0_.id=?
//aniketi
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 6
//Hibernate: select publicatio0_.id as id1_2_, publicatio0_.book_id as book_id3_2_, publicatio0_.name as name2_2_ from Publication publicatio0_ where publicatio0_.name='nirali'
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select book0_.id as id1_1_0_, book0_.author_id as author_i5_1_0_, book0_.date as date2_1_0_, book0_.name as name3_1_0_, book0_.price as price4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.book_id as book_id3_2_2_, publicatio2_.name as name2_2_2_ from Book book0_ left outer join Author author1_ on book0_.author_id=author1_.id left outer join Publication publicatio2_ on book0_.id=publicatio2_.book_id where book0_.id=?
//Hibernate: select publicatio0_.id as id1_2_2_, publicatio0_.book_id as book_id3_2_2_, publicatio0_.name as name2_2_2_, book1_.id as id1_1_0_, book1_.author_id as author_i5_1_0_, book1_.date as date2_1_0_, book1_.name as name3_1_0_, book1_.price as price4_1_0_, author2_.id as id1_0_1_, author2_.name as name2_0_1_ from Publication publicatio0_ left outer join Book book1_ on publicatio0_.book_id=book1_.id left outer join Author author2_ on book1_.author_id=author2_.id where publicatio0_.book_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//chemistry
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 7
//Hibernate: select author0_.id as id1_0_, author0_.name as name2_0_ from Author author0_ where author0_.name like 'a%i'
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Hibernate: select booklist0_.author_id as author_i5_1_0_, booklist0_.id as id1_1_0_, booklist0_.id as id1_1_1_, booklist0_.author_id as author_i5_1_1_, booklist0_.date as date2_1_1_, booklist0_.name as name3_1_1_, booklist0_.price as price4_1_1_, publicatio1_.id as id1_2_2_, publicatio1_.book_id as book_id3_2_2_, publicatio1_.name as name2_2_2_ from Book booklist0_ left outer join Publication publicatio1_ on booklist0_.id=publicatio1_.book_id where booklist0_.author_id=?
//Author{id=1, name='aarti'}
//Author{id=2, name='aniketi'}
//
//1. Insert
//2. Update
//3. Delete
//4. Display
//5. query1
//6. query2
//7. query3
//0. Exit
//Enter your choice: 0
//Exiting program...
//
//
//Process finished with exit code 0