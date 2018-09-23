open module client.main {
    requires static lombok; // static - required at compile, do not required at runtime
    
    requires spring.context;
    requires java.xml.bind; // jaxb api
    requires com.sun.xml.bind; // jaxb runtime impl
    
//    requires slf4j.api;

    requires java.desktop; // required by lombok...
}