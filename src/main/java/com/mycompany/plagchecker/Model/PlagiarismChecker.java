package com.mycompany.plagchecker.Model;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

public class PlagiarismChecker {
private static int searchwords=8;
int percent = 0;
private static StringBuilder eightwords = new StringBuilder();;
private static ArrayList<String> searchlist = new ArrayList<String>();

public ArrayList<String> searchwords(ArrayList<String> words, int pos) throws Exception {
        ArrayList<String> searchlist = new ArrayList<String>();
        ListIterator<String> wordsiterator = words.listIterator();
        while(wordsiterator.hasNext()){
            if(pos+1 == searchwords){
                eightwords.append(wordsiterator.next());
                wordsiterator.remove();
                pos=0;
                searchlist.add(eightwords.toString());
                eightwords.setLength(0);
            }else if(words.size() > 1 ){
                pos++;
                eightwords.append(wordsiterator.next()+"+");
                wordsiterator.remove();
            }else{
                eightwords.append(wordsiterator.next());
                wordsiterator.remove();
                pos=0;
                searchlist.add(eightwords.toString());
                eightwords.setLength(0);
        }
        
    }
        return searchlist;
    }
   
    public int splitwords(String s , int pos) throws Exception{
       /* ArrayList<Integer> resultlist = new ArrayList<>();
        ArrayList<String> wordlist = new ArrayList<>(Arrays.asList(article.split(" ")));
        */ 
        try {
                /*      
                for(String s:searchwords(wordlist,pos)){
                    resultlist.add(conn(s));
                    Thread.sleep(1000);
                }   
            List<Integer> negativeresultlist = resultlist.stream().filter(r -> !r.equals(0)).collect(Collectors.toList());
            percent = (negativeresultlist.size()*100) / resultlist.size();
                */
                percent = conn(s);
                if(percent > 0) {
                    percent = 1;
                }
                    Thread.sleep(1000);
            } catch (Exception ex) {
                return 55555;
            }
        
       return percent;
        
    }
    private int conn (String search)throws Exception {
        DataQuery dataquery = new DataQuery();
        String key=dataquery.findSettingsById().getGooglekey();
        URL url = new URL("https://www.googleapis.com/customsearch/v1?q="+search+"&cx=017576662512468239146%3Aomuauf_lfve&key="+key);
        doTrustToCertificates();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        String splitreader = "";
        StringBuilder ss = new StringBuilder();
        while((splitreader = reader.readLine()) != null){
            ss.append(splitreader);
    }
        JSONObject json = new JSONObject(ss.toString());
        JSONObject jsonrequest = json.getJSONObject("queries").getJSONArray("request").getJSONObject(0);
        return jsonrequest.getInt("totalResults");
        }
        
    
     public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
}
