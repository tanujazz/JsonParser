package mygroup.myproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mygroup.myproject.model.Bid;
import mygroup.myproject.model.SeatBid;
import mygroup.myproject.model.SeatBidd;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {	
    	// bid-response.json
    	
    	String json = " {\r\n" + 
    			"   \"id\":\"7GavlTEwLjEqMJCsXDYRgAA.NDAuMQAAAABfH3Iz-0\",\r\n" + 
    			"   \"seatbid\":[\r\n" + 
    			"      {\r\n" + 
    			"         \"bid\":[\r\n" + 
    			"            {\r\n" + 
    			"               \"id\":\"7GavlTEwLjEqMJCsXDYRgAA.NDAuMQAAAABfH3Iz-0\",\r\n" + 
    			"               \"impid\":\"1\",\r\n" + 
    			"               \"price\":2.583,\r\n" + 
    			"               \"adm\":\"<script type='text/javascript'>var adContent = '';\\nadContent += '<!-- AdPlacement : y406192 --><!-- Oath SSP BannerAd DspId:10921, SeatId:CriteoCORP, DspCrId:4586-300x250-HTML --><!-- Ad Feedback Markup v1 -->' + '\\\\n';\\nadContent += '                  <scr' + 'ipt id=\\\"yax_meta\\\" type=\\\"text/x-yax-meta\\\">' + '\\\\n';\\nadContent += '                    {' + '\\\\n';\\nadContent += '                      \\\"fdb_url\\\": \\\"https://beap-bc.yahoo.com/af/us?bv=1.0.0&bs=(15n3d7f8b(gid$7GavlTEwLjEqMJCsXDYRgAA.NDAuMQAAAABfH3Iz-0,st$1548869882090000,li$9348,cr$4586-300x250-HTML,dmn$chewy.com,srv$4,exp$1548874682090000,ct$26,v$1.0,adv$9348,pbid$52469,seid$146750051))&al=(type${type},cmnt${cmnt},subo${subo})&r=81308\\\",' + '\\\\n';\\nadContent += '                      \\\"fdb_on\\\": 1,' + '\\\\n';\\nadContent += '                      \\\"fdb_exp\\\": 1548874682090,' + '\\\\n';\\nadContent += '                      \\\"fdb_intl\\\": \\\"en-US\\\",' + '\\\\n';\\nadContent += '                      \\\"err\\\": \\\"\\\"' + '\\\\n';\\nadContent += '                    }' + '\\\\n';\\nadContent += '                  </scr' + 'ipt>' + '\\\\n';\\nadContent += '                  <scr' + 'ipt type=\\\"text/javascript\\\">' + '\\\\n';\\nadContent += '                    (function() {' + '\\\\n';\\nadContent += '                      var w = window,' + '\\\\n';\\nadContent += '                        sf = (w && w.$sf && w.$sf.ext),' + '\\\\n';\\nadContent += '                        di = document.getElementById(\\\"yax_meta\\\");' + '\\\\n';\\nadContent += '' + '\\\\n';\\nadContent += '                      if (sf && typeof sf.msg == \\\"function\\\" && di) {' + '\\\\n';\\nadContent += '                        sf.msg({cmd:\\\"fdb\\\", data: di});' + '\\\\n';\\nadContent += '                      }' + '\\\\n';\\nadContent += '                    })();' + '\\\\n';\\nadContent += '                  </scr' + 'ipt><i' + 'mg src=\\\"https://us-east-1.onemobile.yahoo.com/admax/adEvent.do?tidi=770771327&amp;sitepid=217686&amp;posi=775139&amp;grp=%3F%3F%3F&amp;nl=1548869882336&amp;rts=1548869882090&amp;pix=1&amp;et=1&amp;a=7GavlTEwLjEqMJCsXDYRgAA.NDAuMQAAAABfH3Iz-0&amp;m=aXAtMTAtMjItOS0xNDM.&amp;p=MC4wMDI1ODM&amp;b=OTM0ODtDcml0ZW9DT1JQO2NoZXd5LmNvbTs7Ow..&amp;xdi=Pz8_fD8_P3w_Pz98MA..&amp;xoi=MHxVU0E.&amp;hb=true&amp;type=5&amp;brxdPublisherId=20459933223&amp;brxdSiteId=4452051&amp;brxdSectionId=146750051&amp;dety=2\\\" style=\\\"display:none;width:1px;height:1px;border:0;\\\" width=\\\"1\\\" height=\\\"1\\\" alt=\\\"\\\"/><scr' + 'ipt type=\\\"text/javascript\\\" src=\\\"https://ads.yahoo.com/get-user-id?ver=2&n=23351&ts=1548869882090&sig=XO8cInX2752Rk0Cz\\\"></scr' + 'ipt><scr' + 'ipt type=\\\\'text/javascript\\\\' src=\\\\'https://ads.us.criteo.com/delivery/r/ajs.php?did=5c51e0f91f0d37159f9e5ba9de54f100&z=CWCvEFPE5svXRN-RRTcfDHA_W-Std0Ua9F6ZUaAdO9c&u=%7CV8kCbu7qtdWyzVuY%2Fx8skjzBCwhYNSC4ZbpgZJnjBkQ%3D%7C&c1=R15UMXQIVgOy1yFtMk-OzAJcSoHsyh0W4_A8y9xheurCNoY02fQDvnjgW6eX00vtjaob-auVkC0Vi25ghcPHMF1Wm1zoq0umOduOCDfwfRDcZr4kGguL3XibdS0k6fTaUtRoPHRTQFFlZRa8oLN83icUbJFs9-Wr9df5FXGII00yVHwkPsJEofsozKB0Aiuh6SgE0f_TnWnRyBOJDT7eskodi3hxBerBiN7sSbZAsXgz9Uf1DS6Xks2hsbDu0A_eOIANllRVaWScun_Zb4BSVIdzRhPnNx815zw6jlanDg7ASAdSRbNgXJBX6DQ4gNNgMl7mINSbXHrLNFIG3_hK8gxX-EWrmWO2mxc0G9Uze-Ds9bbyYnf2LkXCT0HXjXZwZazFEAzD-y_EcZ2FHB2fXU9RFTKz2xdVZmUp2XfraJWmmNuCu7B77Q\\\\'></scr' + 'ipt><!-- Ads by Oath Ad Platforms SSP - Optimized by NEXAGE - Wednesday, January 30, 2019 12:38:02 PM EST -->' + '\\\\n';\\ndocument.write(adContent);</script>\",\r\n" + 
    			"               \"adomain\":[\r\n" + 
    			"                  \"chewy.com\"\r\n" + 
    			"               ],\r\n" + 
    			"               \"w\":300,\r\n" + 
    			"               \"h\":250,\r\n" + 
    			"               \"crid\":\"4586-300x250-HTML\"\r\n" + 
    			"            }\r\n" + 
    			"         ],\r\n" + 
    			"         \"seat\":\"9348\"\r\n" + 
    			"      },\r\n" + 
    			"      {\r\n" + 
    			"         \"bid\":[\r\n" + 
    			"            {\r\n" + 
    			"               \"id\":\"r48KQjc0LjbbJCqkWt8BeACCMTc0LgAAAABfH.XG-0\",\r\n" + 
    			"               \"impid\":\"1\",\r\n" + 
    			"               \"price\":5.01089295,\r\n" + 
    			"               \"adm\":\"<script type='text/javascript'>var adContent = '';\\nadContent += '<!-- AdPlacement : y402781 --><!-- Oath SSP BannerAd DspId:5357, SeatId:951609, DspCrId:950933 --><!-- Ad Feedback Markup v1 -->' + '\\\\n';\\nadContent += '                  <scr' + 'ipt id=\\\"yax_meta\\\" type=\\\"text/x-yax-meta\\\">' + '\\\\n';\\nadContent += '                    {' + '\\\\n';\\nadContent += '                      \\\"fdb_url\\\": \\\"https://beap-bc.yahoo.com/af/us?bv=1.0.0&bs=(15jccf9ca(gid$r48KQjc0LjbbJCqkWt8BeACCMTc0LgAAAABfH.XG-0,st$1548869882113000,li$9205,cr$950933,dmn$choosenissan.com,srv$4,exp$1548874682113000,ct$26,v$1.0,adv$9205,pbid$52469,seid$179355051))&al=(type${type},cmnt${cmnt},subo${subo})&r=44535\\\",' + '\\\\n';\\nadContent += '                      \\\"fdb_on\\\": 1,' + '\\\\n';\\nadContent += '                      \\\"fdb_exp\\\": 1548874682113,' + '\\\\n';\\nadContent += '                      \\\"fdb_intl\\\": \\\"en-US\\\",' + '\\\\n';\\nadContent += '                      \\\"err\\\": \\\"\\\"' + '\\\\n';\\nadContent += '                    }' + '\\\\n';\\nadContent += '                  </scr' + 'ipt>' + '\\\\n';\\nadContent += '                  <scr' + 'ipt type=\\\"text/javascript\\\">' + '\\\\n';\\nadContent += '                    (function() {' + '\\\\n';\\nadContent += '                      var w = window,' + '\\\\n';\\nadContent += '                        sf = (w && w.$sf && w.$sf.ext),' + '\\\\n';\\nadContent += '                        di = document.getElementById(\\\"yax_meta\\\");' + '\\\\n';\\nadContent += '' + '\\\\n';\\nadContent += '                      if (sf && typeof sf.msg == \\\"function\\\" && di) {' + '\\\\n';\\nadContent += '                        sf.msg({cmd:\\\"fdb\\\", data: di});' + '\\\\n';\\nadContent += '                      }' + '\\\\n';\\nadContent += '                    })();' + '\\\\n';\\nadContent += '                  </scr' + 'ipt><i' + 'mg src=\\\"https://us-east-1.onemobile.yahoo.com/admax/adEvent.do?tidi=770771327&amp;sitepid=217491&amp;posi=770108&amp;grp=%3F%3F%3F&amp;nl=1548869882322&amp;rts=1548869882113&amp;pix=1&amp;et=1&amp;a=r48KQjc0LjbbJCqkWt8BeACCMTc0LgAAAABfH.XG-0&amp;m=aXAtMTAtMjItOC0xMzI.&amp;p=MC4wMDUwMTA4OTI5NQ&amp;b=OTIwNTs5NTE2MDk7Y2hvb3Nlbmlzc2FuLmNvbTs7Ow..&amp;xdi=Pz8_fD8_P3w_Pz98MA..&amp;xoi=MHxVU0E.&amp;hb=true&amp;type=5&amp;brxdPublisherId=20459933223&amp;brxdSiteId=4902551&amp;brxdSectionId=179355051&amp;dety=2\\\" style=\\\"display:none;width:1px;height:1px;border:0;\\\" width=\\\"1\\\" height=\\\"1\\\" alt=\\\"\\\"/><scr' + 'ipt type=\\\"text/javascript\\\" src=\\\"https://ads.yahoo.com/get-user-id?ver=2&n=23351&ts=1548869882113&sig=Hyht3Fb27523Grw0\\\"></scr' + 'ipt><scr' + 'ipt type=\\\"text/javascript\\\" src=\\\"https://pr.ybp.yahoo.com/ab/secure/true/imp/8D3qCG6CwGKZlPAJ4F9G12NuBZbZHP4tsfa1D1dm3gn2_3InU7q94TUJJA_4XIfYJeIG1AMD8WwV5i6e7T9ahDYlOvDWM1AcBz_WfsJJ70Y0BPiKeFOkfiwtmFgX-uB6L63om57cB-2hE2KMcNLflW76YY92mzVC9KmA2RUpVwrVVza2EPdpK_buLPMZXPUnalHD3WKmhWh_l1GSwhB7WgO-GJ91r-KjbwZ2PuZ-PayvFxqhHVKGel-0-oWm3F6zdNsSHyl-MgVeTj9lS4Gm0VTsXB7j-MUNo22yEa0xGxXS24g0hZER2HbVOapzlbk6edciQPraggSvko2wq5IASOqzTAk33EOd95DDmAWjPDkHUKQIA0MuBKlaDNGLo5BDdVm6Xv6eDsGRWeLn4u5NGxv_9Qkl4IDp3zyS2Jt5_PVSJX3gDpfgbom5QpERpvpI-vK-GkdOARrpFpWm2nvbUt4W8_rwgh-FtKM-AVEfI8n_pF72XjSrwltH9QK22hrZR1vjDFXIx2CZKlZqIjcdxic6Gi2SY4J8Ohzx7Xv4g2jJtWNqY5z5j4AJ2AhGCi6U3xy-g6HbsWDmnEZG8Vrw4k7jFZTBKR3tw5wrOTOjnyH3RBLImeHc3I5dbT-ztyA4-Tt7oK-ArAwVegvn5md7wrn-ydUp_rpJ6CFWa_uhWtiqjAtNPqwtOZAWVlOwIQF4Rw35kPT5cXjl_TrXKsoPDBjV0050GOZosdB57hKInE1z0n2SqtBjJBDDG7qV8IBTRIza1vE1EY8dA-vKLh9o7moJKGVqxJBNUdiAx7CuSEqpP6o5qQwPXq0sZasG1vlqfC3BF3UIWKmgXNbOxJinN5Fp1eSryrXWy4AV2A56KxeA2_usAba7JSFOqK-KHZeuG0418y_VlrVvPwCwbKaYFBiWslTLxRq4EuaUFG4a_rfaiFbT22HnxlAa4UoffLbr1JV7CACkw9yj4d058ohIC2wP2tH9qD4o1A8__nKBIDSV6gEaBpiEqCYx9TmPF9jhUuWZslRc6cRZN9Pguko8ZMyr1ZhwitaFqRmxcUtuV4tNg3nOXzx16Gvt5CjTdELHejqhtbLGK3dkGjaHd6ZHJZ7u3oGcSH7IV9sinrAIk4t3htzLwIeLuwD1xu7UDlq9jAuBXKoF4yg4ZWcYtLQsol274hNCUss4JSNLbuPg3rvF-u4DiwxzizJSSpJ3VHQPGSZXH27c-NV7iBwJrKzlteyOc6Aac-HrQbZyfya2W2txGfmphUIVlHP6XVTtq0PbLMzdZ2dxFfh7rzQQ-Nz_GDNKi1FiuVDI2GX4-psLI8_HQH91uYxrXvbMCyE4kSg6I-TZkLq7JtvflryVgkzrYl5BwPXz7W5Hsy7LYrdQKuW-6WGBr5otjY3PrYT753L_6PVkxBIYyjjUQsUJ6fL_30Uvr1Jn2ZZ4GU0qq7lACPI5EqZslJ1ygyhoS8LW1elM9x0pVUn12Zdy5UMGg9t6gWWHouOjjaPG_5HNCj1H499D6NB_1euGnVtsMf8lXsXnaHAacSUGsJGMv0jKKeHRF-JP2ZT0DKW6zX8tg-vf87_jUaUcq0UccBop-cetDNke/wp/5.01089295/pclick/https%3A%2F%2Fus-east-1.onemobile.yahoo.com%2Fadmax%2FadClick.do%3Fdcn%3Dbrxd4451051%26n%3DOath%2BAd%26id%3Da8d83a4f34ef441083508209c09806d9%26tid%3D2c9d288b0165651e4ea11f5ae0a20036%26nid%3D8a808aee2edf264a012f0d6ee4e87844%26pos%3Dy402781%26grp%3D%253F%253F%253F%26nl%3D1548869882322%26rts%3D1548869882113%26a%3Dr48KQjc0LjbbJCqkWt8BeACCMTc0LgAAAABfH.XG-0%26rdm%3D1%26rd%3D\\\"></scr' + 'ipt><!-- Ads by Oath Ad Platforms SSP - Optimized by NEXAGE - Wednesday, January 30, 2019 12:38:02 PM EST -->' + '\\\\n';\\ndocument.write(adContent);</script>\",\r\n" + 
    			"               \"adomain\":[\r\n" + 
    			"                  \"choosenissan.com\"\r\n" + 
    			"               ],\r\n" + 
    			"               \"w\":300,\r\n" + 
    			"               \"h\":250,\r\n" + 
    			"               \"crid\":\"950933\"\r\n" + 
    			"            }\r\n" + 
    			"         ],\r\n" + 
    			"         \"seat\":\"9205\"\r\n" + 
    			"      }\r\n" + 
    			"   ]\r\n" + 
    			"}";
    	
    	// Parsing the bid-response.json
    	@SuppressWarnings("deprecation")
		JsonObject jsonObject = (JsonObject)new JsonParser(). parse(new FileReader("C:/Users/earotan/Desktop/bid-response.json"));
    	JsonArray response = (JsonArray) jsonObject.get("seatbid");
    	JsonObject body;
    	String id;
    	double price;
    	Map<String,Double> map = new HashMap<String,Double>();
    	
    	// Data Structure to store the parse json
    	for (int i=0;i<response.size();i++) {
    		 body = (JsonObject) response.get(i).getAsJsonObject();
        	JsonArray bid0 = (JsonArray)body.get("bid");
        	JsonObject bid1 = ((JsonObject) bid0.get(0));
        	id =bid1.get("id").getAsString();
        	price = bid1.get("price").getAsDouble();
        	map.put(id, price);
        	
    	}
    	
    	System.out.println(getMaxEntryInMapBasedOnValue(map));
    	
    	
}
    // Method to get the highest bid price and associated key
    
    public static <K, V extends Comparable<V> > Map.Entry<K, V>
    getMaxEntryInMapBasedOnValue(Map<K, V> map)
    {
        // To store the result
        Map.Entry<K, V> entryWithMaxValue = null;
  
        // Iterate in the map to find the required entry
        for (Map.Entry<K, V> currentEntry : map.entrySet()) {
  
            if (
                // If this is the first entry, set result as this
                entryWithMaxValue == null
  
                // If this entry's value is more than the max value
                // Set this entry as the max
                || currentEntry.getValue()
                           .compareTo(entryWithMaxValue.getValue())
                       > 0) {
  
                entryWithMaxValue = currentEntry;
            }
        }
  
        // Return the entry with highest value
        return entryWithMaxValue;
    }
}
