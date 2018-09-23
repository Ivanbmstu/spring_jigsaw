package com.example.client;


import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import ru.lanwen.wiremock.config.WiremockConfigFactory;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class StaticPortWireMockConfigFactory implements WiremockConfigFactory {

    private static final int PORT_NUMBER = 8888;

    @Override
    public WireMockConfiguration create() {
        return options().port(PORT_NUMBER).notifier(new Slf4jNotifier(true));
    }
}
