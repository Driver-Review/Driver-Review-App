package com.driverreview.cucumber;

import com.driverreview.DriverReviewApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = DriverReviewApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
