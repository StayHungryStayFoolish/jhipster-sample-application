package io.github.jhipster.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.LocalTime;

/**
 * Properties specific to Jhipster Sample Application.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private Matching matching;

    private Attendance attendance;

    public Matching getMatching() {
        return matching;
    }

    public void setMatching(Matching matching) {
        this.matching = matching;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public static class Matching {

        private Datasource datasource;

        public static class Datasource {
            private String type;
            private String url;
            private String username;
            private String password;
            private String driverClassName;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getDriverClassName() {
                return driverClassName;
            }

            public void setDriverClassName(String driverClassName) {
                this.driverClassName = driverClassName;
            }
        }

        public Datasource getDatasource() {
            return datasource;
        }

        public void setDatasource(Datasource datasource) {
            this.datasource = datasource;
        }
    }

    public static class Attendance {

        private Rule rule;

        public Rule getRule() {
            return rule;
        }

        public void setRule(Rule rule) {
            this.rule = rule;
        }

        public static class Rule {
            private LocalTime onDuty;
            private LocalTime offDuty;

            public LocalTime getOnDuty() {
                return onDuty;
            }

            public void setOnDuty(LocalTime onDuty) {
                this.onDuty = onDuty;
            }

            public LocalTime getOffDuty() {
                return offDuty;
            }

            public void setOffDuty(LocalTime offDuty) {
                this.offDuty = offDuty;
            }
        }
    }
}
