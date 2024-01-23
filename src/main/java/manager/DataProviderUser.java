package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");//[test.anna.book@gmail.com][SAMASAMa2023@]
            list.add(new Object[]{
                    new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine(); //sonya@gmail.com,Ss12345$
        }


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> wrongEmailFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongemailtest.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");//[test.anna.book@gmail.com][SAMASAMa2023@]
            list.add(new Object[]{
                    new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine(); //sonya@gmail.com,Ss12345$
        }


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginWrongPasswordFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/WrongPasswordTest.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");//[test.anna.book@gmail.com][SAMASAMa2023@]
            list.add(new Object[]{
                    new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine(); //sonya@gmail.com,Ss12345$
        }


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> WrongUnregisteredUserFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongUnregisteredUserTest.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");//[test.anna.book@gmail.com][SAMASAMa2023@]
            list.add(new Object[]{
                    new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();//sonya@gmail.com,Ss12345$
        }


        return list.iterator();
    }


}
