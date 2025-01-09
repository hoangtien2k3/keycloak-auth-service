package com.hoangtien2k3.notificationsend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class,
		DataSourceTransactionManagerAutoConfiguration::class,
		HibernateJpaAutoConfiguration::class,
		SecurityAutoConfiguration::class
    ]
)
@ComponentScan(basePackages = ["com.ezbuy", "com.reactify"])
@EnableScheduling
class NotificationSendApplication

fun main(args: Array<String>) {
    runApplication<com.hoangtien2k3.notificationsend.NotificationSendApplication>(*args)
}
