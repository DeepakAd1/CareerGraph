package com.example.NetConnect;

import com.example.NetConnect.Nodes.Person;
import com.example.NetConnect.service.PersonHasSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetConnectApplication.class, args);
	}

}
