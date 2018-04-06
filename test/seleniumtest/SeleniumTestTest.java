/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bulld
 */
public class SeleniumTestTest {
    
    public SeleniumTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //SeleniumTest.setup();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws InterruptedException {
        //SeleniumTest.loadstartSite();
        //SeleniumTest.switchScreens();
    }
    
    @After
    public void tearDown() throws Exception {
        //Register("admin41", "password", "Dakota", "Bull", "January", "8", "1998", "GED Degree", "Specialist PTC");//Pass
    }

    /**
     * Test of main method, of class SeleniumTest.
     */
    @Test
    public void testRegPass() throws Exception {
        Register("admin50", "password", "Dakota", "Bull", "January", "8", "1998", "GED Degree", "Specialist PTC");//Fail
    }
    
    @Test
    public void testRegFail() throws Exception {
        Register("admin40", "password", "Dakota", "Bull", "January", "80", "3000", "GED Degree", "Specialist PTC");//Fail
    }
    
    @Test
    public void testLogPass() throws Exception {
        Login("admin40", "password");//pass
    }
    
    @Test
    public void testLogFail() throws Exception {
        Login("admin40", "passwords");//fail
    }
    
    public void Register(String uName, String pass, String fName, String lName, String birthMonth, String birthDay, String birthYear, String edu, String special) throws Exception
    {
        SeleniumTest.setup();
        SeleniumTest.loadstartSite();
        SeleniumTest.switchScreens();
        SeleniumTest.enterRefInfo(uName, pass);
        SeleniumTest.enterDemInfo(fName, lName, birthMonth, birthDay, birthYear, edu, special);
        SeleniumTest.close();
    }
    
    public void Login(String uName, String pass) throws InterruptedException
    {
        SeleniumTest.setup();
        SeleniumTest.loadstartSite();
        SeleniumTest.switchScreens();
        SeleniumTest.enterLoginInfo(uName, pass);
        SeleniumTest.close();
    }
}
