package com.skyworx.shop;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:testContext.xml")
public  abstract class BaseTransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {
}
