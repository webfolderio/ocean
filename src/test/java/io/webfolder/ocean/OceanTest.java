package io.webfolder.ocean;

import static java.lang.String.format;
import static java.lang.System.getenv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import io.webfolder.ocean.api.DatabasesApi;
import io.webfolder.ocean.api.DomainsApi;
import io.webfolder.ocean.api.DropletsApi;
import io.webfolder.ocean.api.FirewallsApi;
import io.webfolder.ocean.api.RegionsApi;
import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.model.ListAllDomainsResponse;
import io.webfolder.ocean.model.ListAllDropletsResponse;
import io.webfolder.ocean.model.ListAllRegionsResponse;
import io.webfolder.ocean.model.ListDatabaseClustersResponse;
import io.webfolder.ocean.model.ListDropletFirewallsResponse;

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

    @Test
    public void testDroplets() {
        DropletsApi dropletsApi = new DropletsApi(client);
        ListAllDropletsResponse droplets = dropletsApi.listAllDroplets(0, 0, null);
        assertNotNull(droplets);
        assertFalse(droplets.getDroplets().isEmpty());
    }

    @Test
    public void testRegions() {
        RegionsApi regionsApi = new RegionsApi(client);
        ListAllRegionsResponse regions = regionsApi.listAllRegions(null, null);
        assertNotNull(regions);
        assertFalse(regions.getRegions().isEmpty());
    }

    @Test
    public void testDatabase() {
        DatabasesApi databaseApi = new DatabasesApi(client);
        ListDatabaseClustersResponse databases = databaseApi.listDatabaseClusters(null);
        assertNotNull(databases);
        assertFalse(databases.getDatabases().isEmpty());
    }

    @Test
    public void testDomain() {
        DomainsApi domainsApi = new DomainsApi(client);
        ListAllDomainsResponse domains = domainsApi.listAllDomains();
        assertNotNull(domains);
        assertFalse(domains.getDomains().isEmpty());
    }
}
