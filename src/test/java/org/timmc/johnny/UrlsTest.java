package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class UrlsTest {
    @Test
    public void scheme() {
        HostedUri ipfsUpper = Urls.parse("IPFS://BAFYBEICZSSCDSBS7FFQZ55ASQDF3SMV6KLCW3GOFSZVWLYARCI47BGF354/");
        assertEquals("IPFS", ipfsUpper.getSchemeRaw());
        assertEquals("ipfs", ipfsUpper.getScheme());
        // Just to show why this matters. Turkish maps I/i case conversions
        // differently from English, so the case-folding happening above
        // could very well produce "ıpfs" instead.
        Locale oldLocale = Locale.getDefault();
        Locale turkish = new Locale("tr", "TR");
        Locale.setDefault(turkish);
        try {
            // Demonstrate that Turkish case-folding is in effect
            assertEquals("\u0131pfs", ipfsUpper.getSchemeRaw().toLowerCase());
            // But johnny still produces the expected result, even under this locale
            assertEquals("ipfs", ipfsUpper.getScheme());
        } finally {
            Locale.setDefault(oldLocale);
        }
    }
}
