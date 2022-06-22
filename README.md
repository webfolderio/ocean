# ocean

unofficial DigitalOcean API Java Client

Supported Java Versions
-----------------------

Oracle & OpenJDK Java 11.

Both the JRE and the JDK are suitable for use with this library.

Integration with Maven
----------------------

To use the official release of ocean, please use the following snippet in your `pom.xml` file.

Add the following to your POM's `<dependencies>` tag:

```xml
<dependency>
    <groupId>io.webfolder</groupId>
    <artifactId>ocean</artifactId>
    <version>1.1.0</version>
</dependency>
```

Usage Examples
--------------
```java
public class OceanTest {
    private static ApiClient client;
    private static String DIGITALOCEAN_AUTH_TOKEN = getenv("OCEAN_TOKEN");
    private static String AUTH_HEADER = format("Bearer %s", DIGITALOCEAN_AUTH_TOKEN);

    @BeforeClass
    public static void before() {
        client = new ApiClient();
        client.setRequestInterceptor(t -> t.header("Authorization", AUTH_HEADER));
    }

    @Test
    public void testFirwall() {
        FirewallsApi api = new FirewallsApi(client);
        ListDropletFirewallsResponse firewall = api.listFirewalls(null, null);
        assertNotNull(firewall);
        assertFalse(firewall.getFirewalls().isEmpty());
    }
}
```

License
-------
Licensed under the [Apache License 2.0](https://github.com/webfolderio/ocean/blob/master/LICENSE).