import java.util.*;

class Solution {
    private List<String> cityList = new ArrayList();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
            if(cityList.contains(cities[i])){
                answer += 1;
                cityList.add(cityList.remove(cityList.indexOf(cities[i])));
            } 
            else{
                answer += 5;
                if(cacheSize == 0) continue;
                if(cityList.size() == cacheSize) cityList.remove(0);
                cityList.add(cities[i]);
            }
        }
        return answer;
    }
}