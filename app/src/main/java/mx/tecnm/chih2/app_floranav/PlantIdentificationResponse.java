package mx.tecnm.chih2.app_floranav;

import java.util.List;

public class PlantIdentificationResponse {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        private Species species;
        private double score;

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class Species {
        private String scientificName;
        private List<String> commonNames;

        public String getScientificName() {
            return scientificName;
        }

        public void setScientificName(String scientificName) {
            this.scientificName = scientificName;
        }

        public List<String> getCommonNames() {
            return commonNames;
        }

        public void setCommonNames(List<String> commonNames) {
            this.commonNames = commonNames;
        }
    }
}