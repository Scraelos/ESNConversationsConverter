/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.esn.conversetionsdecoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author scraelos
 */
public class LuaDecoder {

    public static List<Location> decode(Path path) throws IOException {
        List<Location> result = new ArrayList<>();
        List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lines.size(); i++) {
            
            String line=lines.get(i);
            int indexOf = line.indexOf("--");
            if(indexOf!=-1) {
                line=line.substring(0, indexOf);
            }
            sb.append(line);
        }
        String luaSource = sb.toString();
        String jsonString = luaSource.replaceAll("=", ":").replaceAll("[\\[\\]]", "").replaceAll("\" :", "\":").replaceAll(",\\n(.+)\\}", "\n$1}");
        JSONObject locationsObject = new JSONObject(jsonString);
        Iterator locationsKeys = locationsObject.keys();
        while (locationsKeys.hasNext()) {
            String locationKey = (String) locationsKeys.next();
            Location location = new Location(locationKey);
            JSONObject npcsObject = locationsObject.getJSONObject(locationKey);
            Iterator npcsKeys = npcsObject.keys();
            while (npcsKeys.hasNext()) {
                String npcKey = (String) npcsKeys.next();
                Npc npc = new Npc(npcKey);
                location.getNpcs().add(npc);
                JSONObject npcContent = npcsObject.getJSONObject(npcKey);
                try {
                    JSONObject subtitlesObject = npcContent.getJSONObject("subtitle");
                    Iterator subtitlesKeys = subtitlesObject.keys();
                    while (subtitlesKeys.hasNext()) {
                        String subtitlekey = (String) subtitlesKeys.next();
                        Subtitle subtitle = new Subtitle(subtitlekey);
                        npc.getSubtitles().add(subtitle);
                    }
                } catch (org.json.JSONException ex) {

                }
                try {
                    JSONObject topicsObject = npcContent.getJSONObject("topics");
                    Iterator topicsKeys = topicsObject.keys();
                    while (topicsKeys.hasNext()) {
                        String topickey = (String) topicsKeys.next();
                        Topic topic = new Topic(topickey, topicsObject.getString(topickey));
                        npc.getTopics().add(topic);
                    }
                } catch (org.json.JSONException ex) {

                }
                try {
                    JSONObject greetingsObject = npcContent.getJSONObject("greetings");
                    Iterator greetingsKeys = greetingsObject.keys();
                    while (greetingsKeys.hasNext()) {
                        String greetingskey = (String) greetingsKeys.next();
                        Greeting greeting = new Greeting(greetingskey, greetingsObject.getString(greetingskey));
                        npc.getGreetings().add(greeting);

                    }
                } catch (org.json.JSONException ex) {

                }
            }
            result.add(location);
        }
        return result;
    }
}
