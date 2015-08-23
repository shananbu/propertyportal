package com.ats.property.model.sample;

import com.ats.property.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * The DummyDB.
 *
 * @author anbarasan.s
 */

public class DummyDB {
    private List<String> countries;
    private List<String> tags;
    private String[][] dataS = null;

    public DummyDB() {

        String data = "Afghanistan,	Albania, Algeria, Andorra, Angola"+
                "Equatorial Guinea,	Eritrea,Estonia,Ethiopia,Fiji,Finland,France,Gabon,Gambia,Georgia,Germany,"
                ;

        dataS = new String[][] {{"1","Afghanistan"} ,{"2","Albania"}, {"3", "Algeria"} , {"4", "Andorra"}, {"5","Angola"},
               {"6","Equatorial Guinea"},	{"7","Eritrea"},{"8","Estonia"}, {"9","Ethiopia"},
               {"10","Fiji"}, {"11","Finland"}, {"12","France"}, {"13","Germany"}};

        countries = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(data, ",");

        //Parse the country CSV list and set as Array
        while(st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }

        String strTags = "SharePoint, Spring, Struts, Java, JQuery, ASP, PHP, JavaScript, MySQL, ASP, .NET";
        tags = new ArrayList<String>();
        StringTokenizer st2 = new StringTokenizer(strTags, ",");

        //Parse the tags CSV list and set as Array
        while(st2.hasMoreTokens()) {
            tags.add(st2.nextToken().trim());
        }

    }

    public List<String[]> getCountryList(String query) {

        String country = null;
        query = query.toLowerCase();
        List<String[]> matched = new ArrayList<String[]>();
        for(String[] data : dataS) {
            country = data[1].toLowerCase();
            if(country.startsWith(query)) {
                matched.add(data);
            }
        }
        return matched;
    }

    public List<String> getTechList(String query) {
        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < tags.size(); i++) {
            country = tags.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(tags.get(i));
            }
        }
        return matched;
    }
}
