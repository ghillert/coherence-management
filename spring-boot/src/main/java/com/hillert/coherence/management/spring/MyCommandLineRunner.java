/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hillert.coherence.management.spring;

import com.oracle.coherence.spring.configuration.annotation.CoherenceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Gunnar Hillert
 */
@Component
@Profile("!test")
public class MyCommandLineRunner implements CommandLineRunner {

	@CoherenceMap
	private Map<String, String> fooMap;

	@Override
	public void run(String... args) throws Exception {

		this.fooMap.put("foo", "bar");

		System.out.print("Press q to quit> ");
		Scanner userInput = new Scanner(System.in);

		boolean keyPressed = false;

		while (!keyPressed) {
			String enteredByUser = userInput.next();

			if (enteredByUser.equals("q")) {
				keyPressed = true;
			}
		}

		System.out.println("Bye!");
	}
}
