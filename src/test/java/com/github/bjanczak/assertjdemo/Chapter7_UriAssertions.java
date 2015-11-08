package com.github.bjanczak.assertjdemo;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bartłomiej Jańczak
 */
public class Chapter7_UriAssertions {

    @Test
    public void testUriAssertions() throws URISyntaxException {
        assertThat(new URI("http://assertj.org:8080/news.html#print"))
                .hasHost("assertj.org")
                .hasPort(8080)
                .hasPath("/news.html")
                .hasFragment("print");

        assertThat(new URI("http://assertj.org")).hasNoFragment()
                .hasNoPort()
                .hasPath("")
                .hasNoQuery()
                .hasNoUserInfo();

        assertThat(new URI("mailto:java-net@java.sun.com"))
                .hasNoPath();
    }

    @Test
    public void testUrlAssertions() throws MalformedURLException {
        assertThat(new URL("http://assertj.org:8080/news.html#print")).hasHost("assertj.org")
                .hasPort(8080)
                .hasPath("/news.html")
                .hasAnchor("print");

        assertThat(new URL("http://assertj.org")).hasNoAnchor()
                .hasNoPath()
                .hasNoPort()
                .hasNoQuery()
                .hasNoUserInfo();
    }
}
