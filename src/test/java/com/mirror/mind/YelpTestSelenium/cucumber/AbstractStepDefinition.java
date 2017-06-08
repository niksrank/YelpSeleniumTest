package com.mirror.mind.YelpTestSelenium.cucumber;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;


import com.mirror.mind.YelpTestSelenium.YelpTestSeleniumApplicationTests;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = {YelpTestSeleniumApplicationTests.class})
@ContextConfiguration
@EnableAsync
@Slf4j
class AbstractStepDefinition {

}
