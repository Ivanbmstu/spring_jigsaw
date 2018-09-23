package com.example.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.lanwen.wiremock.ext.WiremockResolver;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith({SpringExtension.class, WiremockResolver.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "remote.port=8888")
public class ClientApplicationTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    private void prepareStub(WireMockServer server) {
        server.stubFor(get("/call?id=1").withQueryParam("id", new EqualToPattern("1"))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody("{\"body\":\"processed with id 1\",\"serviceId\":\"remote\"}")));

        server.stubFor(get("/call/xml?id=1").withQueryParam("id", new EqualToPattern("1"))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><remoteDTO><body>" +
                                "processed with id 1</body><serviceId>remote</serviceId></remoteDTO>")));
    }

    @Test
    void jsonResult(@WiremockResolver.Wiremock(factory = StaticPortWireMockConfigFactory.class) WireMockServer server) throws Exception {
        prepareStub(server);

        ResultActions actions = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/do-work")
                .param("id", "1"));
        actions.andExpect(content().json("{\"result\":\"processed with id 1 processed with id 1\"}"))
                .andDo(print());
    }

    @Test
    void xmlResult(@WiremockResolver.Wiremock(factory = StaticPortWireMockConfigFactory.class) WireMockServer server) throws Exception {
        prepareStub(server);

        ResultActions actions = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/do-work-xml")
                .param("id", "1"));
        actions.andExpect(content().string("<?xml version=\"1.0\" encoding=\"UTF-8\" " +
                "standalone=\"yes\"?><responseDTO><result>processed with id 1 processed with id 1</result></responseDTO>"))
                .andDo(print());
    }

}
