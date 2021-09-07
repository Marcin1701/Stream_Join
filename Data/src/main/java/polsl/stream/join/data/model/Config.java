package polsl.stream.join.data.model;


public class Config {

    /**
     * Name of first CSV file to process
     */
    private String firstFile;

    /**
     * Name of second CSV file to process
     */
    private String secondFile;

    /**
     * Time between stream inits in ms
     */
    private Integer dataLifespan;

    /**
     * Automatic simulation
     */
    private Boolean automatic;

    /**
     * Type of join operation
     */
    private String joinType;

    public String getFirstFile() {
        return firstFile;
    }

    public String getSecondFile() {
        return secondFile;
    }

    public Integer getDataLifespan() {
        return dataLifespan;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public String getJoinType() {
        return joinType;
    }
}
