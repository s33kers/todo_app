package us.martink.todoserver;

import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public DefaultDSLContext dsl() {
        Settings settings = new Settings();
        //reikia, nes liquibase sukuria viska lowercase, o jooq select'uose naudoja kabutes kas yra case sensitive
        settings.setRenderNameStyle(RenderNameStyle.AS_IS);
        //FIXME kreivai atrodo bet veikia
        try {
            return new DefaultDSLContext(jdbcTemplate.getDataSource().getConnection(), SQLDialect.POSTGRES_9_5, settings);
        } catch (SQLException e) {
            return null;
        }
    }
}
