open module front.module {
    requires static lombok;
    requires spring.boot.autoconfigure;
    requires spring.cloud.openfeign.core;
    requires spring.boot;
    requires spring.web;
    requires spring.core;
    requires spring.beans;
    requires reactor.core;
    requires spring.webflux;
    requires spring.context;
    requires java.sql;
    requires java.validation;
    requires spring.cloud.netflix.eureka.client;
}