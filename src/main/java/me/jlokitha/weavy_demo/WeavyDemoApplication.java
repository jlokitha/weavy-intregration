package me.jlokitha.weavy_demo;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeavyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeavyDemoApplication.class, args);
	}

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder()
				.build();
	}
}
