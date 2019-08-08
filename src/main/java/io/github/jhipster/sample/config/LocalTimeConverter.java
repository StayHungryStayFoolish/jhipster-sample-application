package io.github.jhipster.sample.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@ConfigurationPropertiesBinding
public class LocalTimeConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String timestamp) {
        return LocalTime.parse(timestamp);
    }
}
