package com.example.franciscoandrade.soccerteams.presentation;

import java.util.HashMap;
import java.util.Map;

public class TeamsIcon {

  public Map<String, String> iconMap;

  public TeamsIcon() {
    fillMap();
  }

  private void fillMap() {
    iconMap= new HashMap<>();
    iconMap.put("athletic", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/primera/athletic_grande.png");
    iconMap.put("roma", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/champions/roma_grande.png");
    iconMap.put("espanyol", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/primera/espanyol_grande.png");
    iconMap.put("sevilla", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/champions/sevilla_grande.png");
    iconMap.put("atletico", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/champions/atletico_grande.png");
    iconMap.put("cska", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/champions/cska_grande.png");
    iconMap.put("deportivo", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/segunda/alaves_grande.png");
    iconMap.put("levante", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/primera/levante_mediano.png");
    iconMap.put("viktoria", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/champions/viktoria_grande.png");
    iconMap.put("barcelona", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/segunda/barcelona_mediano.png");
    iconMap.put("melilla", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/segunda/melilla_mediano.png");
    iconMap.put("madrid", "https://www.realmadrid.com/StaticFiles/RealMadrid/directo/statics/primera/Rm_grande.png");
  }
}
