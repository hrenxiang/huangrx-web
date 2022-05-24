package test;

import service.impl.UserSServiceImpl;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/9
 **/
public class UserSServiceImplTest {

    @org.junit.Test
    public void existsUsername() {
        String s="hha";
        UserSServiceImpl userSService=new UserSServiceImpl();
        boolean b = userSService.existsUsername(s);
        System.out.println(b);
    }
}