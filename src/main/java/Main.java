
import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws  Exception {


        Scanner sc = new Scanner(System.in);

        // Step 1 : Load and register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2 : Estiblish the connection with database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","Rangari@87mysql98");

        // Step 3 : Create a Statement object
        Statement  st = con.createStatement();
      boolean flag = true ;
        while(flag ){
            System.out.println("Enter the choice ");
            System.out.println(" 1. View the Scoreboard ");
            System.out.println(" 2. Insert  ");
            System.out.println(" 3. Update ");
            System.out.println(" 4 . Delete ");
            System.out.println(" 5 . Exit" );

            int choice = sc.nextInt();

            switch (choice){
                // View the Scoreboard
                case 1 :
                    String sql = "select * from scoreboard ;";
                    ResultSet rs = st.executeQuery(sql);
                    System.out.println("--------------------------------------------------------");
                    System.out.println(" ID  " + " NAME " + " RUNS " + " BALLS ");
                    while (rs.next()){
                        System.out.println(rs.getInt(1) +" \t " +
                                rs.getString(2) +" \t " +
                                rs.getInt(3)+" \t " +
                                rs.getInt(4) + " \t " );

                    }
                    System.out.println("--------------------------------------------------------");
                    break;
                case 2 :
                    System.out.println("Id : ");
                    int id = sc.nextInt();
                    System.out.println("NAME : ");

                    String name = sc.next();

                    System.out.println("RUNS : ");
                    int runs = sc.nextInt();

                    System.out.println("BALLS : ");
                    int balls = sc.nextInt();


                    String sqlInsert = "insert into scoreboard values ("+id+",'"+name+"' , "+runs+" , "+balls+");";
                    int rows = st.executeUpdate(sqlInsert);

                    System.out.println(rows + " Record Inserted ");
                    System.out.println("--------------------------------------------------------");
                    break;
                case 3  :
                    int ch ;
                    System.out.println("Which id you want to update ");
                    int uIdUpdate  = sc.nextInt();
                    System.out.println("What you want to update ");
                    System.out.println("2 . name");
                    System.out.println("3 . runs" );
                    System.out.println("4 . balls");
                    ch = sc.nextInt();
                    String q ;
                    switch (ch){
                        case 2 :
                            System.out.println("Enter new NAME : ");
                            String newName = sc.next();
                             q ="update scoreboard set name='"+newName+"'where id="+uIdUpdate+" ;";
                            int  resultUpdateName = st.executeUpdate(q);
                            System.out.println(resultUpdateName + "Record Updated " );
                            System.out.println("--------------------------------------------------------");
                            break;
                        case 3 :
                            System.out.println("Enter new RUNS : ");
                            int newRuns = sc.nextInt();
                            q ="update scoreboard set runs='"+newRuns+"'where id="+uIdUpdate+" ;";
                            int  resultUpdateRuns = st.executeUpdate(q);
                            System.out.println(resultUpdateRuns + "Record Updated "  );
                            System.out.println("--------------------------------------------------------");
                            break;
                        case 4 :
                            System.out.println("Enter new BALLS : ");
                            int newBalls = sc.nextInt();
                            q ="update scoreboard set balls='"+newBalls+"'where id="+uIdUpdate+" ;";
                            int  resultUpdateBalls = st.executeUpdate(q);
                            System.out.println(resultUpdateBalls  + "Record Updated "  );
                            System.out.println("--------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid Input ");
                    }


                    break;
                case 4 :
                    System.out.println("Which id you want to delete ");
                    int uIdDelete = sc.nextInt();

                    String deleteName = "select name from scoreboard where id="+uIdDelete+";";
                    ResultSet rsdelete = st.executeQuery(deleteName);
                    while (rsdelete.next()){
                        System.out.println( " Record Deleted of "+rsdelete.getString(1)+" ");

                    }


                    String sqlDelete = "delete from scoreboard where id= "+uIdDelete+";";
                    int resultDelete = st.executeUpdate(sqlDelete);

                    System.out.println("--------------------------------------------------------");
                    break;
                case 5  :
                    System.out.println("Pending ");
                    break;
                default:
                    flag = false;
                    break;

            }
        }
    }
}
