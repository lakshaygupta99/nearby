package com.nearby.backend.users;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserControllerTest.class, UserRepositoryTest.class, UserServiceTest.class })
public class UserTestSuite {

}
